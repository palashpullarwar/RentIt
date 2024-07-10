package rent.property.RentIt.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.property.RentIt.config.JWTHelper;
import rent.property.RentIt.entityJwt.JWTRequest;
import rent.property.RentIt.entityJwt.JWTResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTHelper helper;
	
	@Autowired
	private AuthenticationManager manager;
	
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	  @PostMapping("/login")
	    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {
            logger.debug(request.getUsername() + " ------ " + request.getPassword());
	        this.doAuthenticate(request.getUsername(), request.getPassword());

	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
	        String token = this.helper.generateToken(userDetails);
	        logger.debug("token " + token);
	        JWTResponse response = JWTResponse.builder()
	                .token(token)
	                .username(userDetails.getUsername()).build();
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	  
	  private void doAuthenticate(String username, String password) {

	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
	        try {
	            manager.authenticate(authentication);


	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }
	  
	  @ExceptionHandler(BadCredentialsException.class)
	    public String exceptionHandler() {
		   logger.debug("Exception called");
	        return "Credentials Invalid !!";
	    }
	
}

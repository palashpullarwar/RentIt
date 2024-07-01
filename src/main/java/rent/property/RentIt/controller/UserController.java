package rent.property.RentIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rent.property.RentIt.entity.User;
import rent.property.RentIt.service.UserInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInterface userService;
	
	@PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
    	return userService.addUser(user);
    }
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/getUser/{userId}")
	public User getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
}

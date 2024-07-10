package rent.property.RentIt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.property.RentIt.entity.RentalDetails;
import rent.property.RentIt.entity.RentalDetailsDto;
import rent.property.RentIt.service.RentalDetailsInterface;

@RestController
@RequestMapping("/rental")
public class RentalDetailsController {

	@Autowired
	private RentalDetailsInterface rentalService;
	
	@PostMapping("/add")
	public RentalDetails addRentalDetails(@RequestBody RentalDetailsDto rentalDetailsDto) {
		return rentalService.addRentalDetails(rentalDetailsDto);
	}
	
	@GetMapping("/get")
	public List<RentalDetails> getRentalDetails(){
		return rentalService.getRentalDetails();
	}
	
	@GetMapping("/get/{rentalDetailsId}")
	public RentalDetails getRentalDetailsById(@PathVariable Integer rentalDetailsId) {
		return rentalService.getRentalDetailsById(rentalDetailsId);
	}
	
}

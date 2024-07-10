package rent.property.RentIt.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.property.RentIt.entity.Property;
import rent.property.RentIt.entity.RentalDetails;
import rent.property.RentIt.entity.RentalDetailsDto;
import rent.property.RentIt.entity.User;
import rent.property.RentIt.repository.RentalDetailsRepository;
import rent.property.RentIt.service.PropertyInterface;
import rent.property.RentIt.service.RentalDetailsInterface;
import rent.property.RentIt.service.UserInterface;

@Service
public class RentalDetailsService implements RentalDetailsInterface {

	@Autowired
	private RentalDetailsRepository rentalDetailsRepository;
	
	@Autowired
	private PropertyInterface propertyService;
	
	@Autowired
	private UserInterface userService;
	
	@Override
	public RentalDetails addRentalDetails(RentalDetailsDto rentalDetailsDto) {
		
		Property property = propertyService.getPropertyById(rentalDetailsDto.getPropertyId());
		
		List<User> tenants = new ArrayList<>();
		
		for(Integer tenant : rentalDetailsDto.getTenantId()) {
			
			User tenantUser = userService.getUserById(tenant);
			tenants.add(tenantUser);
		}
		
		RentalDetails rentalDetails = RentalDetails.builder().property(property).tenants(tenants).build();
		return rentalDetailsRepository.save(rentalDetails);
	}

	@Override
	public List<RentalDetails> getRentalDetails() {
		
		return rentalDetailsRepository.findAll();
	}

	@Override
	public RentalDetails getRentalDetailsById(Integer rentalDetailsId) {
		Optional<RentalDetails> rental = rentalDetailsRepository.findById(rentalDetailsId);
		return rental.get();
	}

}

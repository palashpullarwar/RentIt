package rent.property.RentIt.service;

import java.util.List;

import rent.property.RentIt.entity.RentalDetails;
import rent.property.RentIt.entity.RentalDetailsDto;

public interface RentalDetailsInterface {

    public RentalDetails addRentalDetails(RentalDetailsDto rentalDetailsDto);
	
	public List<RentalDetails> getRentalDetails();
	
	public RentalDetails getRentalDetailsById(Integer rentalDetailsId);
	
}

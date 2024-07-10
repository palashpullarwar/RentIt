package rent.property.RentIt.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.property.RentIt.entity.Property;
import rent.property.RentIt.entity.PropertyDto;
import rent.property.RentIt.entity.User;
import rent.property.RentIt.exception.DuplicateOwnerException;
import rent.property.RentIt.exception.UserNotFoundException;
import rent.property.RentIt.repository.PropertyRepository;
import rent.property.RentIt.service.PropertyInterface;
import rent.property.RentIt.service.UserInterface;

@Service
public class PropertyServiceImpl implements PropertyInterface{

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private UserInterface userService;

	
	@Override
	public Property addProperty(PropertyDto propertyDto) {
		User owner = userService.getUserById(propertyDto.getOwnerId());
	
	    List<Property> properties = getProperties();
	    
	    for(Property p : properties) {
	    	if(propertyDto.getPropertyName().equals(p.getPropertyName())) {
	    		throw new DuplicateOwnerException("One Property can only have one owner");
	    	}
	    }

		Property property = Property.builder().address(propertyDto.getAddress()).amenities(propertyDto.getAmenities())
				.deposite(propertyDto.getDeposite()).isBachelorsAllowed(propertyDto.isBachelorsAllowed()).numberOfBathroom(propertyDto.getNumberOfBathroom())
				.propertyName(propertyDto.getPropertyName()).propertyType(propertyDto.getPropertyType()).user(owner).build();
		
		return propertyRepository.save(property);
	}
	

	@Override
	public List<Property> getProperties() {
		
		return propertyRepository.findAll();
	}

	@Override
	public Property updateProperty(Property property) {
		Property existingProperty = getPropertyById(property.getPropertyId());
		existingProperty.setAddress(property.getAddress());
		existingProperty.setAmenities(property.getAmenities());
		existingProperty.setBachelorsAllowed(property.isBachelorsAllowed());
		existingProperty.setDeposite(property.getDeposite());
		existingProperty.setNumberOfBathroom(property.getNumberOfBathroom());
		existingProperty.setPropertyName(property.getPropertyName());
		existingProperty.setPropertyType(property.getPropertyType());
		existingProperty.setRent(property.getRent());
	
		Property updateProperty = propertyRepository.save(existingProperty);
		return updateProperty;
	}

	@Override
	public void deleteProperty(Integer propertyId) {
		propertyRepository.delete(getPropertyById(propertyId));
		
	}

	@Override
	public Property getPropertyById(Integer propertyId) {
		Optional<Property> getProperty = propertyRepository.findById(propertyId);
		Property property = getProperty.get();
		return property;
	}

	@Override
	public List<Property> getPropertiesByUserId(Integer userId) {

		return propertyRepository.findByUserUserId(userId);
	}

}

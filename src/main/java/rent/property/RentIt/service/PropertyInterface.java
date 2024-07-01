package rent.property.RentIt.service;

import java.util.List;
import rent.property.RentIt.entity.Property;


public interface PropertyInterface {

    public Property addProperty(Property property);
	
	public List<Property> getProperties();
	
	public Property updateProperty(Property property);
	
	public void deleteProperty(Integer propertyId);
	
	public Property getPropertyById(Integer propertyId);
	
	public List<Property> getPropertiesByUserId(Integer userId);
	
}

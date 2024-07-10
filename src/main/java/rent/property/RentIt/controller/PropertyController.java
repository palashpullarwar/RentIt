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
import rent.property.RentIt.entity.Property;
import rent.property.RentIt.entity.PropertyDto;
import rent.property.RentIt.service.PropertyInterface;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyInterface propertyService;
	
	@PostMapping("/add")
    public Property addProperty(@RequestBody PropertyDto propertyDto) {
    	return propertyService.addProperty(propertyDto);
    }
	
	@GetMapping("/get")
	public List<Property> getProperties(){
		return propertyService.getProperties();
	}
	
	@PutMapping("/update")
	public Property updateProperty(@RequestBody Property property) {
		return propertyService.updateProperty(property);
	}
	
	@DeleteMapping("/get/{propertyId}")
	public void deleteProperty(@PathVariable Integer propertyId) {
		propertyService.deleteProperty(propertyId);
	}
	
	@GetMapping("/get/{propertyId}")
	public Property getPropertyById(@PathVariable Integer propertyId) {
		return propertyService.getPropertyById(propertyId);
	}
	
	@GetMapping("/getProperties/{userId}")
	public List<Property> getPropertiesByUserId(@PathVariable Integer userId){
		return propertyService.getPropertiesByUserId(userId);
	}
	
}

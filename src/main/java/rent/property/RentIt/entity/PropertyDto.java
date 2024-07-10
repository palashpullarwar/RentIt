package rent.property.RentIt.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PropertyDto {

	private String propertyName;
	
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	private Amenities amenities;
	private Double rent;
	private boolean rentedOut;
	private Double deposite;
	private String address;
	private boolean isBachelorsAllowed;
	private Integer numberOfBathroom;
	private Integer ownerId;
}

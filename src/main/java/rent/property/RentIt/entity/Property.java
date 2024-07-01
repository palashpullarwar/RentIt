package rent.property.RentIt.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Property {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyId;
	private String propertyName;
	private PropertyType propertyType;
	
	@Embedded
	private Amenities amenities;
	private Double rent;
	private Double deposite;
	private String address;
	private boolean isBachelorsAllowed;
	private Integer numberOfBathroom;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}

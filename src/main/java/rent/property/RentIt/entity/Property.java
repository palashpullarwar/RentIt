package rent.property.RentIt.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Property {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyId;
	private String propertyName;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
    private boolean rentedOut;
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

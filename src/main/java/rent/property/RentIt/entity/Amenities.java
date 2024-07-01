package rent.property.RentIt.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Amenities {

	private boolean has24HoursWater;
	private boolean hasLift;
	private boolean hasSecurity;
	private boolean hasParking;
	private boolean hasGym;
	private boolean hasGarden;
	private boolean hasSwimmingPool;

}

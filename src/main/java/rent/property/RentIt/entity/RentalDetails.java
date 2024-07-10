package rent.property.RentIt.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rentalId;
	
	@OneToOne
	private Property property;
	
	@OneToMany
	//@JsonIgnore
	private List<User> tenants;
	
}

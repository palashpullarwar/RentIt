package rent.property.RentIt.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private int age;
	private String contact;
	private String email;
	private String address;
	private String state;
	private String city;
	private String country;
	
	private List<String> roles= new ArrayList<>();
	
//	@ManyToOne
//	@JoinColumn(name = "rental_id")
//	private RentalDetails rentalDetails;
	
}

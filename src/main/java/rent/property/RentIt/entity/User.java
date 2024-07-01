package rent.property.RentIt.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
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
	
}

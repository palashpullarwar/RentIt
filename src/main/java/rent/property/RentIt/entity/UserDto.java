package rent.property.RentIt.entity;

import lombok.Data;

@Data
public class UserDto {

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
	private Integer rentalId;
	
}

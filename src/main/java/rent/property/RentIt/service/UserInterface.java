package rent.property.RentIt.service;

import java.util.List;

import rent.property.RentIt.entity.User;
import rent.property.RentIt.entity.UserDto;

public interface UserInterface {

	public User addUser(UserDto userDto);
	
	public List<User> getUsers();
	
	public User updateUser(User user);
	
	public void deleteUser(Integer userId);
	
	public User getUserById(Integer userId);
	
}

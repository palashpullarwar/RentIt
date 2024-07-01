package rent.property.RentIt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.property.RentIt.entity.User;
import rent.property.RentIt.repository.UserRepository;
import rent.property.RentIt.service.UserInterface;

@Service
public class UserServiceImpl implements UserInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = getUserById(user.getUserId());
		existingUser.setUsername(user.getUsername());
		existingUser.setAddress(user.getAddress());
		existingUser.setAge(user.getAge());
		existingUser.setCity(user.getCity());
		existingUser.setContact(user.getContact());
		existingUser.setCountry(user.getCountry());
		existingUser.setEmail(user.getEmail());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setPassword(user.getPassword());
		existingUser.setState(user.getState());
		
		User saveUser = userRepository.save(existingUser);
		return saveUser;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = getUserById(userId);
		userRepository.delete(user);
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.get();
	}

}

package rent.property.RentIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rent.property.RentIt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
	
}

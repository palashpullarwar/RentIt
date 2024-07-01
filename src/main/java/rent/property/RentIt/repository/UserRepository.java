package rent.property.RentIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rent.property.RentIt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

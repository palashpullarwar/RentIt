package rent.property.RentIt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rent.property.RentIt.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer>{

	public List<Property> findByUserUserId(Integer userId);
}

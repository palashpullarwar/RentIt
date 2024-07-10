package rent.property.RentIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rent.property.RentIt.entity.RentalDetails;

public interface RentalDetailsRepository extends JpaRepository<RentalDetails, Integer>{

}

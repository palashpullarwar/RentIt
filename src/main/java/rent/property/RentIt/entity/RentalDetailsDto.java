package rent.property.RentIt.entity;

import java.util.List;

import lombok.Data;

@Data
public class RentalDetailsDto {

	private Integer propertyId;
    private List<Integer> tenantId;	
	
}

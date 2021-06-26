package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.customEntity.JsonbAccountInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerStaffVerifyAccountUpdateAddDto {
    @JsonIgnore
    private int id;
    private int employerId;
    private JsonbAccountInformation tempAccountInformation;
}

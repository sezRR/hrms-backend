package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {
    @JsonIgnore
    private int id;
    private int employerId;
    private int jobPositionId;
    private int cityId;
    private String advertDescription;
    private int minSalary;
    private int maxSalary;
    private short openPosition;
    private LocalDate createdDate;
    private LocalDate deadline;
}

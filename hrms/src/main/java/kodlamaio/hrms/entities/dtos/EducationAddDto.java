package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationAddDto {
    @JsonIgnore
    private int id;
    private int resumeId;
    private String schoolName;
    private int graduateId;
    private String schoolDepartment;
    private LocalDate startedDate;
    private LocalDate endedDate;
    private LocalDate createdDate;
}

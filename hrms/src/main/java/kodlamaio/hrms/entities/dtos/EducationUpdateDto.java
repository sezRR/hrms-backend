package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationUpdateDto {
    private int id;
    private int resumeId;
    private int graduateId;
    private String schoolName;
    private String schoolDepartment;
    private LocalDate startedDate;
    private LocalDate endedDate;
}

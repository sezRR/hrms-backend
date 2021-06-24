package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceUpdateDto {
    private int id;
    private int resumeId;
    private String companyName;
    private int jobPositionId;
    private LocalDate startedDate;
    private LocalDate endedDate;
}

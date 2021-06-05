package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {
    @JsonIgnore
    private int id;
    private int resumeId;
    private String description;
    private LocalDate createdDate;
}

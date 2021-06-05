package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeAddDto {
    @JsonIgnore
    private int id;
    private int candidateId;
    private String githubLink;
    private String linkedinLink;
    private String photo;
    private String description;
    private LocalDate createdDate;
    private LocalDate updateDate;
}

package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeUpdateDto {
    private int id;
    private String githubLink;
    private String linkedinLink;
    private String photo;
    private String description;
}

package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    @JsonIgnore
    private int id;
    private int resumeId;
    private String language;
    private char langLevel;
    private LocalDate createdDate;
}

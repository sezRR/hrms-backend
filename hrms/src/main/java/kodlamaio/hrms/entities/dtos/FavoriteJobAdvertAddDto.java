package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteJobAdvertAddDto {
    @JsonIgnore
    private int id;
    private int candidateUserId;
    private int jobAdvertId;
}

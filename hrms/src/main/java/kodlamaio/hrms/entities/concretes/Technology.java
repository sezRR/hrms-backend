package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_techs")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @NotBlank(message = "Boş geçilemez")
    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDate createdDate;

}

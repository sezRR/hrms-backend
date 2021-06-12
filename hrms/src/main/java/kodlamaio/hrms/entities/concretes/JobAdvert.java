package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private EmployerUser employer;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "position_id")
    private JobPosition position;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "working_place_id")
    private WorkingPlace workingPlace;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "working_time_id")
    private WorkingTime workingTime;

    @Max(256)
    @NotBlank
    @Column(name = "advert_description")
    private String advertDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @NotBlank
    @Column(name = "open_position")
    private short openPosition;

    @Column(name = "deadline")
    private LocalDate deadline;

    @NotBlank
    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "is_active")
    private boolean isActive = false;
}

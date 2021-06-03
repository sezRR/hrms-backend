package kodlamaio.hrms.entities.concretes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = CandidateUser.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
    private CandidateUser candidate;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedLink;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @OneToMany(mappedBy = "resume")
    private List<Technology> technologies;

    @OneToMany(mappedBy = "resume")
    private List<Education> education;

    @OneToMany(mappedBy = "resume")
    private List<JobExperience> jobExperiences;
}

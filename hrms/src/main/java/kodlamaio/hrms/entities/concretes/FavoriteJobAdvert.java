package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favorite_job_adverts")
public class FavoriteJobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = CandidateUser.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_user_id", referencedColumnName = "id", nullable = false)
    private CandidateUser candidateUser;

    @ManyToOne(targetEntity = JobAdvert.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_advert_id", referencedColumnName = "id", nullable = false)
    private JobAdvert jobAdvert;

    @Column(name = "created_date")
    private LocalDate createdDate;
}

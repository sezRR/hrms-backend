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
@Table(name = "job_advert_staff_verify")
public class JobAdvertStaffVerify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_advert_id")
    private JobAdvert jobAdvert;

    @ManyToOne
    @JoinColumn(name = "confirm_staff_id")
    private StaffUser staffUser;

    @Column(name = "confirm_date")
    private LocalDate confirmDate;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "created_date")
    private LocalDate createdDate;
}

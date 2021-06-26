package kodlamaio.hrms.entities.concretes;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import kodlamaio.hrms.entities.customEntity.JsonType;
import kodlamaio.hrms.entities.customEntity.JsonbAccountInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employer_user_staff_verify_account_update")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class EmployerStaffVerifyAccountUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private EmployerUser employer;

    @ManyToOne
    @JoinColumn(name = "confirm_staff")
    private StaffUser staffUser;

    @Column(name = "confirm_date")
    private LocalDate confirmDate;

    @Column(name = "is_confirmed")
    private boolean isConfirmed = false;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "temp_account_information", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private JsonbAccountInformation tempAccountInformation;
}

package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employer_users")
public class EmployerUser extends User implements Serializable {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name="phone_number")
    private String phoneNumber;
}

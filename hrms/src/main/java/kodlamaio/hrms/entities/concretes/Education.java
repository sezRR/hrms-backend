package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_edu")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column(name = "school_name")
    @NotBlank(message = "Field is required")
    private String schoolName;

    @ManyToOne(targetEntity = Graduate.class)
    @JoinColumn(name = "graduate_id", referencedColumnName = "id", nullable = false)
    private Graduate graduate;

    @Column(name = "school_department")
    @NotBlank(message = "Field is required")
    private String schoolDepartment;

    @Column(name = "started_date")
    private LocalDate startedDate;

    @Column(name = "ended_date")
    private LocalDate endedDate;

    @Column(name = "created_date")
    private LocalDate createdDate;
}

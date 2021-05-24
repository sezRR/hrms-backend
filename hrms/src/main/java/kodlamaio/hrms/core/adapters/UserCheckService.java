package kodlamaio.hrms.core.adapters;

import java.time.LocalDate;

public interface UserCheckService {
    Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear);
}

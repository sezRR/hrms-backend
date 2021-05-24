package kodlamaio.hrms.core.adapters;

import java.time.LocalDate;

public class FakeMernisServiceAdapter implements UserCheckService {
    @Override
    public Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear) {
        return true;
    }
}

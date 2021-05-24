package kodlamaio.hrms.business.concretes.checkHelper;

import kodlamaio.hrms.entities.concretes.EmployerUser;

public class EmployerUserCheckHelper {
    public static boolean allFieldsAreRequired(EmployerUser employerUser){
        if (employerUser.getEmail().strip().isEmpty()
                || employerUser.getPassword().strip().isEmpty()
                || employerUser.getCompanyName().strip().isEmpty()
                || employerUser.getPhoneNumber().strip().isEmpty()
                || employerUser.getWebAddress().strip().isEmpty())
        {
            return false;
        }
        return true;
    }
}

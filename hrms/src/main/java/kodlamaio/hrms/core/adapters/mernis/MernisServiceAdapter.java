package kodlamaio.hrms.core.adapters.mernis;

import java.time.LocalDate;
import kodlamaio.hrms.MernisService.BCFKPSPublicSoap;
import org.springframework.stereotype.Component;

@Component
public class MernisServiceAdapter implements UserCheckService {
    @Override
    public Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear) {
        BCFKPSPublicSoap soapClient = new BCFKPSPublicSoap();
        boolean result = false;
        try {
            result = soapClient.TCKimlikNoDogrula(Long.parseLong(nationalityId), firstName, lastName, dateOfBirthYear.getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

package kodlamaio.hrms.entities.customEntity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonbAccountInformation implements Serializable {
    private String email;
    private String password;
    private String companyName;
    private String webAddress;
    private String phoneNumber;

    @Override
    public String toString(){
        return ""+this.getEmail()+","+this.getPassword()+","+this.getCompanyName()+","+this.getWebAddress()+","+this.getPhoneNumber()+"";
    }
}

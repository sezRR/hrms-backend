package kodlamaio.hrms.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryUserConfig {
    @Bean(name = {"getCloudinaryUser", "Cloudinary"})
    public Cloudinary getCloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "szrr",
                "api_key", "245554566573417",
                "api_secret", "1HekDSlJ1D0UilIScmg7RAkcKEY"));
    }
}

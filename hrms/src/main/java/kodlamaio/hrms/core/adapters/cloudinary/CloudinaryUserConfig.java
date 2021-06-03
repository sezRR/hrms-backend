package kodlamaio.hrms.core.adapters.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;

public class CloudinaryUserConfig {
    @Bean(name = {"getCloudinaryUser", "Cloudinary"})
    public Cloudinary getCloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "szrr",
                "api_key", "245554566573417",
                "api_secret", "1HekDSlJ1D0UilIScmg7RAkcKEY"));
    }
}

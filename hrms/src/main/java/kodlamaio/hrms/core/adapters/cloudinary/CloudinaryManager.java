package kodlamaio.hrms.core.adapters.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService {

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CloudinaryUserConfig.class);
        this.cloudinary = (Cloudinary) context.getBean("getCloudinaryUser");
    }

    @Override
    public DataResult<Map> upload(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return new SuccessDataResult<>(uploadResult);
    }
}

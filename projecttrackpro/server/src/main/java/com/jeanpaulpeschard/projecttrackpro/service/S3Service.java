import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S3Service {
    @Autowired
    private AmazonS3 amazonS3;

    public void uploadFile(String bucketName, String fileName, File file) {
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file));
    }
}

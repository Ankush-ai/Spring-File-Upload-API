package ImageUpload.ImageUploadProject.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ImageUpload.ImageUploadProject.Entity.ProductImage;
import ImageUpload.ImageUploadProject.Repository.ProductRepository;

@Service
public class ProductImageService {

    @Autowired
    ProductRepository prodRepo;

    private final String PATH = "C:\\Users\\Hp\\eclipse-workspace";

    public ProductImage uploadImage(MultipartFile file) throws IOException {
        String fullPath = PATH + file.getOriginalFilename();
        ProductImage pImage = new ProductImage();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImagePath(fullPath);

        // Save the file
        byte[] bytes = file.getBytes();
        Path path = Paths.get(fullPath);
        Files.write(path, bytes);

        return prodRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName) throws IOException {
        Optional<ProductImage> imageObject = prodRepo.findByName(fileName);
        if (imageObject.isPresent()) {
            String fullPath = imageObject.get().getImagePath();
            return Files.readAllBytes(Paths.get(fullPath));
        } else {
            // Handle case when image is not found
            return new byte[0];
        }
    }
}

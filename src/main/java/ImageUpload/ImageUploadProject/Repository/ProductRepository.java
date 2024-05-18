package ImageUpload.ImageUploadProject.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ImageUpload.ImageUploadProject.Entity.ProductImage;

public interface ProductRepository extends JpaRepository<ProductImage, Long> {
    Optional<ProductImage> findByName(String fileName);

    @SuppressWarnings("unchecked")
	// Change the method name to 'save'
    ProductImage save(ProductImage pImage);
}

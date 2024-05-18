package ImageUpload.ImageUploadProject.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ImageUpload.ImageUploadProject.Service.ProductImageService;

@RestController
@RequestMapping("/api/v1")
public class ProductImageController {

	@Autowired
	private ProductImageService prodService;

	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/upload")
	public void uplaodImage(@RequestParam("productImage") MultipartFile file) throws IOException {
		prodService.uploadImage(file);

	}

	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
		byte[] image = prodService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(
				"\"C:\\Users\\Hp\\Downloads\\Chest_x-ray_of_bronchiectasis_post-primary_pulmonary_tuberculosis.jpg\""))
				.body(image);
	}

}

package ImageUpload.ImageUploadProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_peoduct_image")
public class ProductImage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String type;
	private String imagePath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public ProductImage(Long id, String name, String type, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imagePath = imagePath;
	}
	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", name=" + name + ", type=" + type + ", imagePath=" + imagePath + "]";
	}
	

}

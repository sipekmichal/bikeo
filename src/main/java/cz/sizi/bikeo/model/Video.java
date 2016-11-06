package cz.sizi.bikeo.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Video {

	/**
	 * Attributes
	 * */
	@Id
	@GeneratedValue
	private Long id;

	//YouTube ID
	private String yid;
	
	private String url;

	@Size(min = 3, max = 250)
	private String title;

	@Size(min = 3)
	private String content;

	private Date publishDate;

	private int enabled;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id")
	private User user;

	@NotEmpty
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "video_category", joinColumns = { @JoinColumn(name = "video_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories;
	
	@Transient
	private MultipartFile imageMultipart;

	@Lob
	@Transient
	private Blob image;

	/**
	 * Getters and setters
	 * */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public MultipartFile getMultipartImage() {
		return imageMultipart;
	}

	public void setImage(MultipartFile image) {
		this.imageMultipart = image;
	}
	
	public Blob getImage() {
		return image;
	}

	public void setImageBlob(Blob image) {
		this.image = image;
	}

	public String getYid() {
		return yid;
	}

	public void setYid(String yid) {
		this.yid = yid;
	}
	
}

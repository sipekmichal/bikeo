package cz.sizi.bikeo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Video {

	/**
	 * Attributes
	 * */
	@Id
	@GeneratedValue
	private int id;

	//YouTube ID
	private String yid;
	
	private String url;

	@Size(min = 3, max = 250)
	private String title;

	@Size(min = 3)
	private String content;

	private Date publishDate;

	private boolean enabled;
	
	private boolean confirmed;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id")
	private User user;

	@NotEmpty
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "video_category", joinColumns = { @JoinColumn(name = "video_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories;

	/**
	 * Getters and setters
	 * */
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getYid() {
		return yid;
	}

	public void setYid(String yid) {
		this.yid = yid;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
}

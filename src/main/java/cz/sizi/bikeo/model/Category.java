package cz.sizi.bikeo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Category {

	/**
	 * Attributes
	 * */
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, max = 20, message = "Název musí obsahovat 3-20 znakù!")
	private String name;

	@ManyToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
	private List<Video> videos;

	/**
	 * Getters and setters
	 * */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

}

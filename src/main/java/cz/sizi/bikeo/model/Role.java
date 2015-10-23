package cz.sizi.bikeo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Role entity
 * 
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */

@Entity
public class Role {

	/**
	 * Attributes
	 * */
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 3, max = 60)
	private String name;

	@NotEmpty
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {
	}

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

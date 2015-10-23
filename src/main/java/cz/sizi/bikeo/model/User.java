package cz.sizi.bikeo.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * User entity
 * 
 * @author Sipek Michal
 * @version 1.0
 * @since 2014-10-13
 */

@Entity
public class User {

	/**
	 * Attributes
	 * */
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, max = 20, message = "Jméno musí obsahovat 3-20 znakù!")
	private String name;

	@Size(min = 1, message = "Špatný formát mailové adresy!")
	@Email(message = "Špatný formát mailové adresy!")
	private String email;

	@Size(min = 3, message = "Heslo musí obsahovat nejménì 3 znaky!")
	private String password;

	private int enable;

	@NotEmpty
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private List<Role> roles;

	public User() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

}

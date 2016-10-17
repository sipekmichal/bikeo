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
	private String passwd;

	private int enabled;

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.passwd = encoder.encode(passwd);
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}

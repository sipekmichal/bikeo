package cz.sizi.bikeo.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	/**
	 * Attributes
	 */
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
	
	@Transient
	@Size(min = 3, message = "Heslo musí obsahovat nejménì 3 znaky!")
	private String confirmPasswd;
	
	//jak zobrazit tuto hlášku v jsp?
	@AssertTrue(message = "Hesla musí být totožná!")
	private boolean isValid() {
		return this.passwd.equals(this.confirmPasswd);
	}

	private int enabled;

	// @NotEmpty // - delam kvuli formulari - vynucuje si to zadat roli z jsp
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	public User() {
	}

	/**
	 * Getters and setters
	 */
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
		this.passwd = passwd;
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

	public String getConfirmPasswd() {
		return confirmPasswd;
	}

	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}
}

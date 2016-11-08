package cz.sizi.bikeo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	/**
	 * Attributes
	 */
	@Id
	@GeneratedValue
	private int id;

	@Size(min = 3, max = 20, message = "Jméno musí obsahovat 3-20 znaků!")
	private String name;

	@Size(min = 1, message = "Špatný formát mailové adresy!")
	@Email(message = "Špatný formát mailové adresy!")
	private String email;

	@NotNull
	@Size(min = 6, message = "Heslo musí obsahovat nejméně 6 znaků!")
	private String passwd;

	@Transient
	private String confirmPasswd;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	private boolean enabled;

	public User() {
	}

	public User(String email, String name, String password, boolean enabled) {
		this.email = email;
		this.name = name;
		this.passwd = password;
		this.enabled = enabled;
	}

	public User(String email, String name, String password, boolean enabled, Set<Role> roles) {
		this.email = email;
		this.name = name;
		this.passwd = password;
		this.enabled = enabled;
		this.roles = roles;
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

	public String getConfirmPasswd() {
		return confirmPasswd;
	}

	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}

	@AssertTrue(message = "Hesla se musí shodovat!")
	public boolean isValid() {
		return this.passwd.equals(this.confirmPasswd);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}

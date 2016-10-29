package cz.sizi.bikeo.model;

import java.util.Set;

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
	private Long id;

	@Size(min = 3, max = 20, message = "Jméno musí obsahovat 3-20 znaků!")
	private String name;

	@Size(min = 1, message = "Špatný formát mailové adresy!")
	@Email(message = "Špatný formát mailové adresy!")
	private String email;

	@Size(min = 3, message = "Heslo musí obsahovat nejméně 3 znaky!")
	private String passwd;

	@Transient
	@Size(min = 3, message = "Heslo musí obsahovat nejméně 3 znaky!")
	private String confirmPasswd;

	@AssertTrue(message = "Hesla se musí shodovat!")
	private boolean isValid() {
		return this.passwd.equals(this.confirmPasswd);
	}

	private int enabled;
	
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public User() {
		
	}

	/**
	 * Getters and setters
	 */
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
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

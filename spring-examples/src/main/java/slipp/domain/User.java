package slipp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final GuestUser GUEST_USER = new GuestUser();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private Long userId;

	@Column(name = "username")
	@Size(min = 4, max = 12)
	private String userName;

	@Column(name = "password")
	@Size(min = 4, max = 12)
	private String password;

	@Column(name = "email")
	@Email
	private String email;

	@Column(name = "enabled")
	private int enabled;

	public User() {

	}

	public User(User user) {
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.password = user.password;
		this.enabled = user.enabled;
	}

	public User(String userName, String password, String email, int enabled) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Long getUserid() {
		return userId;
	}

	public void setUserid(Long userid) {
		this.userId = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean matchPassword(String password) {
	    return this.password.equals(password);
	}
	
	public boolean isGuestUser() {
		return false;
	}
	
	@SuppressWarnings("serial")
    private static class GuestUser extends User {
		@Override
		public boolean isGuestUser() {
			return true;
		}
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", enabled=" + enabled + "]";
	}
}
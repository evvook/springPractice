package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="usr")
public class User implements Serializable{
	@Id
	private String userId;
	
	private String password;
	
	public String firstName;
	
	public String lastName;
	
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public RoleName getRoleName() {
		// TODO Auto-generated method stub
		return roleName;
	}

	public String getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

	public void setUserId(String userId) {
		// TODO Auto-generated method stub
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	public void setRoleName(RoleName roleName) {
		// TODO Auto-generated method stub
		this.roleName = roleName;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
}

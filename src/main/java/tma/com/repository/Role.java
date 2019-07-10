package tma.com.repository;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{

	private static final long serialVersionUID = -8774330733094861362L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;
	
	@Column(name ="role_name")
	private String rolename;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public Role(int id, String rolename, Set<User> users) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.users = users;
	}
	
	public Role() {
    }

    public Role(String name) {
        this.rolename = name;
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}

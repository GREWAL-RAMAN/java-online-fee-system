package grewal.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(
				   name = "User.findUnassignedUsers",
				   query = "SELECT u FROM User u WHERE u.id NOT IN (SELECT c.assignedUserId FROM CD c)"),
@NamedQuery(
		   name = "User.findUnassignedUsers",
		   query = "SELECT u FROM User u WHERE u.id NOT IN (SELECT c.assignedUserId FROM CD c)"
		)})
public class user {
	

}

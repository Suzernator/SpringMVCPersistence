 /** @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */

package coffee.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String dinerPreference;
	@Autowired
	private Order order;

	public Customer() {
		// TODO Auto-generated constructor stub
		super();
		this.dinerPreference = "to-go";
	}

	public Customer(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Customer(String firstName, String lastName, String dinerPreference) {
		// TODO Auto-generated constructor stub
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastName = lastName;
	}
	
	public Customer(long id, String firstName, String lastName, String dinerPreference) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dinerPreference = dinerPreference;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDinerPreference() {
		return dinerPreference;
	}

	public void setDinerPreference(String dinerPreference) {
		this.dinerPreference = dinerPreference;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dinerPreference="
				+ dinerPreference + ", order=" + order + "]";
	}
}

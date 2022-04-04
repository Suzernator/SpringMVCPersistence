/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */

package coffee.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Order {
	private String drink;
	private String food;


	public Order() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Order(String drink, String food) {
		// TODO Auto-generated constructor stub
		super();
		this.drink = drink;
		this.food = food;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Order [drink=" + drink + ", food=" + food + "]";
	}

}

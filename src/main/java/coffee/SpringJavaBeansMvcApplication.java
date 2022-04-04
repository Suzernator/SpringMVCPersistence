package coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import coffee.beans.Customer;
import coffee.beans.Order;
import coffee.controller.BeanConfiguration;
import coffee.repository.CustomerRepository;

@SpringBootApplication
public class SpringJavaBeansMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaBeansMvcApplication.class, args);
		}
	
	@Autowired
	CustomerRepository repo;

	public void run(String...args)throws Exception {
		// TODO Auto-generated constructor stub
		
	ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
	Customer c = appContext.getBean("customer", Customer.class);
	c.setDinerPreference("to-go");
	repo.save(c);
	
	Customer eC = new Customer("Emma", "March", "dine-in");
	Order eO = new Order("Hot Chocolate", "Cookie");
	eC.setOrder(eO);
	repo.save(eC);
	
	List<Customer> allCustomers = repo.findAll();
	for(Customer customers: allCustomers) {
		System.out.println(customers.toString());
	}
	
	((AbstractApplicationContext) appContext).close();

	}
}

/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */

package coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import coffee.beans.Customer;
import coffee.repository.CustomerRepository;

@Controller
public class WebController {
	@Autowired
	CustomerRepository repo;

	@GetMapping({"/", "/viewAll"})
		public String viewAllCustomers(Model model) {
			if(repo.findAll().isEmpty()) {
				return addNewCustomer(model);
			}
			
		model.addAttribute("customers", repo.findAll());
		return "results";
	}

	@GetMapping("/inputCustomer")
		public String addNewCustomer(Model model) {
			Customer c = new Customer();
			model.addAttribute("newCustomer", c);
			return "input";
	}
	
	@PostMapping("/inputCustomer")
		public String addNewCustomer(@ModelAttribute Customer c, Model model) {
			repo.save(c);
			return viewAllCustomers(model);
	}
	
	@GetMapping("/edit/{id}")
		public String showUpdateCustomer(@PathVariable("id") long id, Model model) {
			Customer c = repo.findById(id).orElse(null);
			model.addAttribute("newCustomer", c);
			return "input";
	}
	
	@PostMapping("/update/{id}")
		public String reviseCustomer(Customer c, Model model) {
			repo.save(c);
			return viewAllCustomers(model);
	}
	
	@GetMapping("/delete/{id}")
		public String deleteUser(@PathVariable("id") long id, Model model) {
			Customer c = repo.findById(id).orElse(null);
			repo.delete(c);
			return viewAllCustomers(model);
	}
	
}

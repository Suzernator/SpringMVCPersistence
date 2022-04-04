/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */

package coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coffee.beans.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}

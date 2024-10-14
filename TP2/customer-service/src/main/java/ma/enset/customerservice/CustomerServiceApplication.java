package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			//Inserting customer 1
			customerRepository.save(new Customer().builder()
					.name("Hassani")
					.email("hassani@gmail.com")
					.build());
			//Inserting customer 1
			customerRepository.save(new Customer().builder()
					.name("Mouradi")
					.email("mouradi@gmail.com")
					.build());
			//Inserting customer 1
			customerRepository.save(new Customer().builder()
					.name("Telmsani")
					.email("telmsani@gmail.com")
					.build());
			List<Customer> customersList = customerRepository.findAll();
			for (Customer customer : customersList) {
				System.out.println(customer);
			}
		};
	}

}

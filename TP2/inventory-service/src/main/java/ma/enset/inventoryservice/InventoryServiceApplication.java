package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository,
							RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args -> {
			productRepository.save(new Product().builder()
					.name("Computer")
					.price(1000)
					.quantity(10)
					.build());
			productRepository.save(new Product().builder()
					.name("Printer")
					.price(1203)
					.quantity(2)
					.build());
			productRepository.save(new Product().builder()
					.name("Phone")
					.price(650)
					.quantity(6)
					.build());
			List<Product> products = productRepository.findAll();
			products.forEach(System.out::println);
		};
	}
}

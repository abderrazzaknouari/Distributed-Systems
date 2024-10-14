package ma.enset.billingservice;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.feign.ProductRestClient;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.model.Product;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							ProductRestClient productRestClient,
							CustomerRestClient customerRestClient) {
		return args -> {
			Customer customer = customerRestClient.getCustomerById(1L);
			System.out.println(customer);
			Bill bill1 = billRepository.save(new Bill().builder()
					.billingDate(new Date())
					.customerId(customer.getId())
					.build());
			PagedModel<Product> products = productRestClient.findAll(0, 20);
			products.forEach(p -> {
				productItemRepository.save(new ProductItem().builder()
						.price(p.getPrice())
						.quantity(1+ new Random().nextInt(100))
						.productId(p.getId())
						.bill(bill1)
						.build());
			});
		};
	}
}

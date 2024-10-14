package ma.enset.billingservice.web;

import lombok.AllArgsConstructor;
import ma.enset.billingservice.config.BillingConfig;
import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.feign.ProductRestClient;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;
    private final BillingConfig billingConfig;

    @GetMapping("/fullBill/{id}")
    public Bill fullBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(productRestClient.getProductById(pi.getProductId()));
        });
        return bill;
    }

    @GetMapping("/message")
    public String getMessage() {
        return billingConfig.getMessage();
    }
}

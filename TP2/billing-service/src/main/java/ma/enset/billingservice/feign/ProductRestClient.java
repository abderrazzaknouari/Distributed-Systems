package ma.enset.billingservice.feign;

import jakarta.ws.rs.QueryParam;
import ma.enset.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);

    @GetMapping(path = "/products")
    PagedModel <Product> findAll(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);
}

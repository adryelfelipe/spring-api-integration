package clientservice.Infra.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "productFeignClient", url = "${product.service.url}")
public interface ProductFeignClient {

    @PostMapping("/auth")
    String authenticate(@RequestParam String password, @RequestParam Long clientId);
}

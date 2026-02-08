package clientservice.Infra.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "productFeignClient", url = "${product.service.url}")
public interface ClientFeignClient {

    @PostMapping("/auth")
    String authenticate(@RequestParam String password, @RequestParam Long clientId, @RequestHeader(name = "Cookie") String service_sessionId);
}

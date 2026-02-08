package productservice.Infra.feign;

import clientservice.Client.dto.get.GetClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ProductFeignClient", url = "${client.service.url}")
public interface ProductFeignClient {

    @GetMapping("/clients/{clientId}")
    GetClientResponse getClient(@PathVariable Long clientId, @RequestHeader(name = "Cookie") String cookie);
}

package pl.pjatk.demo.restcontroller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NbpRestController {


    @GetMapping("/{currency}")
    ResponseEntity<Float> averageExchangeRate(
            @PathVariable String currency,
            @RequestParam(required = false, defaultValue = "1") int days) {


        return ResponseEntity.ok(nbpService.averageExchangeRate(currency, days));
    }

}

package pl.pjatk.demo.restController;

import pl.pjatk.demo.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class NbpRestController {
    private final NbpService nbpService;

    public NbpRestController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @Operation(summary = "Get an average rate of currency from date to date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Average exchange rate calculated",
                    content = @Content(schema = @Schema(type = "number", format = "float"))),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Invalid time range",
                    content = @Content)})


    @GetMapping("/{currency}")
    ResponseEntity<Float> averageExchangeRate(
            @PathVariable String currency,
            @RequestParam(required = true, defaultValue = "2012-01-01") String startDate,
            @RequestParam(required = true, defaultValue = "2012-01-03") String endDate)


    {
        return ResponseEntity.ok(nbpService.averageExchangeRate(currency, startDate, endDate));
    }
}

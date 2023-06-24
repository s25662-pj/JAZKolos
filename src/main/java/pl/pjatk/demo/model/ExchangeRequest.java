package pl.pjatk.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
public class ExchangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Max(3)
    private String currency;
    @NotBlank
    @Max(12)
    private String startDay;
    @NotBlank
    @Max(12)
    private String endDate;
    @NotBlank
    private float rate;
    @NotBlank
    private LocalDateTime date;

    public ExchangeRequest(String currency, String startDay, String endDate, float rate, LocalDateTime date) {
        this.id = id;
        this.currency = currency;
        this.startDay = startDay;
        this.endDate = endDate;
        this.rate = rate;
        this.date = date;
    }

    public ExchangeRequest() {

    }
}

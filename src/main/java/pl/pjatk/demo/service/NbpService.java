package pl.pjatk.demo.service;

import pl.pjatk.demo.repository.ProjectRepository;
import pl.pjatk.demo.model.ExchangeRateResponse;
import pl.pjatk.demo.model.ExchangeRequest;
import pl.pjatk.demo.model.Rate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class NbpService {
    private final ProjectRepository projectRepository;
    private final WebClient webClient;

    public NbpService(ProjectRepository projectRepository, WebClient webClient) {
        this.projectRepository = projectRepository;

        this.webClient = webClient;
    }


    public float averageExchangeRate(String currency, String startDate, String endDate){
        ExchangeRateResponse response = webClient.get()
                .uri("https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + startDate + "/" + endDate + "/?format=json")
                .retrieve()
                .bodyToMono(ExchangeRateResponse.class)
                .block();
        float sum = 0;
        for(Rate rate : response.getRates()){
            sum += rate.getMid();
        }
        float rate = sum/response.getRates().size();
        ExchangeRequest exchangeRequest = new ExchangeRequest(currency, startDate, endDate,rate, LocalDateTime.now());
        projectRepository.save(exchangeRequest);
        return rate;
    }
}

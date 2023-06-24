package pl.pjatk.demo.service;

import pl.pjatk.RentalService.config.RestTemplateConfig;
import pl.pjatk.demo.model.Rate;

import java.net.URI;

public class NbpService {


    private final pl.pjatk.RentalService.config.RestTemplateConfig restTemplateConfig;


    public NbpService(RestTemplateConfig restTemplateConfig) {
        this.restTemplateConfig = restTemplateConfig;
    }

    public Rate averageExchangeRate(long id){
        String url = "" + id;
        return restTemplateConfig.restTemplate().getForEntity(URI.create(url), .class).getBody();
    }
}

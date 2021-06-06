package com.tts.weatherApp.Service;

import com.tts.weatherApp.Model.Response;
import com.tts.weatherApp.Model.ZipCode;
import com.tts.weatherApp.Repo.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
//import com.tts.weatherApp.Controller.WeatherController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;

    // Inject the ZipCodeRepository to the WeatherService class
    @Autowired
    public ZipCodeRepository zipCodeRepository;

    // Create a list to house zipCodes
    private static List<String> zipCodes;


    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" +
                zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        // create new ZipCode object based on the zip code searched
        ZipCode newZip = new ZipCode(zipCode);
        // add the zip code searched to the database
        addZip(newZip);

        try {
            return restTemplate.getForObject(url, Response.class);
        } catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
    }

    // Create a method to add the zipCode to the database.
    private void addZip(ZipCode zipCode) {
        zipCodeRepository.save(zipCode);
//        zipCodes.add(zipCode);
    }

    // Create a weather service method to get the (up to 10) most recent searches.
    // select * from ZIP_CODE order by TIME_STAMP desc limit 10

    private List<String> getRecentZips() {
        zipCodes = zipCodeRepository.findRecentZips();
        return zipCodes;
    }

}

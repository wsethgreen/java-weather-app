package com.tts.weatherApp.Controller;

import com.tts.weatherApp.Model.Request;
import com.tts.weatherApp.Model.Response;
import com.tts.weatherApp.Model.ZipCode;
import com.tts.weatherApp.Repo.ZipCodeRepository;
import com.tts.weatherApp.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherController {

    // Injections
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    private ZipCode zipCode;

    // Get/Post Mapping
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("request", new Request());
        // call getRecentZips
        List<String> recentZips = weatherService.zipCodeRepository.findRecentZips();
        model.addAttribute("recentZips", recentZips);
        return "index";
    }

    @PostMapping
    public String postIndex(Request request, Model model) {
        // call getForecast method on recent search
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);

        return "index";
    }

//    @PostMapping(value = "/")
//    public String addZip(ZipCode zipCode, Model model) {
//        zipCodeRepository.save(zipCode);
//        zipCodes.add(zipCode);
//        model.addAttribute("zipCode", zipCode.getZipCode());
//        return "index";
//    }


}

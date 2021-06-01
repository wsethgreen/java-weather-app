package com.tts.weatherApp.Model;

import java.util.Map;
import java.util.List;
import lombok.*;
import org.springframework.web.client.RestTemplate;

@Data
@NoArgsConstructor
public class Response {
    private Map<String, String> coords;
    private List<Map<String, String>> weather;
    private String base;
    private Map<String, String> main;
    private Map<String, String> wind;
    private Map<String, String> clouds;
    private String dt;
    private Map<String, String> sys;
    private String id;
    private String name;
    private String cod;


}

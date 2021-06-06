package com.tts.weatherApp.Model;
import com.tts.weatherApp.Service.WeatherService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private Date timeStamp;

    private String zipCode;

    public Long getId() {
        return id;
    }

    // One argument constructor (the other arguments are automatically generated)
    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}

package com.medicinery.web.rest;

import com.wapi.api.DayWeather;
import com.wapi.core.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherResources {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/day/{day}", method = RequestMethod.GET)
    public DayWeather getWeather(@PathVariable String day) {
        return weatherService.lookup(day);
    }
}

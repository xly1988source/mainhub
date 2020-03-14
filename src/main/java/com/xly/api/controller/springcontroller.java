package com.xly.api.controller;

import com.xly.api.service.CountryService;
import com.xly.api.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class springcontroller {
    @Autowired
    private CountryService countryService;
    @GetMapping(value = "/CountryInfoCode")
    public Object selectCountryByCode(@RequestParam("code") String code){
        return countryService.selectCountryByCode(code);
    }
    @GetMapping(value = "/CountryInfo/{paramString}")
    public Object selectCountryInfo(@PathVariable String  paramString){
        int index = paramString.indexOf("=");
        String key = paramString.substring(0,index);
        String value = paramString.substring(index+1);
        if(key.equals("code"))
            return countryService.selectCountryByCode(value);
        else  if(key.equals("continent"))
            return countryService.selectCountryByContinent(value);
        else
            return JsonResult.failure(1002,"参数有误");

    }
    @GetMapping(value = "/AllCountryInfo")
    public Object selectCountryByCode(){
        return countryService.selectAllCountry();
    }


}

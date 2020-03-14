package com.xly.api.service;

import com.xly.api.mapper.CountryMapper;
import com.xly.api.utils.JsonResult;
import com.xly.mybatis.pojo.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;
    public Object selectCountryByCode(String code){
        try {
            Country country = countryMapper.selectCountryByCode(code);
           /* GameClueVo gameClueVo = new GameClueVo();
            BeanUtils.copyProperties(clueInfo,gameClueVo);*/
            return JsonResult.success(country);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(1102,"找不到记录");
        }
    }
    public Object selectCountryByContinent(String continent){
        try {
            List<Country> list = countryMapper.selectAllCountryByContinent(continent);
           /* GameClueVo gameClueVo = new GameClueVo();
            BeanUtils.copyProperties(clueInfo,gameClueVo);*/
            return JsonResult.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(1102,"找不到记录");
        }
    }
    public Object selectAllCountry(){
        try {
            List<Country> list = countryMapper.selectAllCountry();
           /* GameClueVo gameClueVo = new GameClueVo();
            BeanUtils.copyProperties(clueInfo,gameClueVo);*/
            return JsonResult.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(1102,"找不到记录");
        }
    }

}

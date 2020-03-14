package com.xly.api.mapper;

import com.xly.mybatis.pojo.Country;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface CountryMapper {
    Country selectCountryByCode(String code);
    List<Country> selectAllCountryByContinent(String continent);
    List<Country> selectAllCountry();
}
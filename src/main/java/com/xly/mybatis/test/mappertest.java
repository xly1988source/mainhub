package com.xly.mybatis.test;

import com.xly.api.mapper.CountryMapper;
import com.xly.mybatis.pojo.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mappertest {
    public static void main(String args[]) throws IOException {
        //获取mapper接口
        String resource = "mybatis.cfg.xml";
        // 通过流将核心配置文件读取进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过核心配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过会话工厂创建会话
        SqlSession session = factory.openSession();
        CountryMapper userMapper = session.getMapper(CountryMapper.class);
        Country country = userMapper.selectCountryByCode("ABW");
       // System.out.println(userMapper.selectAllCountry());
        session.close();
    }
}

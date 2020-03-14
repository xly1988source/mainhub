package test;

import com.xly.mybatis.pojo.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserTest {


    public void selectCountryByCode() throws Exception {
        String resource = "mybatis.cfg.xml";
        // 通过流将核心配置文件读取进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过核心配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        
        // 通过会话工厂创建会话
        SqlSession session = factory.openSession();
        
        Country country = session.selectOne("com.xly.mybatis.selectCountryByCode", "CHN");
        System.out.println(country.getContinent());
    }
    public void selectAllCountryByContinent() throws Exception {
        String resource = "mybatis.cfg.xml";
        // 通过流将核心配置文件读取进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过核心配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过会话工厂创建会话
        SqlSession session = factory.openSession();

        List<Country> list = session.selectList("com.xly.mybatis.selectAllCountryByContinent", "Europe");

       for(Country country:list){

           System.out.println(country.getName());
        }

    }
      //根据主键字段更新几个特定字段
    public void updateCountryTop3ByCode() throws Exception {
        String resource = "mybatis.cfg.xml";
        // 通过流将核心配置文件读取进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过核心配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过会话工厂创建会话
        SqlSession session = factory.openSession();
        Country country = new Country();
        country.setCode("SVN");
        country.setName("Slovenia1988");
        country.setContinent("Europe");
        country.setRegion("Southern Europe1988");
        session.update("com.xly.mybatis.updateCountryTop3ByCode",country);
        session.commit();

    }
    //根据主键字段更新几个特定字段
    public void updateCountryPopulcationByCode() throws Exception {
        String resource = "mybatis.cfg.xml";
        // 通过流将核心配置文件读取进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过核心配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过会话工厂创建会话
        SqlSession session = factory.openSession();

        session.update("com.xly.mybatis.updateCountryPopulcationByCode","SVN");
        session.commit();

    }

    public static void main(String args[]){
        UserTest test  = new UserTest();
        try {
           // test.selectCountryByCode();
           // test.updateCountryTop3ByCode();
            //test.updateCountryPopulcationByCode();
            test.selectAllCountryByContinent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
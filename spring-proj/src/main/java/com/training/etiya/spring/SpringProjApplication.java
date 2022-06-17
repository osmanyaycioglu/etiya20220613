package com.training.etiya.spring;

import com.training.etiya.spring.di.Greetings;
import com.training.etiya.spring.di.HelloEng;
import com.training.etiya.spring.jpa.Araba;
import com.training.etiya.spring.jpa.IArabaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringProjApplication implements ApplicationRunner {

    @Autowired
    private HelloEng helloEng;

    @Autowired
    private Greetings greetings;

    private HelloEng helloEng2;
    @Autowired
    private HelloEng helloEng3;
    @Autowired
    private HelloEng helloEng4;

    @Autowired
    private IArabaDao arabaDao;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        helloEng.xyz();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroyed");
    }

    @Autowired
    public void hello(HelloEng helloEngParam) {
        helloEng2 = helloEngParam;
    }


    @PersistenceContext
    private EntityManager entityManager;

    private UserTransaction userTransaction;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Before ready");
        System.out.println(helloEng.sayHello("osman"));
        System.out.println(helloEng2.sayHello("osman"));
        System.out.println(helloEng3.sayHello("osman"));
        System.out.println(helloEng4.sayHello("osman"));
//        HelloEng helloEng = new HelloEng();
//        System.out.println(helloEng.sayHello("osman"));
        greetings.sayHello("mehmet");

        Araba araba = new Araba();
        araba.setName("tsa");
        araba.setBrand("bmw");
        araba.setSpeed(120);
        araba.setHorsePower(100);

        arabaDao.save(araba);
        Optional<Araba> byId = arabaDao.findById(1L);
        List<Araba> tsas = arabaDao.findByName("tsa");


        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("insert into araba (brand, horse_power, name, speed, araba_id)  values (?, ?, ?, ?, ?)");) {
            preparedStatement.setString(1,"tsa");
            preparedStatement.setInt(2,100);
            preparedStatement.setString(3,"bmw");
            preparedStatement.setInt(4,120);
            preparedStatement.setLong(5,5);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement("select brand, horse_power, name, speed, araba_id from araba where araba_id=?");) {
            preparedStatement.setLong(5,5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Araba araba1 = new Araba();
                araba1.setBrand(resultSet.getString(1));
                araba1.setName(resultSet.getString(3));
                araba1.setHorsePower(resultSet.getInt(2));
                araba1.setSpeed(resultSet.getInt(4));
                araba1.setArabaId(resultSet.getLong(5));
                System.out.println(araba1);
            }
            try {
                resultSet.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        araba = new Araba();
//        araba.setName("tsa2");
//        araba.setBrand("bmw2");
//        araba.setSpeed(140);
//        araba.setHorsePower(100);
//
//        entityManager.joinTransaction();
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(araba);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            throw new RuntimeException(e);
//        }


    }
}

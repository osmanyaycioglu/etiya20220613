package com.training.etiya.spring.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IArabaDao extends CrudRepository<Araba,Long> {

    List<Araba> findByName(String name);
    List<Araba> findByNameAndBrand(String name,String brand);


    @Query("select a from Araba a where a.name=?1")
    List<Araba> searchName(String name);

    @Query(value = "select * from araba a where a.name=?1",nativeQuery = true)
    List<Araba> searchNameNative(String name);

}

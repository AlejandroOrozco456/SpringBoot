package com.example.instrumentosMus.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.instrumentosMus.models.Instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


@Repository 
public interface InstrumentRepository extends CrudRepository<Instrument,Long>{
    @Query(value = "select * from instrumento i where i.marca like %:keyword% or i.modelo like %:keyword%", nativeQuery = true)
 List<Instrument> findByKeyword(@Param("keyword") String keyword);
    
}

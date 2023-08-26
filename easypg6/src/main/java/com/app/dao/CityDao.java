package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Cities;
import com.app.pojos.Properties;

@Repository
public interface CityDao extends JpaRepository<Cities, Long> {

//	@Query("select c from cities c where c.name = :name")
//	Cities findByName(@Param("name")String name);

	Cities findByName(String cityName);
}

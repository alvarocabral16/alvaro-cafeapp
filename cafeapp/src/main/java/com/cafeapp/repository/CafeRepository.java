package com.cafeapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cafeapp.models.Cafe;

public interface CafeRepository extends CrudRepository<Cafe, String>{
	Cafe findById(long id);

}

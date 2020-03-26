package com.springboot.web.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.web.model.Todo;



@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
	//@Query("delete from Todo where id = id")
	//void deleteById(int id);

	//@Query("Select * from Todo where id = id")
	//Todo findById(int id);
    
    
}

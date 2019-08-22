package com.tommy.queueOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tommy.queueOverflow.models.QuestionsModel;

public interface QuestionsRepository extends CrudRepository<QuestionsModel, Long> {
		List<QuestionsModel> findAll(); //finds all items
//		List<TestModel> findById(String id); //finds multiple items by id
//		List<TestModel> findByATTRIBUTEContaining(String ATTRIBUTE) //finds multiple items by ATTRIBUTE
//		List<TestModel> deleteById(String id); //deletes multiple items by id
//		List<TestModel> findByOrderByATTRIBUTEDesc(); //finds multiple items by ATTRIBUTE and (reverse)ranks them based on number/alphabet
//		List<TestModel> findByOrderByATTRIBUTE(); //finds multiple items by ATTRIBUTE and ranks them based on number/alphabet
}



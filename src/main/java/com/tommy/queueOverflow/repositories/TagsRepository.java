package com.tommy.queueOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tommy.queueOverflow.models.QuestionsModel;
import com.tommy.queueOverflow.models.TagsModel;

public interface TagsRepository extends CrudRepository<TagsModel, Long> {
	List<TagsModel> findBySubjectContaining(String s);
//	List<TestModel> findAll(); //finds all items
//	List<TestModel> findById(String id); //finds multiple items by id
//	List<TestModel> findByATTRIBUTEContaining(String ATTRIBUTE) //finds multiple items by ATTRIBUTE
//	List<TestModel> deleteById(String id); //deletes multiple items by id
//	List<TestModel> findByOrderByATTRIBUTEDesc(); //finds multiple items by ATTRIBUTE and (reverse)ranks them based on number/alphabet
//	List<TestModel> findByOrderByATTRIBUTE(); //finds multiple items by ATTRIBUTE and ranks them based on number/alphabet
}



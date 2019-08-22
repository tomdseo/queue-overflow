package com.tommy.queueOverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommy.queueOverflow.models.AnswersModel;
import com.tommy.queueOverflow.models.QuestionsModel;
import com.tommy.queueOverflow.models.TagsModel;
import com.tommy.queueOverflow.repositories.AnswersRepository;
import com.tommy.queueOverflow.repositories.QuestionsRepository;
import com.tommy.queueOverflow.repositories.TagsRepository;

@Service
public class MasterService {
	@Autowired
	private QuestionsRepository qRepository;
	@Autowired 
	private AnswersRepository aRepository;
	@Autowired
	private TagsRepository tRepository;
	
	
	//returns all the questions
	public List<QuestionsModel> allQuestions() {
		return qRepository.findAll();
	}
	
	//adds questions and tags
	public void addQuestion(QuestionsModel q, String tags) {
		String[] values = tags.split(",");
		List<TagsModel> tagsList = new ArrayList<>();
		for(int i = 0; i < values.length; i++) {
			TagsModel t = addTag(values[i]);
			tagsList.add(t);
		}
		q.setTags(tagsList);
		qRepository.save(q);
	}
	
	public TagsModel addTag(String s) {
		//if it doesn't exist in the DB 
		if(tRepository.findBySubjectContaining(s).size() == 0 || tRepository.findBySubjectContaining(s) == null) {
		TagsModel newTag = new TagsModel();
		newTag.setSubject(s);
		tRepository.save(newTag);
		return newTag;
		}
		List <TagsModel> tags = tRepository.findBySubjectContaining(s);
				return tags.get(0);
	}
	
	//retrieves an item by id (singular)
	public QuestionsModel findQuestion(Long id) {
		Optional<QuestionsModel> optionalQuestion = qRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}
		return null;
	}
	
	//saves the answer
	public void saveA(AnswersModel a) {
		aRepository.save(a);
	}
	
	//saves the question
	public void saveQ(QuestionsModel q) {
		qRepository.save(q);
	}


//	//adds a question
//	public QuestionsModel addQuestion(QuestionsModel q, String[] tagsArray) {
//		//for loop through tagsArray, create new tag, set its subject to the string in the tagsArray, then save the tag (if the tag exists skip saving it), then add it to an arraylist of tags, then setTags(arraylist)
//		List<TagsModel> tagsArrayList = new ArrayList<>();
//		List<QuestionsModel> questionsArrayList = new ArrayList<>();
//		for(int i = 0; i < tagsArray.length; i++) {
//			TagsModel newTag = new TagsModel();
//			newTag.setSubject(tagsArray[i].trim()); //gets rid of lead and ending spaces before adding to newTag's Subject attribute
//			newTag.setQuestions(List<QuestionsModel> questions);
//			tagsArrayList.add(newTag); //adding to arraylist
//			if(checkTag(newTag)) {
//				tRepository.save(newTag);
//			}
//		}
//		
//		q.setTags(tagsArrayList);
//		return qRepository.save(q);
//	}
//
//	private boolean checkTag(TagsModel newTag) {
//		List<TagsModel> all = (List<TagsModel>) tRepository.findAll();
//		// iterate through all tags and see if newtag is already existing
//		for(TagsModel t: all) {
//			if(t == newTag) {
//				return false;
//			}
//		}
//		return true;
//	}
//	//retrieves all items pertaining to attribute (multiple)
//	public TestModel findItems(String attribute) {
//		List<TestModel> listItem = testRepository.findByATTRIBUTEContaining(attribute);
//		if(listItem.size() > 0) {
//			return listItem;
//		return null;
//		}
//	}
//
//	//deletes an item by id
//	public void deleteItem(Long id) {
//		testRepository.deleteById(id);
//	}
}



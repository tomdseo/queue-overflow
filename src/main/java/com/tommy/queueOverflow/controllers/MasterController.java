package com.tommy.queueOverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tommy.queueOverflow.models.AnswersModel;
import com.tommy.queueOverflow.models.QuestionsModel;
import com.tommy.queueOverflow.services.MasterService;

@Controller
public class MasterController {
	@Autowired
	private MasterService masterService;

	@RequestMapping("/")
	public String redirect() {
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions")
	public String questions(Model model) {
		List<QuestionsModel> questions = masterService.allQuestions();
		model.addAttribute("questions", questions);
		return "/queueOverflow/questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String questions(@ModelAttribute("questionObj") QuestionsModel questionObj) {
		return "/queueOverflow/questions-new.jsp";
	}
	
	@RequestMapping(value="/questions/new/action", method=RequestMethod.POST)
	public String questionsNewAction(@Valid @ModelAttribute("questionObj") QuestionsModel questionObj, BindingResult result, @RequestParam("tags") String tags) {
		 masterService.addQuestion(questionObj, tags);
		 return "redirect:/questions";
		 }
	
	@RequestMapping("/questions/{id}")
	public String questionsId(@PathVariable("id") Long id, Model model, @ModelAttribute("answerObj") AnswersModel answerObj) {
		QuestionsModel question = masterService.findQuestion(id);
		model.addAttribute("question", question);
		return "/queueOverflow/questions-id.jsp";
	}
	
	@PostMapping("/answers/new/action/{questionId}")
	public String questionsNewAction(@Valid @ModelAttribute("answerObj") AnswersModel answerObj, BindingResult result, @PathVariable("questionId") Long id, Model model){
		//finds Question Object from id
		QuestionsModel question = masterService.findQuestion(id);
		model.addAttribute("question", question);
		
		if(result.hasErrors()) {
			return "queueOverflow/questions-id.jsp";
		}
		masterService.saveA(answerObj);
			
		//adds answerObj to Question and questionObj to Answer
		answerObj.setQuestion(question);
		masterService.saveA(answerObj);
		List<AnswersModel> lst = question.getAnswers();
		lst.add(answerObj);
		question.setAnswers(lst);
		masterService.saveQ(question);
		return "redirect:/questions/"+id;
		}
}



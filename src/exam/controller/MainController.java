package exam.controller;

import java.util.List;

import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exam.model.bo.QuestionBo;
import exam.model.entity.Question;

@Controller
public class MainController{
	
	@Autowired
	private QuestionBo questionBo;
	
	@RequestMapping(value="/loadquestins", method = RequestMethod.GET)
	public @ResponseBody String getQuestions(){
		List<Question> listQuestions = questionBo.listQuestions(5);
		return new JSONArray(listQuestions).toString();
	}
	
	@RequestMapping(value="/sendanswers", method = RequestMethod.POST)
	public @ResponseBody String getUserAnswers(@RequestParam String arrAnswers){
		return String.valueOf(questionBo.result(arrAnswers));
	}	
}
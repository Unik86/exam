package exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;





import exam.model.bo.QuestionBo;
import exam.model.entity.Question;

@Controller
public class MainController implements BeanFactoryAware {
	
	public MainController(){
		
	}
	
	private QuestionBo questionBo;

	public void setBeanFactory(BeanFactory context) {
		questionBo = (QuestionBo)context.getBean("questionBo");
	}
	
	@RequestMapping(value="/loadquestins", method = RequestMethod.GET)
	public @ResponseBody String getQuestions(){
		
		List<Question> listQuestions = questionBo.listQuestions(5);
		JSONArray jsonQuestions = new JSONArray(listQuestions);
		return jsonQuestions.toString();
	}
	
	@RequestMapping(value="/sendanswers", method = RequestMethod.POST)
	public @ResponseBody String getUserAnswers(@RequestParam String arrAnswers){
		
		int mark = questionBo.result(arrAnswers);
		
		//System.out.println(arrAnswers.toString());
		//String[] userAnswers = arrAnswers.split(",");
		//for(String an: arrAnswers) System.out.println(an);
		
		return new Integer(mark).toString();
	}
}
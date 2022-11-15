package com.simplilearn.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.pojo.Greet;

//@RestController = @Controller + @ResponseBody
@RestController
public class GreetController {
	
	//@GetMapping("/greet")
	@RequestMapping(value="/greet", method= RequestMethod.GET, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	//use @ResponseBody here if not using @RestController
	public Greet greetMe() {
		Greet greet = new Greet();
		greet.setName("Savyata");
		greet.setMessage("Hello Learners!");
		return greet;
	}

}

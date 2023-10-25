package com.learnspring.webservices.restfulservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloWorldController {
	
//	@RequestMapping(method= RequestMethod.GET , path="hello-world")

//  Or we can write 
	@GetMapping("hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping("hello-world/{name}")
	public String HelloWorldPath(@PathVariable String name) {
		return(String.format("Hello World , %s", name));
	}

}

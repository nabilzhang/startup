package me.sample.log4jdemo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {

	static Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		log.debug("How are you today?");
		log.info("I am fine.");
		log.error("I am programming.");
		log.warn("I love programming.");
		log.fatal("I am now dead. I should have been a movie star.");
		return "success";
	}
}

package io.gokul.springbootstarter.topic;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/topics")
	public String getAllTopics(Model model) {
		System.out.println(topicService.getAllTopics());
		model.addAttribute("topics", topicService.getAllTopics());
		
		return "topics";
	}
	
	@RequestMapping("/topics/{id}")
	public String getTopic(@PathVariable String id,Model model) {
		
		System.out.println("Id is "+id);
		model.addAttribute("topics",topicService.getTopic(id));
		return "singleTopic";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public String addTopic(@ModelAttribute("topic")Topic topic, Model model) {
		topicService.addTopics(topic);
		model.addAttribute("topics", topicService.getAllTopics());
		return "index";
	}
//	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopics(topic,id);
		return "index";
	}
//	
//	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
//	public void deleteTopic(@PathVariable String id) {
//		topicService.deleteTopics(id);
//	}
	@RequestMapping("/front")
	public String frontEnd() {
		return "index";
	}
}

package webdev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webdev.models.Widget;
import webdev.repositories.WidgetRepository;

@RestController 
@CrossOrigin(origins= "*",maxAge = 3600)

public class WidgetService {
	   @Autowired
	   WidgetRepository repository;
	   
	   @PostMapping("/api/widget")
	   public void saveAllWidgets(@RequestBody List<Widget> widgets) {
		   repository.deleteAll();
		   for(Widget widget:widgets){
			   repository.save(widget);
		   }
	   }
	   
	   @GetMapping("/api/widget")
       public List<Widget> findAllWidgets(){
    	   return (List<Widget>) repository.findAll();
       }
}

package com.example.biblio.Controller;

import com.example.biblio.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MyBookListController {

	@Autowired
	private MyBookListService myBookService;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		myBookService.deleteById(id);
		return "redirect:/my_books";
	}
}

package com.example.betpawa.controller;

import com.example.betpawa.model.MyComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.betpawa.model.MyList;
import com.example.betpawa.services.ListService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8082/", maxAge = 3600)
@RestController
public class MyController{

	@Autowired
	private ListService listService;

	
	@GetMapping("/list")
	@CrossOrigin(origins = "*")
	public  List< MyList> getList(){
		// get the whole list with all comments
		return this.listService.getList();
	}
	
	@PostMapping("/list")
	@CrossOrigin(origins = "*")
	public MyList insertList(@RequestBody MyList listData){
		// insert new task to the list and comment with list id in seperate table
	System.out.println("this is "+listData);
		return this.listService.addList(listData);
	}
	
	@PutMapping("/list")
	@CrossOrigin(origins = "*")
	public MyList editList(@RequestBody MyList listObj){
		// edit the list not comment table
		return this.listService.editList(listObj);
	}
	
	@PostMapping("/list/{listId}/comment")
	public MyList insertComment(@PathVariable("listId") long listId,  @RequestBody MyComments comment){
		// add comment to the existing listId in comment table
		return this.listService.addComment(listId, comment);
	}
}

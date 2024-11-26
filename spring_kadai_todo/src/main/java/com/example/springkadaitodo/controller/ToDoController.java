package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	// ToDoServiceの依存注入
	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping("/todo")
	public String toDo(Model model) {
		// 全てのToDoリストを取得
		List<ToDo> todos = toDoService.getAllTodos();
		
		// 取得したToDoリストをビューに渡す
		model.addAttribute("todos", todos);
		
		return "todoView";
	}
}

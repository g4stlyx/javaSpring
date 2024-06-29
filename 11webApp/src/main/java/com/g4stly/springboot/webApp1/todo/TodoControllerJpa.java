package com.g4stly.springboot.webApp1.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.g4stly.springboot.webApp1.login.WelcomeController;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = WelcomeController.getLoggedinUsername();	
		List<Todo> todos = todoRepository.findByUsername(username);
		
		model.addAttribute("todos",todos);
		return "listTodos";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = WelcomeController.getLoggedinUsername();
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	//! valid = implement validations written in Todo.java
	public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result) { 
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = WelcomeController.getLoggedinUsername();
		todo.setUsername(username);
		todoRepository.save(todo);

		// after you add a new todo, go to the todos page
		return "redirect:list-todos";
	}

	@RequestMapping(value="delete-todo")
	public String deleteTodo(@RequestParam int id,ModelMap model) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	//! valid = implement validations written in Todo.java
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) { 
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = WelcomeController.getLoggedinUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		
		// after you add a new todo, go to the todos page
		return "redirect:list-todos";
	}
	
}

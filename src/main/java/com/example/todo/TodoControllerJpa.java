package com.example.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name") // Indicates that the "name" attribute will be stored in the session
public class TodoControllerJpa {

    // Constructor injection of TodoRepository
    public TodoControllerJpa(TodoRepository todoRepository) {
        super();

        this.todoRepository = todoRepository;
    }


    private TodoRepository todoRepository; // Dependency injection of TodoRepository

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        // Get the username from the session
        String username = (String) model.get("name");
        // Retrieve the user's todos from the repository
        List<Todo> todos = todoRepository.findByUsername(username);
        // Add the todos to the model to be used in the view
        model.addAttribute("todos", todos);
        // Return the name of the view to be rendered
        return "listTodos";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    /* Binding directly to Todo bean */
    public String showNewTodoPage(ModelMap model){
        // Get the username from the session
        String username = (String) model.get("name");
        // Create a new Todo object with default values
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        // Add the todo to the model to be used in the view
        model.put("todo", todo);
        // Return the name of the view to be rendered
        return "todo";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.POST)
    /*Binding directly to Todo bean */
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        // Check if there are validation errors
        if(result.hasErrors()){
            return "todo"; // Return to the todo view to display errors
        }
        // Get the logged-in username from the session
        String username= getLoggedinUsername(model);
        // Set the username for the todo
        todo.setUsername(username);
        // Save the todo in the repository
        todoRepository.save(todo);
        // Redirect to the list of todos
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        // Delete a todo by its ID
        todoRepository.deleteById(id);
        // Redirect to the list of todos
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        // Find a todo by its ID and add it to the model for editing
        Todo todo =todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        // Return the name of the view to be rendered
        return "todo";
    }

    @RequestMapping(value="update-todo",method = RequestMethod.POST)
    /*Binding directly to Todo bean */
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        // Check if there are validation errors
        if(result.hasErrors()){
            return "todo";  // Return to the todo view to display errors
        }

        // Get the logged-in username from the session
        String username=getLoggedinUsername(model);
        // Set the username for the todo
        todo.setUsername(username);
        // Save the updated todo in the repository
        todoRepository.save(todo);
        // Redirect to the list of todos
        return "redirect:list-todos";
    }

    // Helper method to get the logged-in username from the session
    private String getLoggedinUsername(ModelMap model){
        return (String)model.get("name");
    }




}

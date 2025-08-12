package br.com.fiap.epictaskz.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Home: lista tarefas
    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index"; // renderiza templates/index.html
    }

    // Form de nova tarefa
    @GetMapping("/form")
    public String form() {
        return "form"; // renderiza templates/form.html
    }

    // Salva tarefa
    @PostMapping("/form")
    public String save(Task task, RedirectAttributes redirect) {
        taskService.save(task);
        redirect.addFlashAttribute("message", "Tarefa cadastrada com sucesso!");
        return "redirect:/tasks";
    }
}


package app.mind.tasks.controllerHTML;

import app.mind.tasks.Tasks;
import app.mind.tasks.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HTMLController {

    @Autowired
    private TasksRepository tRepo;
    @GetMapping("/showTasks")
    public ModelAndView showAll() {
        ModelAndView mav = new ModelAndView("task-list");
        List<Tasks> list = tRepo.findAll();
        mav.addObject("tasks", list);
        return mav;
    }

    @GetMapping("/addTasks")
    public ModelAndView createNew() {
        ModelAndView mav = new ModelAndView("task-add");
        Tasks task = (new Tasks());
        task.setDateCreated(LocalDate.now().toString());
        task.setDateEdit(task.getDateCreated());
        mav.addObject("task", task);
        return mav;
    }

    @PostMapping("saveTask")
    public String saveTask(@ModelAttribute Tasks task){
        boolean taskExists = false;
        task.setDateCreated(LocalDate.now().toString());
        task.setDateEdit(task.getDateCreated());
        tRepo.save(task);
        return "redirect:/showTasks";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(Long id) {
        ModelAndView mav = new ModelAndView("task-add");
        Tasks task = tRepo.findById(id).get();
        mav.addObject("task",task);
        return mav;
    }

    @GetMapping("deleteTask")
    public String deleteTask(@RequestParam Long id){
        tRepo.deleteById(id);
        return "redirect:/showTasks";
    }

}

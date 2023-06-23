package app.mind.tasks.controllerHTML;

import app.mind.tasks.Tasks;
import app.mind.tasks.TasksRepository;
import app.mind.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    private TasksRepository tRepo;
    @GetMapping("/showTasks")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("list-tasks");
        List<Tasks> list = tRepo.findAll();
        mav.addObject("tasks", list);
        return mav;
    }
}

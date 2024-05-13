package FirstProject.com.practiceProject.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController {
    @RequestMapping(value="/")
    public String getMessage(){
        return "My First API";
    }

}

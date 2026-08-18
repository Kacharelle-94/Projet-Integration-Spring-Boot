package Kachou.Kacharelle3.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class HomeControler {

        @GetMapping("/")
        public String index() {
            return "Bienvenue sur mon application Spring Boot";
        }
    }


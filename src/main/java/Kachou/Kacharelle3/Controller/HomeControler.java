package Kachou.Kacharelle3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // On utilise @Controller (et NON @RestController) pour charger des vues HTML
public class HomeControler {

    @GetMapping("/")
    public String index() {
        return "index"; // Spring Boot va chercher index.html dans templates/ ou static/
    }
}
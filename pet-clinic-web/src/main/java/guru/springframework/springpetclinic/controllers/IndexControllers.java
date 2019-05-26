package guru.springframework.springpetclinic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexControllers {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
}

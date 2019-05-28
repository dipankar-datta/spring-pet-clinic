package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/list", "/list.html"})
    public String list(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/list";
    }
}

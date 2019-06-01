package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/list", "/list.html"})
    public String list(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/list";
    }

    @RequestMapping("/find")
    public String find(){
        return "notimplemented";
    }
}

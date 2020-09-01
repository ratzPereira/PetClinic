package ratz.springframework.ratzpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ratz.springframework.ratzpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index"})
     public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

     return "owners/index";
     }
}

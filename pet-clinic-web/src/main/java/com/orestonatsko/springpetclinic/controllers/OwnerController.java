package com.orestonatsko.springpetclinic.controllers;

import com.orestonatsko.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/", "index", "index.html"})
    public String owners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
    @GetMapping({"/find", "/find/"})
    public String findOwners(){
        return "notimplemented";
    }
}

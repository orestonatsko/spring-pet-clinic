package com.orestonatsko.springpetclinic.controllers;

import com.orestonatsko.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String vets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}

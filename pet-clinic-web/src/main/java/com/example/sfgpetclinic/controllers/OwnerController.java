package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(Model model) {
        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Michael");
        owner3.setLastName("Weston");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Fiona");
        owner4.setLastName("Glenanne");

        ownerService.save(owner4);

        model.addAttribute("owners", ownerService.findAll());

       return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }
}

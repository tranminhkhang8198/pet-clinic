package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
   private final VetService vetService;

   public VetController(VetService vetService) {
      this.vetService = vetService;
   }

   @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
   public String listOfVets(Model model) {
      Vet vet3 = new Vet();
      vet3.setId(1L);
      vet3.setFirstName("Sam");
      vet3.setLastName("Axe");

      vetService.save(vet3);

      model.addAttribute("vets", vetService.findAll());
      return "vets/index";
   }
}

package com.example.proba.controllers;

import com.example.proba.models.Diler;
import com.example.proba.services.DilerService;
import com.example.proba.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class DilersController {

    private final DilerService dilerService;
    private final ProductService productService;

    @GetMapping("/dilers")
    public String masters(@RequestParam(name="fullName",required = false) String fullName, Model model, Principal principal) {
        model.addAttribute("masters", dilerService.mastersList(fullName));
        model.addAttribute("user",productService.getUserByPrincipal(principal));
        return "dilers";
    }

    @GetMapping("/adddiler")
    public String mastersview() {
        return "adddillers";
    }

    @PostMapping("/adddiler")
    public String addMaster(@ModelAttribute("diler") Diler diler) throws IOException {
        dilerService.addMaster(diler);
        return "redirect:/dilers";
    }

    @PostMapping("/masters/delete/{id}")
    public String deleteDiler(@PathVariable Long id) {
        dilerService.deleteMaster(id);
        return "redirect:/dilers";
    }

}

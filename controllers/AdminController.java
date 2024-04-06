package com.example.proba.controllers;

import com.example.proba.models.User;
import com.example.proba.models.enums.Role;
import com.example.proba.services.AppointmentService;
import com.example.proba.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    private final AppointmentService appointmentService;

    @GetMapping("/admin")
    public String admin(Model model,String name){
        model.addAttribute("users",userService.list());
        model.addAttribute("appointment", appointmentService.list(name));
        return "admin";
    }

    @PostMapping("/admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/admin/user/edit")
    public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return "redirect:/admin";
    }
    @PostMapping("admin/user/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/view/appointment")
    public String appointmentView(Model model,String name) {
        model.addAttribute("appointment", appointmentService.list(name));
        return "appoint";
    }

    @PostMapping("/admin/appointment/delete/{id}")
    public String deleteAppointmentById(@PathVariable("id") Long id){
      appointmentService.deleteAppointment(id);
        return "redirect:/admin";
    }
}

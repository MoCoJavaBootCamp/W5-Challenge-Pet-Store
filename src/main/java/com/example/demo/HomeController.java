package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/customerform")
    public String loadCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @PostMapping("/customerform")
    public String processCustomerForm(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customerform";
        }
        return "customerconfirm";
    }
}

package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

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
        return "dogform";
    }

    public void process(
            HttpServletRequest request, HttpServletResponse response,
            ServletContext servletContext, TemplateEngine templateEngine) throws IOException {

        Home home = new Home();
        ArrayList<Customer> allCustomers = home.getAllCustomers();

        WebContext ctx =
                new WebContext(request, response, servletContext, request.getLocale());
        templateEngine.process("home", ctx, response.getWriter());
        ctx.setVariable("customers", allCustomers);

    }
}

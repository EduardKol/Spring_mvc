package com.edkol.spring.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController{

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }
//Вариант HttpServletRequest
    @RequestMapping("/showDetails")
    public String showEmpDetails(HttpServletRequest request, Model model) {
        String name = request.getParameter("employeeName");
        name = "King " + name;

        model.addAttribute("nameAttribute", name);

        model.addAttribute("description", " of the Greate Brit");
        return "show-emp-details-view";
    }
//Вариант @RequestParam
    @RequestMapping("/showRealDetails")
    public String showNewDetails(@RequestParam("TrueName") String newName, Model model) {
        newName = "Real King " + newName + " little castle";
        model.addAttribute("nameRealAttribute", newName);
        return "show-real-details-view";
    }
}

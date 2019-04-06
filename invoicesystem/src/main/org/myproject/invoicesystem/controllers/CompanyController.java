package org.myproject.invoicesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController extends BaseController {
    @GetMapping("/company/add")
    public ModelAndView addCompany() {
        return this.view("company-add");
    }
}

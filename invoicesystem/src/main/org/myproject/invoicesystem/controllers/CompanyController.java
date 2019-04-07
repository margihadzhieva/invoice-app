package org.myproject.invoicesystem.controllers;

import org.modelmapper.ModelMapper;
import org.myproject.invoicesystem.models.binding.CompanyAddBindingModel;
import org.myproject.invoicesystem.models.service.CompanyServiceModel;
import org.myproject.invoicesystem.models.view.CompanyViewModel;
import org.myproject.invoicesystem.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class CompanyController extends BaseController {
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/company/add")
    public ModelAndView addCompany() {
        return this.view("company-add");
    }

    @RequestMapping(value = "company/add", method = RequestMethod.POST)
    public ModelAndView addCompany(@ModelAttribute CompanyAddBindingModel companyAddBindingModel, Principal principal) {
        this.companyService.addCompany((this.modelMapper
                .map(companyAddBindingModel
                        ,CompanyServiceModel.class)), principal.getName());
        return this.redirect("all");
    }


    @GetMapping("/company/info")
    public ModelAndView companyInfo(Principal principal, ModelAndView modelAndView) {
        CompanyViewModel companyViewModel = this.modelMapper.map((this.companyService.myCompany(principal.getName())), CompanyViewModel.class);

        modelAndView.addObject("myCompany", companyViewModel);

        return this.view("company-info", modelAndView);
    }



}

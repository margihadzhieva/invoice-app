package org.myproject.invoicesystem.controllers;

import org.modelmapper.ModelMapper;
import org.myproject.invoicesystem.models.view.CompanyViewModel;
import org.myproject.invoicesystem.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class InvoiceController extends BaseController {
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public InvoiceController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/invoice/add")
    public ModelAndView addInvoice(ModelAndView modelAndView, Principal principal) {
        CompanyViewModel companyViewModel = this.modelMapper.map((this.companyService.myCompany(principal.getName())), CompanyViewModel.class);

        modelAndView.addObject("myCompany", companyViewModel);
        return this.view("invoice-add", modelAndView);
    }


}

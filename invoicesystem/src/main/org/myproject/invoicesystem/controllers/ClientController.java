package org.myproject.invoicesystem.controllers;

import org.modelmapper.ModelMapper;
import org.myproject.invoicesystem.models.binding.ClientAddBindingModel;
import org.myproject.invoicesystem.models.service.ClientServiceModel;
import org.myproject.invoicesystem.models.view.AllClientsViewModel;
import org.myproject.invoicesystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/client")
public class ClientController extends BaseController {
    private final ClientService clientService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addClient() {
        return this.view("client-add");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addClient(@ModelAttribute ClientAddBindingModel clientAddBindingModel) {
        this.clientService.addClient(this.modelMapper
                .map(clientAddBindingModel
                        , ClientServiceModel.class));
        return this.redirect("client-all");
    }



    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView allClients(ModelAndView modelAndView) {
        Set<AllClientsViewModel> allClientsViewModel = this
                .clientService
                .allClients()
                .stream()
                .map(x -> this.modelMapper.map(x, AllClientsViewModel.class))
                .collect(Collectors.toSet());

        modelAndView.addObject("allClients", allClientsViewModel);


        return this.view("client-all", modelAndView);

    }
}

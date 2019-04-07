package org.myproject.invoicesystem.services;

import org.modelmapper.ModelMapper;
import org.myproject.invoicesystem.entities.Company;
import org.myproject.invoicesystem.entities.User;
import org.myproject.invoicesystem.models.service.CompanyServiceModel;
import org.myproject.invoicesystem.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

   private final ModelMapper modelMapper;

   private final CompanyRepository companyRepository;

   private final UserService userService;

   @Autowired
    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
       this.userService = userService;
   }

    @Override
    public boolean addCompany(CompanyServiceModel companyServiceModel, String username) {
        Company companyEntity = this.modelMapper.map(companyServiceModel, Company.class);

        User user = (User) this
                .userService
                .loadUserByUsername(username);

        companyEntity.setUserId(user);


        try {
            this.companyRepository.save(companyEntity);
        } catch (Exception ignored) {
            //TODO: Fix this when discover exception type.
            return false;
        }


        return true;
    }

    @Override
    public CompanyServiceModel myCompany(String currentUser) {
        String userId = ((User)this.userService
                .loadUserByUsername(currentUser))
                .getId();


        System.out.println(userId);
        Company company = this.companyRepository.findCompanyByUserId(userId)
                .orElse(null);

     return this.modelMapper.map(company, CompanyServiceModel.class);

    }
}

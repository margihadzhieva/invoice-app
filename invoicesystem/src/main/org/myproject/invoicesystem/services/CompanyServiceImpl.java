package org.myproject.invoicesystem.services;

import org.modelmapper.ModelMapper;
import org.myproject.invoicesystem.entities.Company;
import org.myproject.invoicesystem.models.service.CompanyServiceModel;
import org.myproject.invoicesystem.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

   private final ModelMapper modelMapper;

   private final CompanyRepository companyRepository;

   @Autowired
    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean addCompany(CompanyServiceModel companyServiceModel) {
        Company companyEntity = this.modelMapper.map(companyServiceModel, Company.class);

        try {
            this.companyRepository.save(companyEntity);
        } catch (Exception ignored) {
            //TODO: Fix this when discover exception type.
            return false;
        }


        return true;
    }
}

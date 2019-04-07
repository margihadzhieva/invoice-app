package org.myproject.invoicesystem.services;

import org.myproject.invoicesystem.models.service.CompanyServiceModel;

import java.util.Set;

public interface CompanyService {

    boolean addCompany(CompanyServiceModel companyServiceModel, String username);

    CompanyServiceModel myCompany(String currentUser);
}

package org.myproject.invoicesystem.services;

import org.myproject.invoicesystem.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    boolean createUser(UserServiceModel userServiceModel);

}

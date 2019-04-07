package org.myproject.invoicesystem.repositories;

import org.myproject.invoicesystem.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query(value = "SELECT * FROM company WHERE user_id = :userId"
            , nativeQuery = true)
    Optional<Company> findCompanyByUserId(String userId);


}

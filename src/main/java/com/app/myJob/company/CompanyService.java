package com.app.myJob.company;

import com.app.myJob.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Boolean updateCompany(Long id,Company company);
    Company getCompanyById(Long id);
    void createJob(Company company);
    Boolean deleteCompanyById(Long id);


}

package com.financial.approval.service;

import com.financial.approval.core.dto.ApplicationDTO;
import com.financial.approval.core.entity.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
    
    ApplicationDTO createApplication(ApplicationDTO applicationDTO);
    
    ApplicationDTO getApplicationById(Long id);
    
    List<ApplicationDTO> getAllApplications();
    
    ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO);
    
    boolean deleteApplication(Long id);
    
    List<ApplicationDTO> getApplicationsByStatus(ApplicationStatus status);
}
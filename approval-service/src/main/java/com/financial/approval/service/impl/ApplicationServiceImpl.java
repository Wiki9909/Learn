package com.financial.approval.service.impl;

import com.financial.approval.core.dto.ApplicationDTO;
import com.financial.approval.core.entity.Application;
import com.financial.approval.core.entity.ApplicationStatus;
import com.financial.approval.core.repository.ApplicationRepository;
import com.financial.approval.service.ApplicationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Override
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        BeanUtils.copyProperties(applicationDTO, application);
        // Handle enum conversion
        if (applicationDTO.getStatus() != null) {
            application.setStatus(ApplicationStatus.valueOf(applicationDTO.getStatus()));
        }
        
        Application savedApplication = applicationRepository.save(application);
        
        ApplicationDTO result = new ApplicationDTO();
        BeanUtils.copyProperties(savedApplication, result);
        // Handle enum conversion
        if (savedApplication.getStatus() != null) {
            result.setStatus(savedApplication.getStatus().name());
        }
        
        return result;
    }
    
    @Override
    public ApplicationDTO getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    
    @Override
    public List<ApplicationDTO> getAllApplications() {
        return applicationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO) {
        return applicationRepository.findById(id)
                .map(existingApplication -> {
                    // Update fields
                    existingApplication.setApplicantName(applicationDTO.getApplicantName());
                    existingApplication.setApplicantIdNumber(applicationDTO.getApplicantIdNumber());
                    existingApplication.setApplicantPhone(applicationDTO.getApplicantPhone());
                    existingApplication.setLoanAmount(applicationDTO.getLoanAmount());
                    existingApplication.setLoanTerm(applicationDTO.getLoanTerm());
                    existingApplication.setLoanPurpose(applicationDTO.getLoanPurpose());
                    
                    if (applicationDTO.getStatus() != null) {
                        existingApplication.setStatus(ApplicationStatus.valueOf(applicationDTO.getStatus()));
                    }
                    
                    Application updatedApplication = applicationRepository.save(existingApplication);
                    return convertToDTO(updatedApplication);
                })
                .orElse(null);
    }
    
    @Override
    public boolean deleteApplication(Long id) {
        if (applicationRepository.existsById(id)) {
            applicationRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    @Override
    public List<ApplicationDTO> getApplicationsByStatus(ApplicationStatus status) {
        return applicationRepository.findByStatus(status)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private ApplicationDTO convertToDTO(Application application) {
        ApplicationDTO dto = new ApplicationDTO();
        BeanUtils.copyProperties(application, dto);
        if (application.getStatus() != null) {
            dto.setStatus(application.getStatus().name());
        }
        return dto;
    }
}
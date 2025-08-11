package com.financial.approval.core.repository;

import com.financial.approval.core.entity.Application;
import com.financial.approval.core.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    List<Application> findByApplicantIdNumber(String idNumber);
    
    List<Application> findByStatus(ApplicationStatus status);
    
    @Query("SELECT a FROM Application a WHERE a.applicantName = :name AND a.applicantIdNumber = :idNumber")
    List<Application> findByNameAndIdNumber(@Param("name") String name, @Param("idNumber") String idNumber);
}
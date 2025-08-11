package com.financial.approval.core.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "credit_applications")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "applicant_name", nullable = false)
    private String applicantName;
    
    @Column(name = "applicant_id_number", nullable = false, unique = true)
    private String applicantIdNumber;
    
    @Column(name = "applicant_phone", nullable = false)
    private String applicantPhone;
    
    @Column(name = "loan_amount", nullable = false)
    private BigDecimal loanAmount;
    
    @Column(name = "loan_term", nullable = false)
    private Integer loanTerm;
    
    @Column(name = "loan_purpose")
    private String loanPurpose;
    
    @Column(name = "application_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = ApplicationStatus.SUBMITTED;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
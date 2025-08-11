package com.financial.approval.core.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ApplicationDTO {
    
    private Long id;
    
    private String applicantName;
    
    private String applicantIdNumber;
    
    private String applicantPhone;
    
    private BigDecimal loanAmount;
    
    private Integer loanTerm;
    
    private String loanPurpose;
    
    private String status;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}
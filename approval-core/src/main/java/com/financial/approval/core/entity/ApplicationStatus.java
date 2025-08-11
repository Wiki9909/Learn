package com.financial.approval.core.entity;

public enum ApplicationStatus {
    SUBMITTED("已提交"),
    UNDER_REVIEW("审核中"),
    APPROVED("已批准"),
    REJECTED("已拒绝"),
    CONDITIONAL_APPROVAL("条件批准"),
    CANCELLED("已取消");
    
    private final String description;
    
    ApplicationStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
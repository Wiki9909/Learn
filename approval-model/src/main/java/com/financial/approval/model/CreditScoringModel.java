package com.financial.approval.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreditScoringModel {
    
    private Long applicationId;
    
    // 个人信息得分
    private double personalInfoScore;
    
    // 收入情况得分
    private double incomeScore;
    
    // 负债情况得分
    private double debtScore;
    
    // 征信记录得分
    private double creditHistoryScore;
    
    // 工作稳定性得分
    private double employmentStabilityScore;
    
    // 总得分
    private double totalScore;
    
    // 风险等级
    private RiskLevel riskLevel;
    
    // 建议额度
    private BigDecimal recommendedAmount;
    
    // 建议利率
    private double recommendedInterestRate;
    
    public enum RiskLevel {
        LOW("低风险"),
        MEDIUM("中等风险"),
        HIGH("高风险"),
        VERY_HIGH("极高风险");
        
        private final String description;
        
        RiskLevel(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
}
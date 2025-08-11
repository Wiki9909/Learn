package com.financial.approval.model;

import lombok.Data;

@Data
public class FraudRiskAssessment {
    
    private Long applicationId;
    
    // 身份信息一致性检查得分
    private double identityConsistencyScore;
    
    // 设备指纹风险得分
    private double deviceRiskScore;
    
    // 地理位置异常得分
    private double locationAnomalyScore;
    
    // 申请行为异常得分
    private double behaviorAnomalyScore;
    
    // 多头借贷风险得分
    private double multipleLoanRiskScore;
    
    // 总欺诈风险得分
    private double totalFraudRiskScore;
    
    // 欺诈风险等级
    private FraudRiskLevel riskLevel;
    
    // 风险因素说明
    private String riskFactors;
    
    public enum FraudRiskLevel {
        LOW("低风险"),
        MEDIUM("中等风险"),
        HIGH("高风险"),
        VERY_HIGH("极高风险");
        
        private final String description;
        
        FraudRiskLevel(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
}
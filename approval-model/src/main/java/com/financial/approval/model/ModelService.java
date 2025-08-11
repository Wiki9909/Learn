package com.financial.approval.model;

public interface ModelService {
    
    /**
     * 根据申请信息计算信用评分
     * @param applicationId 申请ID
     * @return 信用评分结果
     */
    CreditScoringModel calculateCreditScore(Long applicationId);
    
    /**
     * 评估欺诈风险
     * @param applicationId 申请ID
     * @return 欺诈风险评分
     */
    FraudRiskAssessment assessFraudRisk(Long applicationId);
}
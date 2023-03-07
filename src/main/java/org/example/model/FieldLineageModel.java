package org.example.model;

import java.util.HashSet;

/**
 * 血缘结果结构
 */
public class FieldLineageModel {
    /**
     * 目标字段
     */
    private FieldNameModel targetField;

    /**
     * 来源字段列表
     */
    private HashSet<FieldNameWithProcessModel> sourceFields;

    public FieldNameModel getTargetField() {
        return targetField;
    }

    public void setTargetField(FieldNameModel targetField) {
        this.targetField = targetField;
    }

    public HashSet<FieldNameWithProcessModel> getSourceFields() {
        return sourceFields;
    }

    public void setSourceFields(HashSet<FieldNameWithProcessModel> sourceFields) {
        this.sourceFields = sourceFields;
    }

    @Override
    public String toString() {
        return "FieldLineageModel{" +
                "targetField=" + targetField +
                ", sourceFields=" + sourceFields +
                '}';
    }
}

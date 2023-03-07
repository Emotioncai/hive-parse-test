package org.example.model;

import java.util.Set;

/**
 * 解析单个select中存储字段和别名
 * 如：select a+b as c from table;
 * 存储数据为 fieldNames:[a,b] alias:c process:a+b
 */

public class FieldLineageSelectItemModel {

    private Set<String> fieldNames;
    private String alias;
    private String process;

    public Set<String> getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(Set<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "FieldLineageSelectItemModel{" +
                "fieldNames=" + fieldNames +
                ", alias='" + alias + '\'' +
                ", process='" + process + '\'' +
                '}';
    }
}

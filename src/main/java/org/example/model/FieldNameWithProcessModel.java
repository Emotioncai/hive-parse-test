package org.example.model;

import java.util.Objects;

/**
 * 带过程的表字段
 */
public class FieldNameWithProcessModel {
    private String dbName;
    private String tableName;
    private String fieldName;
    private String process;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldNameWithProcessModel that = (FieldNameWithProcessModel) o;
        return Objects.equals(dbName, that.dbName) &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(fieldName, that.fieldName) &&
                Objects.equals(process, that.process);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dbName, tableName, fieldName, process);
    }

    @Override
    public String toString() {
        return "FieldNameWithProcessModel{" +
                "dbName='" + dbName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", process='" + process + '\'' +
                '}';
    }
}

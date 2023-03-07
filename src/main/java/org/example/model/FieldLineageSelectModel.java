package org.example.model;

import java.util.List;

public class FieldLineageSelectModel {
    /**
     * index
     */
    String id;

    /**
     * 父id，第一层select为null
     */
    String parentId;

    /**
     * 来源表，来源子select则为null
     */
    TableNameModel fromTable;

    /**
     * 表别名
     */
    String tableAlias;

    /**
     * select字段
     */
    List<FieldLineageSelectItemModel> selectItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public TableNameModel getFromTable() {
        return fromTable;
    }

    public void setFromTable(TableNameModel fromTable) {
        this.fromTable = fromTable;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public List<FieldLineageSelectItemModel> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<FieldLineageSelectItemModel> selectItems) {
        this.selectItems = selectItems;
    }

    @Override
    public String toString() {
        return "FieldLineageSelectModel{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", fromTable=" + fromTable +
                ", tableAlias='" + tableAlias + '\'' +
                ", selectItems=" + selectItems +
                '}';
    }
}

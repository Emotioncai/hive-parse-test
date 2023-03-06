package org.example.model;

import java.util.HashSet;

public class TableLineageModel {
    private TableNameModel outputTable;

    /**
     * 输入的表名列表
     */
    private HashSet<TableNameModel> inputTables;

    public TableNameModel getOutputTable() {
        return outputTable;
    }

    public void setOutputTable(TableNameModel outputTable) {
        this.outputTable = outputTable;
    }

    public HashSet<TableNameModel> getInputTables() {
        return inputTables;
    }

    public void setInputTables(HashSet<TableNameModel> inputTables) {
        this.inputTables = inputTables;
    }

    @Override
    public String toString() {
        return "TableLineageModel{" +
                "outputTable=" + outputTable +
                ", inputTables=" + inputTables +
                '}';
    }
}

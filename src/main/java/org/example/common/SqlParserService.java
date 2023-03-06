package org.example.common;

import org.example.model.TableLineageModel;

public interface SqlParserService {
    /**
     * 获取sql类型
     */
    //SqlTypeEnum parseSqlType(String sql);

    /**
     * 获取创表语句元数据
     */
    //TableMetadataModel parseSqlMetadata(String sql);

    /**
     * sql格式化
     */
    String parseSqlFormatter(String sql);

    /**
     * sql解析表元数据
     */
    TableLineageModel parseSqlTableLineage(String sql);

    /**
     * sql解析字段元数据
     */
    //List<FieldLineageModel> parseSqlFieldLineage(String sql);
}

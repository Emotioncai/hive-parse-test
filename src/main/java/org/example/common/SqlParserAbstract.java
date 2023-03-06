package org.example.common;

import org.example.model.TableLineageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlParserAbstract implements SqlParserService{
    public static final Logger logger = LoggerFactory.getLogger(SqlParserAbstract.class);

    private void notSupport(String msg) {
        logger.error("not support {}", msg);
//        throw new RuntimeException("not support");
    }

//    @Override
//    public SqlTypeEnum parseSqlType(String sql) {
//        notSupport("parseSqlType");
//        return null;
//    }

//    @Override
//    public TableMetadataModel parseSqlMetadata(String sql) {
//        notSupport("parseSqlMetadata");
//        return null;
//    }

    @Override
    public String parseSqlFormatter(String sql) {
        notSupport("parseSqlFormatter");
        return null;
    }

    @Override
    public TableLineageModel parseSqlTableLineage(String sql) {
        notSupport("parseSqlTableLineage");
        return null;
    }

//    @Override
//    public List<FieldLineageModel> parseSqlFieldLineage(String sql) {
//        notSupport("parseSqlFieldLineage");
//        return null;
//    }
}

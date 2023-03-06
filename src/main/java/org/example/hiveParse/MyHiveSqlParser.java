package org.example.hiveParse;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.HiveSqlLexer;
import org.example.antlr.HiveSqlParser;
import org.example.common.SqlParserAbstract;
import org.example.model.TableLineageModel;

public class MyHiveSqlParser extends SqlParserAbstract {
    private ParseTree getParseTree(String sql) {
        CharStream input = CharStreams.fromString(sql);
        HiveSqlLexer lexer = new HiveSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        HiveSqlParser parser = new HiveSqlParser(tokenStream);
        return parser.program();
    }

//    @Override
//    public SqlTypeEnum parseSqlType(String sql) {
//        HiveSqlTypeParser visitor = new HiveSqlTypeParser();
//        visitor.visit(getParseTree(sql));
//        return visitor.getSqlType();
//    }

//    @Override
//    public TableMetadataModel parseSqlMetadata(String sql) {
//        HiveSqlMetadataParser visitor = new HiveSqlMetadataParser(sql);
//        visitor.visit(getParseTree(sql));
//        return visitor.getTableMetadata();
//    }

//    @Override
//    public String parseSqlFormatter(String sql) {
//        HiveSqlFormatterParser visitor = new HiveSqlFormatterParser(sql);
//        visitor.visit(getParseTree(sql));
//        return visitor.getFormattedSQL();
//    }

    @Override
    public TableLineageModel parseSqlTableLineage(String sql) {
        HiveSqlTableLineageParser visitor = new HiveSqlTableLineageParser();
        visitor.visit(getParseTree(sql));
        return visitor.getTableLineage();
    }

//    @Override
//    public List<FieldLineageModel> parseSqlFieldLineage(String sql) {
//        HiveSqlFieldLineageParser visitor = new HiveSqlFieldLineageParser(sql);
//        visitor.visit(getParseTree(sql));
//        return visitor.getHiveFieldLineage();
//    }

}

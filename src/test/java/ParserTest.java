import org.example.hiveParse.MyHiveSqlParser;
import org.example.model.TableLineageModel;
import org.junit.Test;

public class ParserTest {
    @Test
    public void tableLineage(){
        String sql ="SELECT\n" +
                "  ari.area_code, --区域编码\n" +
                "  ari.area_name, --区域名称\n" +
                "  ai.base_code, --基地编码\n" +
                "  ai.base_name, --基地名称\n" +
                "  ai.line_code, --线体编码\n" +
                "  ai.line_name, --线体名称\n" +
                "  '100' AS ratio_code, --制膜工时等编码\n" +
                "  '制膜工时' ratio_name, --制膜工时等名称\n" +
                "  ft.ID AS film_code, --膜种类型编码\n" +
                "  ft.film_name AS film_name, --膜种类型名称\n" +
                "  ftk.ID AS thick_code, --膜种厚度类型编码\n" +
                "  ftk.thickness_name AS thick_name, --膜种厚度类型名称\n" +
                "  ( SUM ( pd.actual_production_quantity ) / SUM ( pd.product_time ) ) AS fees_collection -- 制膜工时值 = 实际生产重量/生产时间\n" +
                " FROM\n" +
                "  dwd.dwd_equipment_performance_detail pd\n" +
                " LEFT JOIN ads.ads_arealine_info ai ON ai.line_code = pd.lines\n" +
                " LEFT JOIN ads.ads_areasite_info asi ON ai.area_code = asi.comp_code\n" +
                " LEFT JOIN ads.ads_area_info ari ON asi.area_code = ari.area_code\n" +
                "  LEFT JOIN ads.ads_film_detail fd ON fd.middle_section = split_part(pd.material_no, '-', 2)\n" +
                "  LEFT JOIN ads.ads_film_type ft ON fd.film_type_id = ft.ID \n" +
                " LEFT JOIN ads.ads_film_thickness ftk ON fd.film_thickness_id = ftk.ID \n" +
                " WHERE\n" +
                "  pd.report_date >= '2022-12-01' --开始时间变量\n" +
                "  AND pd.report_date <= '2022-12-31' --结束时间变量\n" +
                "  AND asi.is_deleted = '0' AND ari.is_deleted = '0' \n" +
                "  AND ft.deleted = '0'\n" +
                "  AND ftk.deleted = '0'\n" +
                " GROUP BY\n" +
                "  ari.area_code,\n" +
                "  ari.area_name,\n" +
                "  ai.base_code,\n" +
                "  ai.base_name,\n" +
                "  ai.line_code,\n" +
                "  ai.line_name,\n" +
                "  ratio_code,\n" +
                "  ratio_name,\n" +
                "  ft.ID,\n" +
                "  ft.film_name,\n" +
                "  ftk.ID,\n" +
                "  ftk.thickness_name";
        MyHiveSqlParser myHiveSqlParser = new MyHiveSqlParser();
        TableLineageModel tableLineageModel = myHiveSqlParser.parseSqlTableLineage(sql);
        System.out.println(tableLineageModel.toString());
    }
}

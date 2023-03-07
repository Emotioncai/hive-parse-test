import org.example.hiveParse.MyHiveSqlParser;
import org.example.model.FieldLineageModel;
import org.example.model.TableLineageModel;
import org.junit.Test;

import java.util.List;

public class ParserTest {
    @Test
    public void tableLineage(){
        String sql ="INSERT into dwd.dwd_base_info\n" +
                "select \n" +
                "e.*,\n" +
                "settlement_cost*tons_amount settlement_amount --结算金额\n" +
                "from (\n" +
                "select \n" +
                "f.*,\n" +
                "case \n" +
                "\twhen settlement_cost_unit_price>0 then settlement_cost_unit_price else storage_cost\n" +
                "end settlement_cost,--结算成本\n" +
                "storage_cost*tons_amount storage_amount --入库金额\n" +
                "from (\n" +
                "select \n" +
                "d.*,\n" +
                "n.years ,\n" +
                "n.months ,\n" +
                "n.end_period_cost,\n" +
                "case \n" +
                "\twhen storage_miscellaneous_unit_price>0 then storage_miscellaneous_unit_price else end_period_cost\n" +
                "end storage_cost --入库成本\n" +
                "from (\n" +
                "select\n" +
                "\tc.*,\n" +
                "\tm.location_code ,\n" +
                "\tm.amount amount_1,\n" +
                "\tm.weighted_average_unit_price ,\n" +
                "\tm.batch_amount ,\n" +
                "\tcase \n" +
                "\t\twhen c.storage_cost_unit_price>0 then storage_cost_unit_price else m.weighted_average_unit_price  \n" +
                "\tend storage_miscellaneous_unit_price --本币入库及杂收成本单价\n" +
                "from\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tb.*,\n" +
                "\t\tp.purchase_order,storage_or_return_no,storage_cost_unit_price ,settlement_cost_unit_price\n" +
                "\tfrom\n" +
                "\t\t(\n" +
                "\t\tselect\n" +
                "\t\t\tcurrent_times,current_dt,sales_grade_code,stronghold,company,locations,location_docs,product_classify_code as classification,product_classify,subclass,material_no,\n" +
                "\t\t\tproduct_category_name,specification,vendor,batch,tons_amount,amount,unit\n" +
                "\t\tfrom\n" +
                "\t\t\tdwd.dwd_batch_inventory_ingredient\n" +
                " \t\twhere\n" +
                " \t\t  amount >'0' and (product_classify_code in ('1101','2101','3101') or product_classify_code like '12%')\n" +
                " \t\t  and current_dt>=to_date('${check_point}','YYYY-MM-dd') and current_dt <to_date('${end_dt}','YYYY-MM-dd') --过滤原料、辅料\n" +
                "\t\tgroup by current_times,current_dt,sales_grade_code,stronghold,company,locations,location_docs,product_classify_code,product_classify,subclass,material_no,product_category_name,\n" +
                "\t\t\tspecification,vendor,batch,tons_amount,amount,unit) as b\n" +
                "\tleft join dwd.dwd_purchase_storage_batch_price p on b.stronghold = p.stronghold and b.material_no = p.material_no and b.batch = p.batch) as c\n" +
                "\tleft join dwd.dwd_auxiliary_material_batch_cost m on c.material_no = m.material_no  and c.batch = m.batch_no ) as d\n" +
                "\tleft join dwd.dwd_material_monthly_form_detail n on d.material_no=n.material_no and d.stronghold=n.site  ) as f ) as e ";
        MyHiveSqlParser myHiveSqlParser = new MyHiveSqlParser();
        List<FieldLineageModel> fieldLineageModels = myHiveSqlParser.parseSqlFieldLineage(sql);
        System.out.println(fieldLineageModels.toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyReports;

/**
 *
 * @author Gustavo Montenegro
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import br.devmontenegro.dao.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 561ma
 */
public class GerarRelatorio {

    private String relatorio;
    private String arg;
    private Connection con;

    public GerarRelatorio() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void ficha(String relatorio, String arg) throws JRException, Exception {

        this.relatorio = relatorio;
        this.arg = arg;

        String sql = "select * from clientes";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery(sql);

        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        Map parameters = new HashMap();

        JasperPrint jp = JasperFillManager.fillReport(relatorio, parameters, jrRS);
        JasperViewer.viewReport(jp, false);

        stm.execute();
        stm.close();
    }

    public void fichaOperador(String relatorio, String arg) throws JRException, Exception {

        this.relatorio = relatorio;
        this.arg = arg;

        String sql = "select * from user";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery(sql);

        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        Map parameters = new HashMap();

        JasperPrint jp = JasperFillManager.fillReport(relatorio, parameters, jrRS);
        JasperViewer.viewReport(jp, false);

        stm.execute();
        stm.close();
    }

    public void comprovanteVenda(String relatorio, String arg) throws JRException, Exception {

        this.relatorio = relatorio;
        this.arg = arg;

        String sql = "select vendas.id, vendas.qtd, vendas.data_venda, vendas.total_venda, vendas.obs, vendas.local_inicio, vendas.local_final, vendas.cliente_id \n"
                + "from vendas join clientes\n"
                + "on clientes.id  = vendas.cliente_id\n"
                + "order by vendas.id desc limit 1";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery(sql);

        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        Map parameters = new HashMap();

        JasperPrint jp = JasperFillManager.fillReport(relatorio, parameters, jrRS);
        JasperViewer.viewReport(jp, false);

        stm.execute();
        stm.close();
    }

}

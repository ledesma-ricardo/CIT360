package controller;

/**
 *
 * @author RALedesma
 */

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.SalesDetalil;
import model.Vehicle;
import util.HMySQL;


public class CSales {

    private HMySQL CONNECTION = new HMySQL();

    // ListarV => Carga la tablaSQL Vehiculos en un JTable
    public void ListSale(JTable table, String[] Columns) {

        List<SalesDetalil> sales = CONNECTION.queryObjects("from Sales_Detalil");
        Object[] oc = new Object[Columns.length];

        DefaultTableModel dtm = new DefaultTableModel(null, Columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };

        try {
            for (SalesDetalil v :sales ) {
                oc[0] = v.getIdSale();
                oc[1] = v.getClient();
                oc[2]=v.getVehicle();
                oc[3]=v.getDiscount()+" %";
                oc[4]="$ "+v.getPriceSale()+" MXN";
               
                dtm.addRow(oc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    public void uploadBrands(JComboBox jv, JComboBox jc) {
        jv.removeAllItems();
        jc.removeAllItems();
        String sqlv = "from Vehicle";
        String sqlc = "from Client";
        List<Vehicle> vehicles = CONNECTION.queryObjects(sqlv);
        List<Client> clients = CONNECTION.queryObjects(sqlc);
        for (Vehicle v : vehicles) {
            jv.addItem(v);
        }
        for (Client c : clients) {
            jc.addItem(c);
        }
    }
}

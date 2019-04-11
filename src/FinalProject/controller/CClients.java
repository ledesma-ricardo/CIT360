package controller;

/**
 *
 * @author RALedesma
 */

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Client;
import util.HMySQL;


public class CClients {
    private HMySQL CONNECTION = new HMySQL();
    
    public void ListC(JTable table, String[] Columns) {

        List<Client> clients = CONNECTION.queryObjects("from Client");
        Object[] oc = new Object[Columns.length];

        DefaultTableModel dtm = new DefaultTableModel(null, Columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };

        try {
            for (Client c : clients) {
                 oc[0] = c.getIdclient();
                 oc[1] = c.getName() + " " + c.getSurname() +" " + c.getLname() ;
                 oc[2] = c.getPhone();
                 oc[3] = c.getAddress();
                 oc[4] = c.getAge();
                dtm.addRow(oc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(8);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
    }
    
}

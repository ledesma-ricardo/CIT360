package controller;

/**
 *
 * @author RALedesma
 */

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Brand;
import model.Vehicle;
import util.HMySQL;

public class CVehicles {

    private HMySQL CONNECTION = new HMySQL();

    // ListV => Load the SQL Vehicles table in a JTable
    public void ListV(JTable table, String[] Columns) {
        
        List<Vehicle> vehicles = CONNECTION.queryObjects("from Vehicle");
        Object[] oc = new Object[Columns.length];

        DefaultTableModel dtm = new DefaultTableModel(null, Columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };

        try {
            for (Vehicle v : vehicles) {
                oc[0] = v.getIdvehicle();
                oc[1] = v.getModel();
                oc[2] = v.getBrand();
                oc[3] = v.getYear();
                oc[4] = "US$ " + v.getPrice();
                oc[5] = v.getStock();
                dtm.addRow(oc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    public void uploadBrands(JComboBox jc) {
        jc.removeAllItems();
        String sql = "from Brand";
        List<Brand> Brands = CONNECTION.queryObjects(sql);
        for (Brand m : Brands) {
            jc.addItem(m);
        }
    }
    
    public byte[] setImage(String path) {
        File file = new File(path);
        byte[] bfile = new byte[(int) file.length()];
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read(bfile);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bfile;
    }

    public void recoverImage(byte[] img) {
        byte[] Image = img;
        try {
            FileOutputStream fos = new FileOutputStream("c:\\img_hibernate\\tmp.jpg");
            fos.write(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void placePhoto(String path, JLabel lblphoto) {
        Image preview = Toolkit.getDefaultToolkit().getImage(path);
        if (preview != null) {
            lblphoto.setText("");
            ImageIcon icon = new ImageIcon(preview.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_DEFAULT));
            lblphoto.setIcon(icon);
        }
    }


}

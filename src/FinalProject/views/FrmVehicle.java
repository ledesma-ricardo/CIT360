package views;

import controller.CVehicles;
import java.awt.Image;
import java.awt.Toolkit;
//import java.util.Calendar;
//import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Brand;
import model.Vehicle;
import util.HMySQL;

/**
 *
 * @author RALedesma
 */
public class FrmVehicle extends javax.swing.JDialog {
    
    private CVehicles cv= new CVehicles();
    private HMySQL CONNECTION= new HMySQL();
    private Vehicle ObjectV=new Vehicle();
//    private Calendar cal;//Tipo de dato Calender
//    private int d, m, a;// Variables para obtener DD-MM-YYYY
    
    private int op, id;// [op=> Accion a realizar (ALTAS=1: EDITAR=2: Consultar=3)] 
    private String path = "";
    
    public FrmVehicle(JDialog parent, boolean modal, int op, int id) {
        super(parent, modal);
        initComponents();
        String Title = "";
        this.op = op;
        this.id = id;
        cv.uploadBrands(JCbrands);
        switch (op) {
            case 1:
                Title="New Vehicle";
                lblphoto.setIcon(new ImageIcon(getClass().getResource("/img/lblfoto.png")));
                break;
            case 2:
                 Title="Update Vehicle";
                 ObjectV= (Vehicle) CONNECTION.queryObject("from Vehicle WHERE idvehicle = "+id);
                 place(ObjectV);
                break;
            case 3:
                Title="Detail Vehicle";
                  ObjectV= (Vehicle) CONNECTION.queryObject("from Vehicle WHERE idvehicle = "+id);
                 Enable(false);
                  place(ObjectV);
                break;
        }
        lbltitulo.setText(Title);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void msj(String s) {
        JOptionPane.showMessageDialog(this,s);
    }
    
    private void Enable(boolean state){
        txtmodel.setEditable(state);
        txtano.setEditable(state);
        txtcolor.setEditable(state);
        txtprice.setEditable(state);
        txtstock.setEditable(state);
        jtany.setEditable(state);
        btnImage.setEnabled(state);
    }

    private void place(Vehicle ObjectV) {
        txtmodel.setText(ObjectV.getModel());
        txtano.setText(ObjectV.getYear());
        txtcolor.setText(ObjectV.getColor());
        txtprice.setText(String.valueOf(ObjectV.getPrice()));
        txtstock.setText(String.valueOf(ObjectV.getStock()));
        jtany.setText(ObjectV.getDescription());

        if (ObjectV.getImg() != null) {
            cv.recoverImage(ObjectV.getImg());
            cv.placePhoto("c:\\img_hibernate\\tmp.jpg", lblphoto);
        }else{
            lblphoto.setIcon(new ImageIcon(getClass().getResource("/img/lblfoto.png")));
        }

    }
    
    private boolean ValidateBoxes() {
        if ("".equals(txtmodel.getText().trim())) {
             msj("Specify The Model");
            txtmodel.requestFocus();
        } else if ("".equals(txtcolor.getText().trim())) {
            msj("Specify The Color");
            txtcolor.requestFocus();
        } else if ("".equals(txtano.getText().trim())) {
            msj("Specify The Year");
            txtano.requestFocus();
        } else if ("".equals(txtprice.getText().trim())) {
            msj("Specify The Price");
            txtprice.requestFocus();
        } else if ("".equals(jtany.getText().trim())) {
            msj("Specify The Specs");
            jtany.requestFocus();
        } else {
            return true;
        }
        return false;
    }
    private boolean assignData(){
        ObjectV.setIdvehicle(id);
        ObjectV.setModel(txtmodel.getText());
        
//        cal = txtano.getText();
//        d = cal.get(Calendar.DAY_OF_MONTH);
//        m = cal.get(Calendar.MONTH);
//        a = cal.get(Calendar.YEAR) - 1900;
        ObjectV.setYear(txtano.getText());
        
        
        ObjectV.setBrand((Brand) JCbrands.getSelectedItem());
        ObjectV.setColor(txtcolor.getText());
        ObjectV.setPrice(Double.parseDouble(txtprice.getText()));
        ObjectV.setDescription(jtany.getText());
        ObjectV.setStock(Integer.parseInt(txtstock.getText()));
        ObjectV.setState(Byte.parseByte("1"));
        return true;
    }
    
    private void Ejecuta(){
        if (ValidateBoxes()) {
            if (assignData()) {
                if (CONNECTION.executeTransaction(ObjectV, Vehicle.class,op)) {
                    this.dispose();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        lblphoto = new javax.swing.JLabel();
        txtmodel = new javax.swing.JTextField();
        JCbrands = new javax.swing.JComboBox<>();
        txtcolor = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtany = new javax.swing.JTextArea();
        txtano = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lbltitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(102, 244, 211));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblphoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblphoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        jLabel2.setText("Model:");

        jLabel3.setText("Brand:");

        jLabel4.setText("Year:");

        jLabel5.setText("Color:");

        jLabel6.setText("Price:");

        jLabel7.setText("Stock:");

        jLabel8.setText("Info:");

        btnImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/subir.png"))); // NOI18N
        btnImage.setText("Upload Picture");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aceptar.png"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jtany.setColumns(20);
        jtany.setRows(5);
        jScrollPane1.setViewportView(jtany);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmodel)
                    .addComponent(JCbrands, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcolor)
                    .addComponent(txtprice)
                    .addComponent(txtstock)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JCbrands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(52, 52, 52)
                            .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnImage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnOK)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        final JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG", "jpg","PNG","png");
        elegirImagen.setFileFilter(filtroImagen);
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if (o == JFileChooser.APPROVE_OPTION) {
            path = elegirImagen.getSelectedFile().getAbsolutePath();
            Image preview = Toolkit.getDefaultToolkit().getImage(path);
            if (preview != null) {
                lblphoto.setText("");
                ImageIcon icon = new ImageIcon(preview.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_DEFAULT));
                lblphoto.setIcon(icon);
                ObjectV.setImg(cv.setImage(path));
            }
        }
    }//GEN-LAST:event_btnImageActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
       Ejecuta();
    }//GEN-LAST:event_btnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCbrands;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtany;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtano;
    private javax.swing.JTextField txtcolor;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}

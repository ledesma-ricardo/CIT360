/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Client;
import util.HMySQL;
import util.ValidateData;

/**
 *
 * @author RALedesma
 */
public class FrmClient extends javax.swing.JDialog {

    private HMySQL CONNECTION = new HMySQL();
    private int op, id;// [op=> Accion a realizar (ALTAS=1: EDITAR=2: Consultar=3)]
    private Client ObjectC= new Client();
    
    

    public FrmClient(JDialog parent, boolean modal, int op, int id) {
        super(parent, modal);
        initComponents();
        String Title = "";
        this.op = op;
        this.id = id;
        switch (op) {
            case 1:
                Title = "New Client";
                break;
            case 2:
                Title = "Update Client";
                ObjectC = (Client) CONNECTION.queryObjects("from Client WHERE idclient = " + id);
                Place(ObjectC);
                break;
            case 3:
                Title = "Detail Client";
                ObjectC = (Client) CONNECTION.queryObjects("from Client WHERE idclient = " + id);
                Enable(false);
                Place(ObjectC);
                break;
            case 4:
                Title = "Delete Client";
                ObjectC = (Client) CONNECTION.queryObjects("from Client WHERE idclient = " + id);
                Enable(false);
                Place(ObjectC);
                break;
        }
        lbltitulo.setText(Title);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void Place(Client c){
        txtName.setText(c.getName());
        txtSurname.setText(c.getSurname());
        txtLname.setText(c.getLname());
        txtAddress.setText(c.getAddress());
        txtPhone.setText(c.getPhone());
        txtAge.setText(c.getAge());
    }
    
    private void msj(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
    
    private void Enable(boolean state){
        txtName.setEditable(state);
        txtSurname.setEditable(state);
        txtLname.setEditable(state);
        txtAddress.setEditable(state);
        txtPhone.setEditable(state);
        txtAge.setEditable(state);
    }

    private boolean ValidateBoxes() {
        if ("".equals(txtName.getText())) {
            msj("Enter The Name Field");
            txtName.requestFocus();
        } else if ("".equals(txtSurname.getText())) {
            msj("Enter The Surname Field");
            txtSurname.requestFocus();
        } else if ("".equals(txtLname.getText())) {
            msj("Enter The Last Name Field");
            txtLname.requestFocus();
        } else if ("".equals(txtAddress.getText())) {
            msj("Enter the Address Field");
            txtAddress.requestFocus();
        } else if ("".equals(txtPhone.getText())) {
            msj("Enter the Phone Field");
            txtPhone.requestFocus();
        } else if ("".equals(txtAge.getText())) {
            msj("Enter The Field Age");
            txtAge.requestFocus();
        } else {
            return true;
        }
        return false;
    }
    
    private boolean AssignC(){
        ObjectC.setIdclient(id);
        ObjectC.setName(txtName.getText());
        ObjectC.setSurname(txtSurname.getText());
        ObjectC.setLname(txtLname.getText());
        ObjectC.setAddress(txtAddress.getText());
        ObjectC.setPhone(txtPhone.getText());
        ObjectC.setAge(txtAge.getText());
        return true;
    }

    private void Execute() {
        if (ValidateBoxes()) {
            if (AssignC()) {
                if (CONNECTION.executeTransaction(ObjectC, Client.class, op)) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jlb9 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jlb10 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

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
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Name:");

        jLabel3.setText("Surname:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("Phone:");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jlb9.setText("Address:");

        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgeKeyTyped(evt);
            }
        });

        jlb10.setText("Age:");

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aceptar.png"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSurname)
                    .addComponent(txtLname)
                    .addComponent(txtPhone)
                    .addComponent(txtAge, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAddress)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jlb9)
                            .addComponent(jlb10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOK)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jlb9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jlb10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOK)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        Execute();
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        if (!(ValidateData.ValidatePhone(txtPhone.getText() + evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyTyped
        if (!(ValidateData.ValidateAge(txtAge.getText() + evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAgeKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb10;
    private javax.swing.JLabel jlb9;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}

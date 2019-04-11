/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.ImageIcon;

/**
 *
 * @author RALedesma
 */
public class Menu extends javax.swing.JFrame {
    private String image="/img/fondo.jpg";
    public Menu() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/tesla.png")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        PanelF F = new PanelF(this.getSize(), image);
        add(F);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        tableV = new javax.swing.JMenuItem();
        tableC = new javax.swing.JMenuItem();
        TableS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCalendar1.setBackground(new java.awt.Color(204, 204, 255));
        jCalendar1.setForeground(new java.awt.Color(102, 102, 102));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(51, 51, 51));
        jCalendar1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jCalendar1.setSundayForeground(new java.awt.Color(255, 255, 0));
        jCalendar1.setWeekOfYearVisible(false);
        jCalendar1.setWeekdayForeground(new java.awt.Color(255, 255, 255));

        jMenuBar1.setBorder(null);

        jMenu1.setForeground(new java.awt.Color(51, 0, 153));
        jMenu1.setText("Manage");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tableV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vehiculo.png"))); // NOI18N
        tableV.setText("Vehicles");
        tableV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableVActionPerformed(evt);
            }
        });
        jMenu1.add(tableV);

        tableC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        tableC.setText("Clients");
        tableC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableCActionPerformed(evt);
            }
        });
        jMenu1.add(tableC);

        TableS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas.png"))); // NOI18N
        TableS.setText("Sales");
        TableS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableSActionPerformed(evt);
            }
        });
        jMenu1.add(TableS);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(662, Short.MAX_VALUE)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableVActionPerformed
        // Invokes the vehicles table
        new TableVehicles(this, true).setVisible(true);
    }//GEN-LAST:event_tableVActionPerformed

    private void tableCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableCActionPerformed
        // Invokes the clients table
        new TableClients(this, true).setVisible(true);
    }//GEN-LAST:event_tableCActionPerformed

    private void TableSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableSActionPerformed
        // Invokes the sales table
        new TableSales(this, true).setVisible(true);
    }//GEN-LAST:event_TableSActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem TableS;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem tableC;
    private javax.swing.JMenuItem tableV;
    // End of variables declaration//GEN-END:variables
}

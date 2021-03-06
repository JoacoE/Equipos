/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Controladores.Fabrica;
import Controladores.IControlador;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class AltaLugar extends javax.swing.JInternalFrame {
    private IControlador IC;
    /**
     * Creates new form AltaTarea
     */
    public AltaLugar() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        IC = fabrica.getICtrl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextLocal = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextSeccion = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Nuevo Lugar");

        jLabel1.setText("Nombre del local:");

        jTextLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLocalActionPerformed(evt);
            }
        });

        jbAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finalizar.png"))); // NOI18N
        jbAceptar.setText("Aceptar");
        jbAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");

        jLabel2.setText("Nombre de la seccion:");

        jTextSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSeccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextLocal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 210, Short.MAX_VALUE)
                                .addComponent(jbAceptar))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jTextSeccion))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar)
                    .addComponent(jbCancelar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLocalActionPerformed

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        if(this.jTextLocal.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del local","ERROR",JOptionPane.ERROR_MESSAGE);
            if(this.jTextSeccion.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de la seccion","ERROR",JOptionPane.ERROR_MESSAGE);
                else{
                    if(IC.addLugar(this.jTextLocal.getText(), this.jTextSeccion.getText())){
                        JOptionPane.showMessageDialog(null, "Se ha creado el lugar","Exito",JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "El lugar ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
                }
        
    // TODO add your handling code here:
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jTextSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSeccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextLocal;
    private javax.swing.JTextField jTextSeccion;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    // End of variables declaration//GEN-END:variables
}

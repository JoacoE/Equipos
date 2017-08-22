/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Clases.Categoria;
import Clases.Dispositivo;
import Clases.Lugar;
import Clases.Usuario;
import Controladores.Fabrica;
import Controladores.IControlador;
import static Swing.Console.EscritorioMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nelson
 */
public class VerUsuarios extends javax.swing.JInternalFrame {
    private IControlador IC;
    
    private DefaultTableModel modelo;
    /**
     * Creates new form VerUsuarios
     */
    public VerUsuarios() {
        initComponents();
        
        modelo = (DefaultTableModel)this.jTableUsuarios.getModel();
        Fabrica fabrica = Fabrica.getInstance();
        IC = fabrica.getICtrl();
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modelo);
        jTableUsuarios.setRowSorter(elQueOrdena);
        cargarTabla();
        cargarCboxFiltro();
        this.jLabelError.setVisible(false);
    }

    private void cargarTabla(){
        int fila = 0;
        ArrayList usuarios = IC.listarUsuarios();
        Iterator it = usuarios.iterator();
        String lista[]=new String[3];
        //Iterator inds = lstProdInd.iterator();
        while(it.hasNext()){
            Usuario usu = (Usuario)it.next();
            lista[0]= Integer.toString(usu.getId());
            lista[1]= usu.getNombre();
            lista[2]= usu.getApellido();
            modelo.insertRow((int)fila, lista);
            fila++;
        }        
    } 
    private void filtrar(int col, String busqueda){
        limpiarTabla();
        int fila = 0;
        ArrayList usuarios = IC.listarUsuarios();
        Iterator it = usuarios.iterator();
        String lista[]=new String[3];
        //Iterator inds = lstProdInd.iterator();
        while(it.hasNext()){
            Usuario usu = (Usuario)it.next();          
            lista[0]= Integer.toString(usu.getId());
            lista[1]= usu.getNombre();
            lista[2]= usu.getApellido();
            if(lista[col].contains(busqueda)){         
                modelo.insertRow((int)fila, lista);
                fila++;
            }
        }
    }
    
    public void limpiarTabla(){
        try {

            int filas=this.jTableUsuarios.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    public void cargarCboxFiltro(){   
        int i=0;
        while(i<this.jTableUsuarios.getColumnCount()){
            String campo = this.jTableUsuarios.getColumnName(i).toString();            
            this.jComboBoxFiltro.addItem(Integer.toString(i)+" - "+campo);
            i++;
        }        
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jComboBoxFiltro = new javax.swing.JComboBox();
        jTFiltro = new javax.swing.JTextField();
        jBFiltro = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jNuevo = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido"
            }
        ));
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        jTFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFiltroActionPerformed(evt);
            }
        });

        jBFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/filtro.png"))); // NOI18N
        jBFiltro.setText("Filtrar");
        jBFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFiltroActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoU.png"))); // NOI18N
        jNuevo.setText("Nuevo");
        jNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevoActionPerformed(evt);
            }
        });

        jLabelError.setForeground(new java.awt.Color(255, 0, 0));
        jLabelError.setText("Seleccione una fila!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar)
                    .addComponent(jNuevo)
                    .addComponent(jLabelError))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFiltroActionPerformed

    private void jNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevoActionPerformed
        // TODO add your handling code here:
        AltaUsuario au = new AltaUsuario();
        EscritorioMenu.add(au);
        au.show();
    }//GEN-LAST:event_jNuevoActionPerformed

    private void jBFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltroActionPerformed
        // TODO add your handling code here:
        StringTokenizer tokens = new StringTokenizer(this.jComboBoxFiltro.getSelectedItem().toString());
        int col = Integer.parseInt(tokens.nextToken());       
        filtrar(col,this.jTFiltro.getText());
    }//GEN-LAST:event_jBFiltroActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        if(this.jTableUsuarios.getSelectedRow()==-1){
            this.jLabelError.setVisible(true);
        }
        else{
            int resp = JOptionPane.showConfirmDialog(null, "Estás Seguro???",null,JOptionPane.OK_CANCEL_OPTION);
            if(resp==0){
                int id = Integer.parseInt(this.jTableUsuarios.getValueAt(this.jTableUsuarios.getSelectedRow(),0).toString());
                IC.eliminarUsuario(id);
                limpiarTabla();
                cargarTabla();
            }
        }
        

                                        

    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        // TODO add your handling code here:
        this.jLabelError.setVisible(false);        
        String s = modelo.getValueAt(this.jTableUsuarios.getSelectedRow(), this.jTableUsuarios.getSelectedColumn()).toString();
        int i = this.jTableUsuarios.getSelectedColumn();
        this.jComboBoxFiltro.setSelectedItem(i+" - "+this.jTableUsuarios.getColumnName(i));
        this.jTFiltro.setText(s);
    }//GEN-LAST:event_jTableUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBFiltro;
    private javax.swing.JComboBox jComboBoxFiltro;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JButton jNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFiltro;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables
}
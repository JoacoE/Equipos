/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Clases.Categoria;
import Clases.Dispositivo;
import Clases.Lugar;
import Clases.Software;
import Clases.Usuario;
import Controladores.Fabrica;
import Controladores.IControlador;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nelson
 */
public class ListarSoftware extends javax.swing.JInternalFrame {

    private IControlador IC;

    DefaultTableModel modelo;
    int id;
    /**
     * Creates new form VerSoftware
     */
    public ListarSoftware(int id) {
        initComponents();
        this.id=id;
        modelo = (DefaultTableModel)this.jTableSw.getModel();
        Fabrica fabrica = Fabrica.getInstance();
        IC = fabrica.getICtrl();
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modelo);
        jTableSw.setRowSorter(elQueOrdena);
        cargarTabla();
    }
    
    private void cargarTabla(){
        ArrayList sw = new ArrayList();
        if(id==-1){
            sw = IC.listarSoftware();}
        else{
            sw = IC.listarSWporEquipo(id);
        }
        Iterator it = sw.iterator();
        String lista[]=new String[6];
        //Iterator inds = lstProdInd.iterator();
        int fila = 0;
        while(it.hasNext()){            
            Software sw1 = (Software)it.next();
            ArrayList equipos = IC.findEquipoPorSW(sw1.getIdSw());
            Iterator ite = equipos.iterator();
            String ides = Integer.toString((int)ite.next());
            while(ite.hasNext()){
                ides=ides+", "+Integer.toString((int)ite.next());
            }
            lista[0]= Integer.toString(sw1.getIdSw());
            lista[1]= sw1.getTipo();
            lista[2]= sw1.getDescripcion();
            lista[3]= sw1.getCdKey();
            lista[4]= Integer.toString(sw1.getCantLicencias());
            lista[5]= ides;
            modelo.insertRow((int)fila, lista);
            fila++;
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
        jTableSw = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);

        jTableSw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Software", "Tipo", "Descripcion", "Cd Key", "Licencias", "Id Equipos"
            }
        ));
        jScrollPane1.setViewportView(jTableSw);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSw;
    // End of variables declaration//GEN-END:variables
}

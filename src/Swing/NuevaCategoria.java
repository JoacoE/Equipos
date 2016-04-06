/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Clases.Categoria;
import Controladores.Fabrica;
import Controladores.IControlador;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nelson
 */
public class NuevaCategoria extends javax.swing.JInternalFrame {
    
    private IControlador IC;
    private Categoria cat;
    boolean valido=true;
    
    /**
     * Creates new form NuevaCategoria
     */
    public NuevaCategoria() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        IC = fabrica.getICtrl();
        modelCat= new DefaultListModel();
        Raiz = new DefaultMutableTreeNode("Categorias");
        modelo = new DefaultTreeModel(Raiz);
        JTree tree = new JTree(modelo);       
        cargarArbol();
        this.jLtree.setVisible(false);
        this.jLtext.setVisible(false);
    }
    
    DefaultListModel modelCat;
    DefaultMutableTreeNode Raiz;// = new DefaultMutableTreeNode("Restaurantes");
    DefaultTreeModel modelo; //= new DefaultTreeModel(Raiz);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCategoria = new javax.swing.JTree();
        jTcategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLtree = new javax.swing.JLabel();
        jLtext = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Nueva Categoría");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTreeCategoria.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeCategoria.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeCategoriaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeCategoria);

        jLabel1.setText("Nombre:");

        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");

        jLabel2.setText("Seleccione la categoría padre:");

        jLtree.setForeground(new java.awt.Color(255, 0, 0));
        jLtree.setText("Seleccione una categoría");

        jLtext.setForeground(new java.awt.Color(255, 0, 0));
        jLtext.setText("Falta el nombre de la categoría");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAceptar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLtree)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLtext)
                                        .addComponent(jTcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLtree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLtext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAceptar)
                    .addComponent(jBCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeCategoriaValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeCategoriaValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode sel = (DefaultMutableTreeNode)this.jTreeCategoria.getLastSelectedPathComponent();
        this.cat = new Categoria(null,(String)sel.getUserObject());
    }//GEN-LAST:event_jTreeCategoriaValueChanged

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        // TODO add your handling code here:
        if(cat.getNombrePadre()==null)
            this.jLtree.setVisible(true);
        else
            if(this.jTcategoria.getText().isEmpty())
                this.jLtext.setVisible(true);
            else{
                cat.setNombre(this.jTcategoria.getText()); 
                if(!IC.existeCat(cat.getNombre(), cat.getNombrePadre())){
                    IC.addCategoria(cat);
                    dispose();
                    JOptionPane.showMessageDialog(null, "!Categoría  "+cat.getNombrePadre()+" -> "+cat.getNombre()+"  creada!","EXITO",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "!La categoría  "+cat.getNombrePadre()+" -> "+cat.getNombre()+"  ya existe!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                    
            }
        
        
    }//GEN-LAST:event_jBAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLtext;
    private javax.swing.JLabel jLtree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTcategoria;
    private javax.swing.JTree jTreeCategoria;
    // End of variables declaration//GEN-END:variables

public void cargarArbol(){
       
            ArrayList cats = IC.ListarCat();
            Iterator it = cats.iterator();
            
            while(it.hasNext()){
                Iterator it1 = cats.iterator();
                Categoria cat = (Categoria)it.next();
                if (cat.getNombrePadre().equals("Categorias")){ 
                    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(cat.getNombre());
                    modelo.insertNodeInto(nodo, Raiz, 0);
//                    while(it1.hasNext()){
//                        Categoria cat1 = (Categoria)it1.next();
//                        if((!(cat1.getNombrePadre().equals("Categorias"))) && (cat1.getNombrePadre().equals(cat.getNombre()))){
//                            DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode(cat1.getNombre());
//                            modelo.insertNodeInto(nodo1, nodo, 0);
//                        }
//                    }          
                }
            }  
            this.jTreeCategoria.setModel(modelo);
        }


}

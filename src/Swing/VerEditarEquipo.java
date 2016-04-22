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

/**
 *
 * @author Nelson
 */
public class VerEditarEquipo extends javax.swing.JInternalFrame {
    int id;
    boolean editar;
    private IControlador IC;
    

    /**
     * Creates new form VerEditarEquipo
     */
    public VerEditarEquipo(int id, boolean editar) {
        initComponents();
        this.id=id;
        this.editar=editar;
        Fabrica fabrica = Fabrica.getInstance();
        IC = fabrica.getICtrl();
        cargar();
        ocultar();
        
        
    }
    private void ocultar(){
        if(!editar){
            this.jTextId.setEditable(false);
            this.jTextMarca.setEditable(false);
            this.jTextModelo.setEditable(false);
            this.jTextProveedor.setEditable(false);
            this.jDFecha.setEnabled(false);
            this.jTextFactura.setEditable(false);
            this.jTextGarantia.setEditable(false);
            this.jTextComentario.setEditable(false);
            this.jTextIp.setEditable(false);
            this.jTextProcesador.setEditable(false);
            this.jTextMemoria.setEditable(false);
            this.jTextHDD.setEditable(false);
            this.jCBCategoria.setEnabled(false);
            this.jCBEstado.setEnabled(false);
            this.jCBLugar.setEnabled(false);
            this.jCBUsuario.setEnabled(false);;
            this.jBActualizarCat.setEnabled(false);
            this.jBActualizarLug.setEnabled(false);
            this.jBActualizarUsu.setEnabled(false);
            this.jBAddCategoria.setEnabled(false);
            this.jBAddLugar.setEnabled(false);
            this.jBAddUsuario.setEnabled(false);
            this.jBExaminar.setEnabled(false);
            this.jBCancelar.setVisible(false);
            

        }
    
    
    }
  
    private void cargar(){
        Dispositivo disp = IC.findDispositivo(id);
        this.jTextId.setText(Integer.toString(disp.getIdDisp()));
        this.jTextMarca.setText(disp.getMarca());
        this.jTextModelo.setText(disp.getModelo());
        this.jTextProveedor.setText(disp.getProveedor());
        this.jDFecha.setDate(disp.getFecha_compra());
        this.jTextFactura.setText(Integer.toString(disp.getFactura()));
        this.jTextGarantia.setText(Integer.toString(disp.getGarantia()));
        this.jTextComentario.setText(disp.getNota());
        if(disp.getTipo().getNombrePadre().equals("Computadora")){
            this.jTextIp.setText(disp.getIp());
            this.jTextProcesador.setText(disp.getProcesador());
            this.jTextMemoria.setText(disp.getMemoria());
            this.jTextHDD.setText(disp.getHDD());     
        }
        else{
            this.jTextIp.disable();
            this.jTextProcesador.disable();
            this.jTextMemoria.disable();
            this.jTextHDD.disable();            
        }
        cargarCboxUsuario();
        cargarCboxLugar();
        cargarCboxCategoria();
        cargarCboxEstado();
    }
    private void cargarCboxUsuario(){
        Dispositivo disp = IC.findDispositivo(id);
        ArrayList usuarios; 
        usuarios=IC.listarUsuarios();
        Iterator it = usuarios.iterator();
        while(it.hasNext()){
            Usuario u = (Usuario) it.next();
            this.jCBUsuario.addItem(u.getId()+" - "+u.getNombre()+" "+u.getApellido());
            if(u.getId()==disp.getUsuario().getId()){
                this.jCBUsuario.setSelectedItem(u.getId()+" "+u.getNombre()+" "+u.getApellido());
            } 
        }
    }    
    public void cargarCboxLugar(){
        Dispositivo disp = IC.findDispositivo(id);
        ArrayList lugares; 
        lugares=IC.listarLugares();
        Iterator it = lugares.iterator();
        while(it.hasNext()){
            Lugar l = (Lugar) it.next();
            this.jCBLugar.addItem(l.getId()+" - "+l.getLocal()+" "+l.getSeccion());
            if(l.getId()==disp.getLugar().getId()){
                this.jCBLugar.setSelectedItem(l.getId()+" - "+l.getLocal()+" "+l.getSeccion());
            }
        }
    }
    public void cargarCboxCategoria(){
        Dispositivo disp = IC.findDispositivo(id);
        ArrayList cats; 
        cats=IC.ListarCat();
        Iterator it = cats.iterator();
        while(it.hasNext()){
            Categoria c = (Categoria) it.next();
            if(!c.getNombrePadre().equals("Categorias")){
                this.jCBCategoria.addItem(c.getId()+" - "+c.getNombrePadre()+" --> "+c.getNombre());
                if(c.getId()==disp.getTipo().getId()){
                    this.jCBCategoria.setSelectedItem(c.getId()+" - "+c.getNombrePadre()+" --> "+c.getNombre());
                }
            }   
        }
    }
    public void cargarCboxEstado(){
    
        Dispositivo disp = IC.findDispositivo(id);
        this.jCBEstado.addItem("ACTIVO");
        this.jCBEstado.addItem("INACTVO");
        this.jCBEstado.addItem("DESUSO");
        this.jCBEstado.setSelectedItem(disp.getEstado());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextId = new javax.swing.JTextField();
        jTextMarca = new javax.swing.JTextField();
        jTextModelo = new javax.swing.JTextField();
        jTextGarantia = new javax.swing.JTextField();
        jTextProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFactura = new javax.swing.JTextField();
        jCBCategoria = new javax.swing.JComboBox();
        jCBLugar = new javax.swing.JComboBox();
        jCBUsuario = new javax.swing.JComboBox();
        jDFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextIp = new javax.swing.JTextField();
        jTextProcesador = new javax.swing.JTextField();
        jTextMemoria = new javax.swing.JTextField();
        jTextHDD = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextComentario = new javax.swing.JTextPane();
        jBVer = new javax.swing.JButton();
        jBExaminar = new javax.swing.JButton();
        jBAddCategoria = new javax.swing.JButton();
        jBAddLugar = new javax.swing.JButton();
        jBAddUsuario = new javax.swing.JButton();
        jBActualizarCat = new javax.swing.JButton();
        jBActualizarLug = new javax.swing.JButton();
        jBActualizarUsu = new javax.swing.JButton();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jButtonVerSw = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        setClosable(true);

        jTextMarca.setPreferredSize(new java.awt.Dimension(274, 22));
        jTextMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMarcaActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Marca:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Lugar:");

        jLabel6.setText("Usuario:");

        jLabel7.setText("Estado:");

        jLabel8.setText("Proveedor:");

        jLabel9.setText("F. Compra:");

        jLabel10.setText("Factura:");

        jCBCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCategoriaItemStateChanged(evt);
            }
        });
        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jLabel11.setText("Garantia:");

        jCBEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEstadoItemStateChanged(evt);
            }
        });

        jLabel12.setText("IP:");

        jLabel13.setText("Procesador:");

        jLabel14.setText("HDD:");

        jLabel15.setText("Memoria:");

        jLabel16.setText("Archivo:");

        jLabel17.setText("Comentario:");

        jScrollPane1.setViewportView(jTextComentario);

        jBVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.jpg"))); // NOI18N
        jBVer.setText("Ver");
        jBVer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jBExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar .png"))); // NOI18N
        jBExaminar.setText("Examinar");

        jBAddCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar1.png"))); // NOI18N
        jBAddCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddCategoriaActionPerformed(evt);
            }
        });

        jBAddLugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ubicacion.png"))); // NOI18N
        jBAddLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddLugarActionPerformed(evt);
            }
        });

        jBAddUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoU.png"))); // NOI18N
        jBAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddUsuarioActionPerformed(evt);
            }
        });

        jBActualizarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jBActualizarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarCatActionPerformed(evt);
            }
        });

        jBActualizarLug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jBActualizarLug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarLugActionPerformed(evt);
            }
        });

        jBActualizarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jBActualizarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarUsuActionPerformed(evt);
            }
        });

        jBAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finalizar.png"))); // NOI18N
        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jButtonVerSw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.jpg"))); // NOI18N
        jButtonVerSw.setText("Ver");
        jButtonVerSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerSwActionPerformed(evt);
            }
        });

        jLabel18.setText("Software:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5)))
                                .addComponent(jLabel8)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jTextProveedor)
                    .addComponent(jTextGarantia)
                    .addComponent(jCBUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBLugar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextModelo)
                    .addComponent(jTextMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jTextFactura)
                    .addComponent(jCBEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAddCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBActualizarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBActualizarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBAddLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBActualizarLug, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBVer, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextHDD)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(29, 29, 29)
                                .addComponent(jTextMemoria))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(15, 15, 15)
                                .addComponent(jTextProcesador))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextIp, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonVerSw, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBAceptar)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12)
                    .addComponent(jTextIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13)
                    .addComponent(jTextProcesador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel15)
                        .addComponent(jTextMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jTextHDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAddCategoria)
                        .addComponent(jLabel4))
                    .addComponent(jBActualizarCat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBVer)
                    .addComponent(jBExaminar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBActualizarLug)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCBLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jBAddLugar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVerSw)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAceptar)
                            .addComponent(jBCancelar)))
                    .addComponent(jBActualizarUsu)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jCBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jBAddUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jTextGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMarcaActionPerformed

    private void jBAddLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddLugarActionPerformed
        // TODO add your handling code here:
        AltaLugar al = new AltaLugar();
        EscritorioMenu.add(al);
        al.show();
        this.jCBLugar.removeAllItems();
        cargarCboxLugar();
    }//GEN-LAST:event_jBAddLugarActionPerformed

    private void jBAddUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddUsuarioActionPerformed
        // TODO add your handling code here:
        AltaUsuario au = new AltaUsuario();
        EscritorioMenu.add(au);
        au.show();
        this.jCBUsuario.removeAllItems();
        cargarCboxUsuario();
     
    }//GEN-LAST:event_jBAddUsuarioActionPerformed

    private void jBAddCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddCategoriaActionPerformed
        // TODO add your handling code here:
        NuevaCategoria nc = new NuevaCategoria();
        EscritorioMenu.add(nc);
        nc.show();
        this.jCBCategoria.removeAllItems();
        cargarCboxCategoria();
    }//GEN-LAST:event_jBAddCategoriaActionPerformed

    private void jBActualizarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarCatActionPerformed
        // TODO add your handling code here:
        this.jCBUsuario.removeAllItems();
        cargarCboxUsuario();
    }//GEN-LAST:event_jBActualizarCatActionPerformed

    private void jBActualizarLugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarLugActionPerformed
        // TODO add your handling code here:
        this.jCBLugar.removeAllItems();
        cargarCboxLugar();
    }//GEN-LAST:event_jBActualizarLugActionPerformed

    private void jBActualizarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarUsuActionPerformed
        // TODO add your handling code here:
        this.jCBUsuario.removeAllItems();
        cargarCboxUsuario();    
    }//GEN-LAST:event_jBActualizarUsuActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        if(editar){
            VerEquipos ve = new VerEquipos();
            EscritorioMenu.add(ve);
            ve.show();
        }
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        // TODO add your handling code here:
        if(editar){
            StringTokenizer tokens = new StringTokenizer(this.jCBLugar.getSelectedItem().toString());
            Lugar lug = IC.findLugar(Integer.parseInt(tokens.nextToken()));
            tokens = new StringTokenizer(this.jCBUsuario.getSelectedItem().toString());
            Usuario usu = IC.findUsuario(Integer.parseInt(tokens.nextToken()));
            tokens = new StringTokenizer(this.jCBCategoria.getSelectedItem().toString());
            Categoria cat = IC.findCategoria(Integer.parseInt(tokens.nextToken()));
            
            Dispositivo disp = new Dispositivo(Integer.parseInt(this.jTextId.getText()),this.jTextMarca.getText(),this.jTextModelo.getText(),this.jTextProcesador.getText(), this.jTextMemoria.getText(), this.jTextHDD.getText(), lug ,usu ,cat , this.jTextIp.getText(), this.jDFecha.getDate(), this.jTextProveedor.getText(), this.jCBEstado.getSelectedItem().toString(), Integer.parseInt(this.jTextGarantia.getText()), Integer.parseInt(this.jTextFactura.getText()), null, this.jTextComentario.getText());
            IC.actualizarEquipo(disp);
            VerEquipos ve = new VerEquipos();
            EscritorioMenu.add(ve);
            ve.show();
            dispose();
        }
        else
            dispose();
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jCBCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCategoriaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        // TODO add your handling code here:
        StringTokenizer tokens = new StringTokenizer(this.jCBCategoria.getSelectedItem().toString());
        Categoria cat = IC.findCategoria(Integer.parseInt(tokens.nextToken()));
        
        if(cat.getNombrePadre().equals("Computadora")){
            this.jTextIp.setEnabled(true);
            this.jTextProcesador.setEnabled(true);
            this.jTextMemoria.setEnabled(true);
            this.jTextHDD.setEnabled(true);
        }
        else{
            this.jTextIp.setEnabled(false);
            this.jTextProcesador.setEnabled(false);
            this.jTextMemoria.setEnabled(false);
            this.jTextHDD.setEnabled(false);
        
        }
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jButtonVerSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerSwActionPerformed
    ListarSoftware ls = new ListarSoftware(id);
    EscritorioMenu.add(ls);
    ls.show();
    }//GEN-LAST:event_jButtonVerSwActionPerformed

    private void jCBEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEstadoItemStateChanged
        // TODO add your handling code here:
        if(this.jCBEstado.getSelectedItem().toString().equals("DESUSO")){
            Lugar l = IC.findLugar(1);
            this.jCBLugar.setSelectedItem("1 - Central Informatica");
        }
    }//GEN-LAST:event_jCBEstadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBActualizarCat;
    private javax.swing.JButton jBActualizarLug;
    private javax.swing.JButton jBActualizarUsu;
    private javax.swing.JButton jBAddCategoria;
    private javax.swing.JButton jBAddLugar;
    private javax.swing.JButton jBAddUsuario;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBExaminar;
    private javax.swing.JButton jBVer;
    private javax.swing.JButton jButtonVerSw;
    private javax.swing.JComboBox jCBCategoria;
    private javax.swing.JComboBox jCBEstado;
    private javax.swing.JComboBox jCBLugar;
    private javax.swing.JComboBox jCBUsuario;
    private com.toedter.calendar.JDateChooser jDFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextComentario;
    private javax.swing.JTextField jTextFactura;
    private javax.swing.JTextField jTextGarantia;
    private javax.swing.JTextField jTextHDD;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextIp;
    private javax.swing.JTextField jTextMarca;
    private javax.swing.JTextField jTextMemoria;
    private javax.swing.JTextField jTextModelo;
    private javax.swing.JTextField jTextProcesador;
    private javax.swing.JTextField jTextProveedor;
    // End of variables declaration//GEN-END:variables
}

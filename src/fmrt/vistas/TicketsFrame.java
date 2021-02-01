/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.vistas;

import fmrt.dao.imp.DAOManager;
import fmrt.modelo.Categoria;
import fmrt.modelo.Chofer;
import fmrt.modelo.Empresa;
import fmrt.modelo.Producto;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class TicketsFrame extends javax.swing.JFrame {

    /**
     * Creates new form TicketsFrame
     */
    public TicketsFrame() {
        initComponents();
        dao = new DAOManager();
        llenarCombo();
    }
    
    private String convertirMayusculas(String text) {
        return text.toUpperCase();
    }
    
    private void llenarCombo() {
        List<Categoria> categorias;
        List<Producto> productos;
        
        try {
            categorias = dao.getCategoriaDAO().listar();
            Long categoriaId = categorias.get(0).getIdCategoria();
            System.out.println(categoriaId);
            productos = dao.getProductoDAO().filtrarPorCategoria(categoriaId);
            categorias.forEach((var categoria) -> {
                cbxCategoria.addItem(categoria);
            });
            productos.forEach((var producto) -> {
                cbxProducto.addItem(producto);
            });
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los combos");
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

        jLabel1 = new javax.swing.JLabel();
        txtTransporte = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxProducto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtChofer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtChasis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSemi = new javax.swing.JTextField();
        btnBuscarEmpresa = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        btnBuscarTransporte = new javax.swing.JButton();
        lblTransporte = new javax.swing.JLabel();
        lblChofer = new javax.swing.JLabel();
        btnBuscarChofer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tickets");
        setBackground(new java.awt.Color(175, 212, 237));

        jLabel1.setText("Transporte");

        txtTransporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTransporte.setEnabled(false);

        jLabel2.setText("Categoria");

        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Producto");

        jLabel4.setText("Cliente");

        txtCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCliente.setEnabled(false);

        jLabel5.setText("Chofer");

        txtChofer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtChofer.setEnabled(false);

        jLabel6.setText("Chasis");

        txtChasis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChasisKeyReleased(evt);
            }
        });

        jLabel7.setText("Semi");

        txtSemi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSemiKeyReleased(evt);
            }
        });

        btnBuscarEmpresa.setText("Buscar");
        btnBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpresaActionPerformed(evt);
            }
        });

        lblCliente.setText("Seleccione Cliente");

        btnBuscarTransporte.setText("Buscar");
        btnBuscarTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTransporteActionPerformed(evt);
            }
        });

        lblTransporte.setText("Selecccione Transporte");

        lblChofer.setText("Selecccione Chofer");

        btnBuscarChofer.setText("Buscar");
        btnBuscarChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarChoferActionPerformed(evt);
            }
        });

        jLabel8.setText("Número");

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
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(22, 22, 22))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarEmpresa))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtChofer, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTransporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarTransporte))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarChofer))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtChasis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSemi)))
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarTransporte)
                    .addComponent(lblTransporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarChofer)
                        .addComponent(lblChofer))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSemi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        try {
            cbxProducto.removeAllItems();
            Categoria c = (Categoria)cbxCategoria.getSelectedItem();
            List<Producto> productos = dao.getProductoDAO().filtrarPorCategoria(c.getIdCategoria());
            productos.forEach((var p) -> {
                cbxProducto.addItem(p);
            });
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los combos");
        }        
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void btnBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpresaActionPerformed
        EmpresasDialog empresas = new EmpresasDialog(this, true);
        empresas.pack();
        empresas.setVisible(true);
        
        Empresa e = empresas.getEmpresa();
        txtCliente.setText(String.valueOf(e.getId()));
        lblCliente.setText(e.getNombre());
    }//GEN-LAST:event_btnBuscarEmpresaActionPerformed

    private void btnBuscarTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTransporteActionPerformed
        EmpresasDialog empresas = new EmpresasDialog(this, true);
        empresas.pack();
        empresas.setVisible(true);
        
        Empresa e = empresas.getEmpresa();
        txtTransporte.setText(String.valueOf(e.getId()));
        lblTransporte.setText(e.getNombre());
    }//GEN-LAST:event_btnBuscarTransporteActionPerformed

    private void btnBuscarChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarChoferActionPerformed
        ChoferesDialog choferes = new ChoferesDialog(this, true);
        choferes.pack();        
        choferes.setVisible(true);
        
        Chofer c = choferes.getChofer();
        txtChofer.setText(String.valueOf(c.getId_chofer()));
        lblChofer.setText(c.getApellido() + " " + c.getNombre());
    }//GEN-LAST:event_btnBuscarChoferActionPerformed

    private void txtSemiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSemiKeyReleased
        txtSemi.setText(convertirMayusculas(txtSemi.getText()));
    }//GEN-LAST:event_txtSemiKeyReleased

    private void txtChasisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChasisKeyReleased
        txtChasis.setText(convertirMayusculas(txtChasis.getText()));      
    }//GEN-LAST:event_txtChasisKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarChofer;
    private javax.swing.JButton btnBuscarEmpresa;
    private javax.swing.JButton btnBuscarTransporte;
    private javax.swing.JComboBox<Categoria> cbxCategoria;
    private javax.swing.JComboBox<Producto> cbxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblChofer;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblTransporte;
    private javax.swing.JTextField txtChasis;
    private javax.swing.JTextField txtChofer;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSemi;
    private javax.swing.JTextField txtTransporte;
    // End of variables declaration//GEN-END:variables
    private fmrt.dao.imp.DAOManager dao;
}

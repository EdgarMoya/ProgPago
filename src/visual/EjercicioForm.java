package visual;

import dao.EjercicioDAO;
import entidades.Ejercicio;
import entidades.Periodo;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;

/**
 *
 * @author Lester
 */
public class EjercicioForm extends javax.swing.JPanel {

    private JD_Adicionar_ejercicio JDAdd;

    public EjercicioForm() {
        initComponents();
        
        //Editar color de la tabla
        JTableUtil.headerTable(jtEjercicios);
        JTableUtil.headerTable(jtPeriodo);
        JTableUtil.modTable(jtPeriodo, scrollPeriodo);
        mostrarEjerciciosActivos();
        
        //Seleccionar primer item por defecto
        seleccionarItem(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnAdd = new custom_swing.Button();
        split = new javax.swing.JSplitPane();
        scrollEjercicio = new javax.swing.JScrollPane();
        jtEjercicios = new javax.swing.JTable();
        scrollPeriodo = new javax.swing.JScrollPane();
        jtPeriodo = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar ejercicio");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        split.setBackground(new java.awt.Color(45, 125, 246));
        split.setDividerSize(2);
        split.setResizeWeight(0.5);

        scrollEjercicio.setBackground(new java.awt.Color(255, 255, 255));
        scrollEjercicio.setBorder(null);
        scrollEjercicio.setOpaque(false);

        jtEjercicios.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtEjercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ejercicio", "Inicio", "Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtEjercicios.setToolTipText("Lista de Ejercicios");
        jtEjercicios.setGridColor(new java.awt.Color(204, 204, 204));
        jtEjercicios.setRowHeight(25);
        jtEjercicios.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtEjercicios.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtEjercicios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtEjercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEjerciciosMouseClicked(evt);
            }
        });
        scrollEjercicio.setViewportView(jtEjercicios);

        split.setLeftComponent(scrollEjercicio);

        scrollPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        scrollPeriodo.setBorder(null);
        scrollPeriodo.setOpaque(false);

        jtPeriodo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtPeriodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Período", "Inicio", "Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPeriodo.setToolTipText("Lista de Períodos");
        jtPeriodo.setGridColor(new java.awt.Color(204, 204, 204));
        jtPeriodo.setMinimumSize(new java.awt.Dimension(50, 0));
        jtPeriodo.setRowHeight(25);
        jtPeriodo.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtPeriodo.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPeriodoMouseClicked(evt);
            }
        });
        scrollPeriodo.setViewportView(jtPeriodo);

        split.setRightComponent(scrollPeriodo);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtEjerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEjerciciosMouseClicked
        int pos = jtEjercicios.getSelectedRow();
        String value = jtEjercicios.getModel().getValueAt(pos, 0).toString(); 
        if (pos != -1) {
            mostrarPeriodos(value);
        } else {
            // Nada
        }
    }//GEN-LAST:event_jtEjerciciosMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar ejercicio
        JDAdd = new JD_Adicionar_ejercicio(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){
            mostrarEjerciciosActivos();
            seleccionarItem(0);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPeriodoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPeriodoMouseClicked

    //Método para actualizar la tabla con la lista de clientes
    private void mostrarEjerciciosActivos() {
        EjercicioDAO dao = new EjercicioDAO();
        String[] columnNames = {"Ejercicio", "Inicio", "Fin"};
        ArrayList<Ejercicio> ejercicios = new ArrayList<>();
        try {
            ejercicios = dao.listaEjercicios();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[ejercicios.size()][3];        
        for (int i = 0; i < ejercicios.size(); i++) {
            data[i][0] = ejercicios.get(i).getEjercicio();
            data[i][1] = ""+ejercicios.get(i).getFecha_inicio();
            data[i][2] = ""+ejercicios.get(i).getFecha_fin();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtEjercicios.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtEjercicios, scrollEjercicio);          
    }
    
    // Mostar período correspondiente
    private void mostrarPeriodos(String ejercicio) {
        EjercicioDAO dao = new EjercicioDAO();
        String[] columnNames = {"Período", "Inicio", "Fin"};
        ArrayList<Periodo> periodos = new ArrayList<>();
        try {
            periodos = dao.listaPeriodos(ejercicio);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[periodos.size()][3];        
        for (int i = 0; i < periodos.size(); i++) {
            data[i][0] = periodos.get(i).getNombre();
            data[i][1] = ""+periodos.get(i).getFecha_inicio();
            data[i][2] = ""+periodos.get(i).getFecha_fin();            
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtPeriodo.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtPeriodo, scrollPeriodo);       
    }
    
    
    private void seleccionarItem(int pos){
        jtEjercicios.getSelectionModel().setSelectionInterval(pos, pos);
        if (jtEjercicios.getModel().getRowCount() >= 1){
            String value = jtEjercicios.getModel().getValueAt(pos, pos).toString(); 
            mostrarPeriodos(value);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.Button btnAdd;
    private javax.swing.JTable jtEjercicios;
    private javax.swing.JTable jtPeriodo;
    private javax.swing.JScrollPane scrollEjercicio;
    private javax.swing.JScrollPane scrollPeriodo;
    private javax.swing.JSplitPane split;
    // End of variables declaration//GEN-END:variables
}

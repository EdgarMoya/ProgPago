package visual;

import custom_swing.Menu.Event.EventMenuSelected;
import custom_swing.Menu.Event.EventShowPopupMenu;
import custom_swing.Menu.Header;
import custom_swing.Menu.Menu;
import custom_swing.Menu.MenuItem;
import custom_swing.Menu.PopupMenu;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class VentanaPrincipal extends javax.swing.JFrame {

    private MigLayout layout;
    private Header header;
    private Menu menu;
    //private MainForm main;
    private Animator animator;
    
    public VentanaPrincipal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);   
        setIconImage(getIconImage()); 
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);  
        menu = new Menu();
        header = new Header();
        //main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        //main.showForm(new Form_Home());
                    } else if (subMenuIndex == 1) {
                        //main.showForm(new Form1());
                    }
                }
            }
        });
        
        //Evento cuando está ocultado el munú
        //Muestra las opciones en un popup
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;               
                PopupMenu popup = new PopupMenu(VentanaPrincipal.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());                                             
                int x = VentanaPrincipal.this.getX() + 52;
                int y = VentanaPrincipal.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);                              
            }
        });
        
        //Agregando componentes al panel
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 80!, wrap");
        //bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        
        
        /*********************
        //Eventos del Header
        **********************/
        //Evento para mostrar y ocultar el menú
        header.addMenuEvent(new ActionListener() {        
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);                             
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });   
        
        //Mouse clicked en jLabel OPCIONES
        header.addOpcionesEvent(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                //No hacer nada
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //No hacer nada
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                //No hacer nada
            }
            @Override
            public void mouseExited(MouseEvent e) {
                //No hacer nada
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                //Abrir popupMenu con todas las opciones
            }                           
        });
        //  Start with this form
        //main.showForm(new Form_Home());
    }
    
    
    @Override
    public Image getIconImage (){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo_chart.png"));
        return res;
    } 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Tesorería");

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

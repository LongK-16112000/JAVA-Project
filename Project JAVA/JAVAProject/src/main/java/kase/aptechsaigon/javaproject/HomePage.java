/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Truc
 */
public class HomePage extends javax.swing.JFrame {
    private static boolean isLogin; // Biến này dùng để kiểm tra đăng nhập = false
    private static final Login lg = new Login();  // Cửa sổ đăng nhập
    public static final HomePage hp = new HomePage();  // Đối tượng của HomePage
    private boolean isLoggedIn;
    private PanelCTH panelCth;
    private JPanel cth = new JPanel();
    private PanelTĐMK panelTĐMK;
    private JPanel tđmk = new JPanel();
    private PanelMH panelMh;
    private JPanel mh = new JPanel();
    private PanelHK panelHk;
    private JPanel hk = new JPanel();
    private PanelNV panelnv;
    private JPanel nv = new JPanel();
    private PanelPB panelpb;
    private JPanel pb = new JPanel();
    private PanelPB panelbl;
    private JPanel bl = new JPanel();
    private boolean isPanelNVVisible = false;
    private boolean isPanelCTHVisible = false;
    private boolean isPanelMHVisible = false;
    private boolean isPanelHKVisible = false;
    private boolean isPanelPBVisible = false;
    private boolean isPanelBLVisible = false;
    private boolean isPanelTĐMKVisible = false;
    
    public HomePage() {
        initComponents();
//         Ẩn menu mặc định khi chưa đăng nhập
        jMenuBar1.setVisible(false);
          // Lắng nghe sự kiện cửa sổ đăng nhập
        lg.addWindowListener(getWindowAdapter());
    }
    
    private void showPanel(JPanel panel) {
        // Ẩn tất cả các panel hiện tại trước khi hiển thị panel mới
       mh.setVisible(false);
       cth.setVisible(false);
       hk.setVisible(false);
       nv.setVisible(false);
       pb.setVisible(false);
       bl.setVisible(false);
       tđmk.setVisible(false);

       // Thêm panel mới vào jPanel và hiển thị
       jPanel.removeAll();
       jPanel.add(panel);  // Thêm panel mới vào jPanel
       jPanel.revalidate();  // Cập nhật lại giao diện
       jPanel.repaint();     // Vẽ lại giao diện
    }
    
    public void SetPermission(boolean isLogin) {
        this.isLogin = isLogin;
        jMenuBar1.setVisible(isLogin);  // Hiển thị hoặc ẩn menu dựa trên trạng thái đăng nhập
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel.setBackground(new java.awt.Color(255, 255, 255,0
        ));
        jPanel.setPreferredSize(new java.awt.Dimension(1485, 820));
        jPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1540, 730));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img123.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 2570, 1120));

        jMenu1.setText("Tài Khoản");

        jMenuItem1.setText("Thông tin cá nhân");
        jMenuItem1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jMenuItem1ComponentShown(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Thay đổi mật khẩu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Đăng xuất");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Nhân Sự");

        jMenuItem4.setText("Bảng lương");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Phòng ban");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Nhân viên");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Chương Trình Học");
        jMenu4.setDelay(0);

        jMenuItem7.setText("Thông tin chương trình học");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Môn học");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Học Kỳ");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Dạy Học");

        jMenuItem11.setText("Học viên");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Đăng ký môn học");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("Lịch học");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Kiểm tra nếu PanelCTH chưa hiển thị
        if (!isPanelTĐMKVisible) {
            // Ẩn tất cả các panel đang hiển thị
            mh.setVisible(false);
            cth.setVisible(false);
            hk.setVisible(false);
            pb.setVisible(false);
            bl.setVisible(false);
            nv.setVisible(false);
        
            // Hiển thị PanelCTH
            showPanel(new PanelTĐMK());
            isPanelTĐMKVisible = true;
        }
        else {
            // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
            tđmk.setVisible(false);
            isPanelTĐMKVisible = false;
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Ẩn menu bar
        jMenuBar1.setVisible(false);

        // Hiển thị lại màn hình login
        lg.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         // Kiểm tra nếu PanelCTH chưa hiển thị
        if (!isPanelPBVisible) {
            // Ẩn tất cả các panel đang hiển thị
            mh.setVisible(false);
            cth.setVisible(false);
            hk.setVisible(false);
            nv.setVisible(false);
            bl.setVisible(false);
            tđmk.setVisible(false);


            // Hiển thị PanelCTH
            showPanel(new PanelPB());
            isPanelPBVisible = true;
        }
        else {
            // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
            cth.setVisible(false);
            isPanelPBVisible = false;
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
  
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         // Kiểm tra nếu PanelCTH chưa hiển thị
        if (!isPanelNVVisible) {
            // Ẩn tất cả các panel đang hiển thị
            mh.setVisible(false);
            cth.setVisible(false);
            hk.setVisible(false);
            pb.setVisible(false);
            bl.setVisible(false);
            tđmk.setVisible(false);

            // Hiển thị PanelCTH
            showPanel(new PanelNV());
            isPanelNVVisible = true;
        }
        else {
            // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
            cth.setVisible(false);
            isPanelNVVisible = false;
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed

    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuItem1ComponentShown
    
    }//GEN-LAST:event_jMenuItem1ComponentShown

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    if (!isPanelBLVisible) {
            // Ẩn tất cả các panel đang hiển thị
            mh.setVisible(false);
            cth.setVisible(false);
            hk.setVisible(false);
            pb.setVisible(false);
            nv.setVisible(false);
            tđmk.setVisible(false);

            // Hiển thị PanelCTH
            showPanel(new PanelBL());
            isPanelBLVisible = true;
        } else {
            // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
            bl.setVisible(false);
            isPanelBLVisible = false;
        }    
    }//GEN-LAST:event_jMenuItem4ActionPerformed

  
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Kiểm tra nếu PanelCTH chưa hiển thị
        if (!isPanelCTHVisible) {
            // Ẩn tất cả các panel đang hiển thị
            mh.setVisible(false);
            hk.setVisible(false);
            isPanelMHVisible = isPanelHKVisible = false;
            nv.setVisible(false);
            pb.setVisible(false);
            bl.setVisible(false);
            tđmk.setVisible(false);
            // Hiển thị PanelCTH
            showPanel(new PanelCTH());
            isPanelCTHVisible = true;
        }
        else {
            // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
            cth.setVisible(false);
            isPanelCTHVisible = false;
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed
   
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Kiểm tra nếu PanelCTH chưa hiển thị
        if (!isPanelMHVisible) {
            // Ẩn tất cả các panel đang hiển thị
            cth.setVisible(false);
            hk.setVisible(false);
            nv.setVisible(false);
            pb.setVisible(false);
            bl.setVisible(false);
            tđmk.setVisible(false);

            // Hiển thị PanelCTH
            showPanel(new PanelMH());
            isPanelMHVisible = true;
        }
        else {
            // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
            mh.setVisible(false);
            isPanelMHVisible = false;
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
    // Kiểm tra nếu PanelCTH chưa hiển thị
    if (!isPanelHKVisible) {
        // Ẩn tất cả các panel đang hiển thị
        mh.setVisible(false);
        cth.setVisible(false);
        pb.setVisible(false);
        nv.setVisible(false);
        bl.setVisible(false);
        tđmk.setVisible(false);

        // Hiển thị PanelCTH
        showPanel(new PanelHK());
        isPanelHKVisible = true;
    } else {
        // Nếu PanelCTH đã hiển thị, ẩn nó khi nhấn lần nữa
        hk.setVisible(false);
        isPanelHKVisible = false;
    }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

    }//GEN-LAST:event_jMenuItem11ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Tạo JMenuBar và thiết lập màu nền
        UIManager.put("MenuBar.background", Color.DARK_GRAY);
        hp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        hp.toFront();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                hp.setVisible(true);
                
                if (!isLogin) {
                    lg.setVisible(true); // Hiển thị cửa sổ đăng nhập nếu chưa đăng nhập
                }
            }
        });
    
    }
    private void showChild(JFrame child) {
        child.setExtendedState(JFrame.MAXIMIZED_BOTH);
        var childContent = child.getContentPane();
        this.setContentPane(childContent);
    }
    
    private WindowAdapter getWindowAdapter() {
        return new WindowAdapter() {
          @Override
          public void windowIconified(WindowEvent we) {
            SetPermission(true);
          }
        };
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables


    void setPermission(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    
    
}

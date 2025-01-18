/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    public HomePage() {
        initComponents();
        
       
       
      
       
        // Ẩn menu mặc định khi chưa đăng nhập
//        jMenuBar1.setVisible(false);
        
          // Lắng nghe sự kiện cửa sổ đăng nhập
        lg.addWindowListener(getWindowAdapter());
        
//      
    }
    private void showPanel(JPanel panel) {
      cth.removeAll();  // Xóa tất cả các component trong cth
    jPanel.add(panel);    // Thêm panel mới vào cth
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
        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1510, 730));

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

        jMenuItem9.setText("Chứng chỉ");
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
// private void hideAllPanels() {
//        // Danh sách các JPanel cần ẩn
//        JPanel[] panels = {  jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp10, jp11, jp12, jp13, jp14 };
//
//        // Ẩn tất cả các JPanel
//        for (JPanel panel : panels) {
//            panel.setVisible(false);
//        }
//    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//       // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp3.setVisible(true);  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//         // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp4.setVisible(true);  
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
//         // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp5.setVisible(true);  

    }//GEN-LAST:event_jMenuItem5ActionPerformed
    private boolean isPanelNVisible = false;
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
//         // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
    if (!isPanelNVisible) {
        showPanel(new PanelNV());
        isPanelNVisible = true;
    }
//        // Chỉ mở jp3
//        jp6.setVisible(true);  

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
//        // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp7.setVisible(true);  
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
//         // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp8.setVisible(true);  
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuItem1ComponentShown
    
    }//GEN-LAST:event_jMenuItem1ComponentShown

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
//      // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp10.setVisible(true);  
//        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private boolean isPanelCTHVisible = false;
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
     if (!isPanelCTHVisible) {
        showPanel(new PanelCTH());
        isPanelCTHVisible = true;
    }
    }//GEN-LAST:event_jMenuItem7ActionPerformed
   
  
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
//       // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp11.setVisible(true);  
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
//         // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp12.setVisible(true);  
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
//      // Giả sử bạn có 14 JPanel từ jp1 đến jp14
//        hideAllPanels();
//
//        // Chỉ mở jp3
//        jp13.setVisible(true);  
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
//                    lg.setVisible(true); // Hiển thị cửa sổ đăng nhập nếu chưa đăng nhập
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

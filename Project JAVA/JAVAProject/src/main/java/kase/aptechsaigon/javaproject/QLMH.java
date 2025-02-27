/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truc
 */
public class QLMH extends javax.swing.JFrame {

    /**
     * Creates new form QLMH
     */
    public QLMH() {
        initComponents();
        loadComboBoxData();
            ComboBoxmh.addActionListener(e -> {
           String selectedMonHoc = (String) ComboBoxmh.getSelectedItem();  // Lấy môn học đã chọn từ ComboBox

           // Kiểm tra nếu người dùng chọn môn học và không chọn mục "Chọn Môn Học"
           if (selectedMonHoc != null && !selectedMonHoc.equals("Chọn Môn Học")) {
               // Lấy mã môn học từ tên môn học
               String maMonHoc = getMaMonHocByTenMonHoc(selectedMonHoc);

               if (maMonHoc != null) {
                   // Lấy tên học kỳ từ mã môn học và hiển thị
                   displayHocKy(maMonHoc);
                    // Hiển thị tên học kỳ vào TextField
               } else {
                   System.out.println("Không tìm thấy mã môn học tương ứng với tên môn học.");
               }
           }
       });

    }
  
// Biến kiểm tra ComboBox đã được load chưa
private boolean isMonHocComboBoxLoaded = false;



private void loadComboBoxData() {
    try (Connection conn = DatabaseConnection.connect()) {
        // Câu truy vấn SQL để lấy danh sách môn học từ bảng HocKy_MonHoc
        String sql = "SELECT DISTINCT MonHoc.TenMonHoc " +
                     "FROM HocKy_MonHoc " +
                     "JOIN MonHoc ON HocKy_MonHoc.MaMonHoc = MonHoc.MaMonHoc";
        
        // Thực hiện truy vấn
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        // Làm mới lại ComboBox mỗi lần tải dữ liệu mới
        ComboBoxmh.removeAllItems();
        
        // Thêm mục mặc định "Chọn Môn Học"
        ComboBoxmh.addItem("Chọn Môn Học");

        // Lặp qua kết quả truy vấn và thêm các môn học vào ComboBox
        while (rs.next()) {
            String tenMonHoc = rs.getString("TenMonHoc");
            ComboBoxmh.addItem(tenMonHoc);  // Thêm tên môn học vào ComboBox
        }
        
        rs.close();
        stmt.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}




private String getMaMonHocByTenMonHoc(String tenMonHoc) {
    String maMonHoc = null;
    try (Connection conn = DatabaseConnection.connect()) {
        String sql = "SELECT MaMonHoc FROM MonHoc WHERE TenMonHoc = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tenMonHoc);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            maMonHoc = rs.getString("MaMonHoc");
        }

        rs.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maMonHoc;
}

private String getHocKyByMonHoc(String maMonHoc) {
    String tenHocKy = "";
    String sql = "SELECT HocKy.TenHocKy FROM HocKy_MonHoc " +
                 "JOIN HocKy ON HocKy_MonHoc.MaHocKy = HocKy.MaHocKy " +
                 "WHERE HocKy_MonHoc.MaMonHoc = ?";

    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, maMonHoc);  // Set mã môn học vào câu truy vấn
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            tenHocKy = rs.getString("TenHocKy");  // Lấy tên học kỳ
        }

        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tenHocKy;
}



private void displayHocKy(String maMonHoc) {
    DefaultTableModel model = (DefaultTableModel) tableData.getModel();
    model.setRowCount(0);  // Xóa dữ liệu cũ trong bảng

    // SQL query để lấy tên học kỳ từ bảng HocKy qua bảng HocKy_MonHoc
    String sql = "SELECT HocKy.TenHocKy " +
                 "FROM HocKy_MonHoc " +
                 "JOIN HocKy ON HocKy_MonHoc.MaHocKy = HocKy.MaHocKy " +
                 "WHERE HocKy_MonHoc.MaMonHoc = ?";

    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, maMonHoc);  // Set giá trị maMonHoc vào câu truy vấn
        ResultSet rs = ps.executeQuery();

        // Lặp qua từng dòng dữ liệu trong ResultSet và thêm tên học kỳ vào bảng
        while (rs.next()) {
            String tenHocKy = rs.getString("TenHocKy");

            // Thêm dữ liệu vào bảng (chỉ có tên học kỳ)
            model.addRow(new Object[]{tenHocKy});
        }

        // Nếu có dữ liệu, tự động chọn dòng đầu tiên
        if (tableData.getRowCount() > 0) {
            tableData.setRowSelectionInterval(0, 0);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}





// Sự kiện khi người dùng chọn một dòng trong bảng HocKy





    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMonHoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTenHocKy = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        ComboBoxmh = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255,0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1161, 230));

        tableData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tên Học Kỳ"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 200));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Học Kỳ:");

        txtTenMonHoc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTenMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMonHocActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Môn Học :");

        txtTenHocKy.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        btnCancel.setBackground(new java.awt.Color(0, 51, 153));
        btnCancel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 51, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(btnSave))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btnAdd.setBackground(new java.awt.Color(0, 51, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 51, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        ComboBoxmh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ComboBoxmh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Môn Học" }));
        ComboBoxmh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxmhActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(ComboBoxmh, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(293, 293, 293)
                        .addComponent(btnAdd)
                        .addGap(29, 29, 29)
                        .addComponent(btnDelete))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxmh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img123.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(550, 400));
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1205, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMonHocActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
     
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void ComboBoxmhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxmhActionPerformed
  // Phương thức xử lý sự kiện khi người dùng chọn môn học từ ComboBox
    // Lấy tên môn học đã chọn từ ComboBox
    String tenMonHoc = (String) ComboBoxmh.getSelectedItem();

    // Kiểm tra nếu người dùng chưa chọn môn học (nếu chọn "Chọn Môn Học" thì không làm gì)
    if (!"Chọn Môn Học".equals(tenMonHoc)) {
        // Lấy mã môn học từ tên môn học
        String maMonHoc = getMaMonHocByTenMonHoc(tenMonHoc);

        // Lấy tên học kỳ từ mã môn học và điền vào TextField
        String tenHocKy = getHocKyByMonHoc(maMonHoc);
        txtTenMonHoc.setText(tenMonHoc); 
        txtTenHocKy.setText(tenHocKy);  // Điền tên học kỳ vào TextField
    } else {
        txtTenHocKy.setText("");  // Nếu chưa chọn môn học, thì xóa dữ liệu trong TextField
    }


    }//GEN-LAST:event_ComboBoxmhActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(QLMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new QLMH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxmh;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtTenHocKy;
    private javax.swing.JTextField txtTenMonHoc;
    // End of variables declaration//GEN-END:variables
}

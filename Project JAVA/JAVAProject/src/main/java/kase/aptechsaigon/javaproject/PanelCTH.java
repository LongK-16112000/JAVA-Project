/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truc
 */
public class PanelCTH extends JPanel {

    /**
     * Creates new form PanelCTH
     */
    public PanelCTH() {
        initComponents();
//          CHƯƠNG TRÌNH HỌC
        btnAdd.addActionListener(e -> addChuongTrinhHoc());
        btnUpdate.addActionListener(e -> updateChuongTrinhHoc());
        btnDelete.addActionListener(e -> deleteChuongTrinhHoc());
        // Thêm ListSelectionListener để tự động điền dữ liệu khi chọn dòng trong JTable
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Kiểm tra xem có dòng nào được chọn hay không
                int selectedRow = jTable1.getSelectedRow();

                // Nếu có dòng được chọn, điền dữ liệu vào các TextField
                if (selectedRow >= 0) {
                    int maChuongTrinh = (int) jTable1.getValueAt(selectedRow, 0); 
                    String tenChuongTrinh = (String) jTable1.getValueAt(selectedRow, 1);  // Cột 1 là Tên Chương Trình
                    int thoiGianHoanThanh = (int) jTable1.getValueAt(selectedRow, 2);  // Cột 2 là Thời Gian Hoàn Thành

                    // Cập nhật nội dung cho các JTextField
                     // Hiển thị mã chương trình học
                    txtMaChuongTrinh.setText(String.valueOf(maChuongTrinh));
                    txtTenChuongTrinh.setText(tenChuongTrinh);  // Hiển thị tên chương trình học
                    txtThoiGianHoanThanh.setText(String.valueOf(thoiGianHoanThanh));  // Hiển thị thời gian hoàn thành
                } else {
                    // Nếu không có dòng nào được chọn, làm trống các TextField
                    txtMaChuongTrinh.setText("");
                    txtTenChuongTrinh.setText("");
                    txtThoiGianHoanThanh.setText("");
                }
            }
        });
        
        
     
        displayChuongTrinhHoc();  
    }
   



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jp9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenChuongTrinh = new javax.swing.JTextField();
        txtThoiGianHoanThanh = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaChuongTrinh = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy");

        setBackground(new java.awt.Color(255, 255, 255,0
        ));
        setLayout(new java.awt.BorderLayout());

        jp9.setBackground(new java.awt.Color(255, 255, 255,0));
        jp9.setPreferredSize(new java.awt.Dimension(1500, 820));
        jp9.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jp9AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255,0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255,0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thông tin Chương Trình Học");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255,0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã", "Tên Chương Trình", "Thời Gian Chương Trình"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Thời Gian Chương Trình :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Chương Trình :");

        txtTenChuongTrinh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTenChuongTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenChuongTrinhActionPerformed(evt);
            }
        });

        txtThoiGianHoanThanh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtThoiGianHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianHoanThanhActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 51, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdate.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Chương Trình");

        txtMaChuongTrinh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenChuongTrinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaChuongTrinh, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(81, 81, 81))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jp9Layout = new javax.swing.GroupLayout(jp9);
        jp9.setLayout(jp9Layout);
        jp9Layout.setHorizontalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jp9Layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp9Layout.setVerticalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp9Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jp9, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jp9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jp9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jp9AncestorAdded

    private void txtTenChuongTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenChuongTrinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenChuongTrinhActionPerformed

    private void txtThoiGianHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianHoanThanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianHoanThanhActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed
  private void displayChuongTrinhHoc() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa dữ liệu cũ trong bảng
         String sql = "SELECT * FROM ChuongTrinhHoc";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maChuongTrinhHoc = rs.getInt("MaChuongTrinhHoc");
                String tenChuongTrinh = rs.getString("TenChuongTrinh");
                int thoiGianHoanThanh = rs.getInt("ThoiGianHoanThanh");

                model.addRow(new Object[]{maChuongTrinhHoc, tenChuongTrinh, thoiGianHoanThanh});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void addChuongTrinhHoc() {
    // Lấy giá trị từ TextField
    String tenChuongTrinh = txtTenChuongTrinh.getText();
    String thoiGianHoanThanhText = txtThoiGianHoanThanh.getText();

    // Kiểm tra nếu giá trị của thoiGianHoanThanh không phải là chuỗi rỗng
    if (tenChuongTrinh.isEmpty() || thoiGianHoanThanhText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
        return;  // Dừng lại nếu dữ liệu không hợp lệ
    }

    int thoiGianHoanThanh;
    try {
        thoiGianHoanThanh = Integer.parseInt(thoiGianHoanThanhText); // Chuyển đổi thành số nguyên
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Thời gian hoàn thành phải là một số hợp lệ!");
        return;  // Dừng lại nếu dữ liệu không hợp lệ
    }
 // Tìm mã chương trình học mới bằng cách lấy mã lớn nhất hiện tại
    int maChuongTrinhHocMoi = getNextMaChuongTrinhHoc();


    // Câu lệnh SQL để thêm chương trình học
    String sql = "INSERT INTO ChuongTrinhHoc (MaChuongTrinhHoc, TenChuongTrinh, ThoiGianHoanThanh) VALUES (?, ?, ?)";
    
    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Set các tham số vào PreparedStatement
        ps.setInt(1, maChuongTrinhHocMoi);
        ps.setString(2, tenChuongTrinh);
        ps.setInt(3, thoiGianHoanThanh);

        // Thực thi câu lệnh SQL
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Chương trình học đã được thêm thành công!");

            // Làm trống các TextField sau khi thêm
        
            txtTenChuongTrinh.setText("");
            txtThoiGianHoanThanh.setText("");

            // Cập nhật lại bảng sau khi thêm
            displayChuongTrinhHoc();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm chương trình học.");
    }
}

    // Hàm để lấy mã chương trình học tiếp theo
    private int getNextMaChuongTrinhHoc() {
    String sql = "SELECT MAX(MaChuongTrinhHoc) FROM ChuongTrinhHoc";

    try (Connection conn = DatabaseConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        if (rs.next()) {
            // Lấy giá trị mã chương trình học lớn nhất và cộng thêm 1
            return rs.getInt(1) + 1;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Nếu không có dữ liệu trong bảng, bắt đầu từ 1
    return 1;
}



   private void updateChuongTrinhHoc() {
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow >= 0) {
        // Lấy mã chương trình học từ cột đầu tiên của dòng đã chọn
        int maChuongTrinhHoc = (int) jTable1.getValueAt(selectedRow, 0);
        
        // Lấy các giá trị nhập vào từ các TextField
        String tenChuongTrinh = txtTenChuongTrinh.getText();
        String thoiGianHoanThanhText = txtThoiGianHoanThanh.getText();
        
        // Kiểm tra nếu các TextField không trống
        if (tenChuongTrinh.isEmpty() || thoiGianHoanThanhText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;  // Dừng lại nếu không có đủ thông tin
        }

        int thoiGianHoanThanh;
        try {
            thoiGianHoanThanh = Integer.parseInt(thoiGianHoanThanhText); // Chuyển đổi thành số nguyên
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Thời gian hoàn thành phải là một số hợp lệ!");
            return;  // Dừng lại nếu không phải là số hợp lệ
        }

        // Câu lệnh SQL để cập nhật thông tin chương trình học
        String sql = "UPDATE ChuongTrinhHoc SET TenChuongTrinh = ?, ThoiGianHoanThanh = ? WHERE MaChuongTrinhHoc = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Đặt các tham số vào PreparedStatement
            ps.setString(1, tenChuongTrinh);
            ps.setInt(2, thoiGianHoanThanh);
            ps.setInt(3, maChuongTrinhHoc); // Thêm điều kiện WHERE để chỉ cập nhật bản ghi có mã này

            // Thực thi câu lệnh SQL
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Chương trình học đã được cập nhật thành công!");
                
                // Cập nhật lại bảng sau khi cập nhật
                displayChuongTrinhHoc();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật chương trình học.");
        }
    } else {
        // Thông báo nếu chưa chọn dòng trong JTable
        JOptionPane.showMessageDialog(null, "Vui lòng chọn chương trình học để cập nhật.");
    }
}





    private void deleteChuongTrinhHoc() {
    int selectedRow = jTable1.getSelectedRow();  // Lấy dòng được chọn trong bảng
    if (selectedRow >= 0) {
        // Lấy Mã Chương Trình từ dòng đã chọn
        int maChuongTrinhHoc = (int) jTable1.getValueAt(selectedRow, 0);

        // Câu lệnh SQL để xóa chương trình học khỏi cơ sở dữ liệu
        String sqlDelete = "DELETE FROM ChuongTrinhHoc WHERE MaChuongTrinhHoc = ?";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement psDelete = conn.prepareStatement(sqlDelete)) {

            psDelete.setInt(1, maChuongTrinhHoc);  // Đặt tham số vào câu lệnh SQL
            int rowsAffected = psDelete.executeUpdate();  // Thực hiện câu lệnh xóa

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Chương trình học đã được xóa thành công!");

                // Sau khi xóa, làm mới lại dữ liệu trong bảng
                displayChuongTrinhHoc();  // Cập nhật lại bảng từ cơ sở dữ liệu
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy chương trình học để xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xóa chương trình học.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn chương trình học để xóa.");
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jp9;
    private javax.swing.JTextField txtMaChuongTrinh;
    private javax.swing.JTextField txtTenChuongTrinh;
    private javax.swing.JTextField txtThoiGianHoanThanh;
    // End of variables declaration//GEN-END:variables
}

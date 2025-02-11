/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truc
 */
public class PanelMH extends JPanel {
   
    /**
     * Creates new form PanelCC
     */
    public PanelMH() {
        initComponents();  
        btnAdd.addActionListener(e -> addMonHoc());
        btnUpdate.addActionListener(e -> updateMonHoc());
        btnDelete.addActionListener(e -> deleteMonHoc());

// Thêm ListSelectionListener để tự động điền dữ liệu khi chọn dòng trong JTable
    jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Kiểm tra xem có dòng nào được chọn hay không
        int selectedRow = jTable1.getSelectedRow();

        // Nếu có dòng được chọn, điền dữ liệu vào các TextField
        if (selectedRow >= 0) {

            // Lấy giá trị từ các cột trong dòng được chọn
            int maMonHoc = (int) jTable1.getValueAt(selectedRow, 0);  // Cột 2 là Số Buổi Học
            String tenMonHoc = (String) jTable1.getValueAt(selectedRow, 1);  // Cột 1 là Tên Môn Học
            int soBuoiHoc = (int) jTable1.getValueAt(selectedRow, 2);  // Cột 2 là Số Buổi Học
            int soGioHocMoiBuoi = (int) jTable1.getValueAt(selectedRow, 3);  // Cột 3 là Số Giờ Học Mỗi Buổi

            // Cập nhật nội dung cho các JTextField
            txtMaMonHoc.setText(String.valueOf(maMonHoc));
            txtTenMonHoc.setText(tenMonHoc);  // Hiển thị tên môn học
            txtSoBuoiHoc.setText(String.valueOf(soBuoiHoc));  // Hiển thị số buổi học
            txtSoGioHocMoiBuoi.setText(String.valueOf(soGioHocMoiBuoi));  // Hiển thị số giờ học mỗi buổi
        } else {
            // Nếu không có dòng nào được chọn, làm trống các TextField
            txtMaMonHoc.setText("");
            txtTenMonHoc.setText("");
            txtSoBuoiHoc.setText("");
            txtSoGioHocMoiBuoi.setText("");
        }
    }
});

        
         displayMonHoc(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMonHoc = new javax.swing.JTextField();
        txtSoGioHocMoiBuoi = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSoBuoiHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaMonHoc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();

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
        jLabel2.setText("Thông Tin Môn Học");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jPanel3.setPreferredSize(new java.awt.Dimension(1460, 567));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số Giờ Học Mỗi Buổi :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Môn Học:");

        txtTenMonHoc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTenMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMonHocActionPerformed(evt);
            }
        });

        txtSoGioHocMoiBuoi.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtSoGioHocMoiBuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoGioHocMoiBuoiActionPerformed(evt);
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
        jLabel1.setText("Số Buổi Học :");

        txtSoBuoiHoc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Môn Học");

        txtMaMonHoc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtMaMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaMonHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenMonHoc)
                    .addComponent(txtSoGioHocMoiBuoi)
                    .addComponent(txtSoBuoiHoc)
                    .addComponent(txtMaMonHoc)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(38, 38, 38)
                        .addComponent(btnDelete)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoBuoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoGioHocMoiBuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Môn Học", "Tên  Môn Học", "Số Buổi Học", "Số Giờ Học Mỗi Buổi"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jp9Layout = new javax.swing.GroupLayout(jp9);
        jp9.setLayout(jp9Layout);
        jp9Layout.setHorizontalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp9Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1478, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp9Layout.setVerticalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp9Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        add(jp9, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jp9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jp9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jp9AncestorAdded

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSoGioHocMoiBuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoGioHocMoiBuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoGioHocMoiBuoiActionPerformed

    private void txtTenMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMonHocActionPerformed

    private void txtMaMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaMonHocActionPerformed
     // Hiển thị dữ liệu môn học lên JTable
    private void displayMonHoc() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa dữ liệu cũ trong bảng
        String sql = "SELECT * FROM MonHoc";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maMonHoc = rs.getInt("MaMonHoc");
                String tenMonHoc = rs.getString("TenMonHoc");
                int soBuoiHoc = rs.getInt("SoBuoiHoc");
                int soGioHocMoiBuoi = rs.getInt("SoGioHocMoiBuoi");

                model.addRow(new Object[]{maMonHoc, tenMonHoc, soBuoiHoc, soGioHocMoiBuoi});
            }
            if(jTable1.getRowCount()>0){
                jTable1.setRowSelectionInterval(0, 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Thêm môn học
    private void addMonHoc() {
        String tenMonHoc = txtTenMonHoc.getText();
        String soBuoiHocText = txtSoBuoiHoc.getText();
        String soGioHocMoiBuoiText = txtSoGioHocMoiBuoi.getText();

        if (tenMonHoc.isEmpty() || soBuoiHocText.isEmpty() || soGioHocMoiBuoiText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        int soBuoiHoc, soGioHocMoiBuoi;
        try {
            soBuoiHoc = Integer.parseInt(soBuoiHocText);
            soGioHocMoiBuoi = Integer.parseInt(soGioHocMoiBuoiText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số buổi học và số giờ học mỗi buổi phải là các số hợp lệ!");
            return;
        }

        int maMonHocMoi = getNextMaMonHoc();

        String sql = "INSERT INTO MonHoc (MaMonHoc, TenMonHoc, SoBuoiHoc, SoGioHocMoiBuoi) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maMonHocMoi);
            ps.setString(2, tenMonHoc);
            ps.setInt(3, soBuoiHoc);
            ps.setInt(4, soGioHocMoiBuoi);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Môn học đã được thêm thành công!");
                txtTenMonHoc.setText("");
                txtSoBuoiHoc.setText("");
                txtSoGioHocMoiBuoi.setText("");
                displayMonHoc(); // Cập nhật lại bảng sau khi thêm
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm môn học.");
        }
    }

    // Hàm để lấy mã môn học tiếp theo
    private int getNextMaMonHoc() {
        String sql = "SELECT MAX(MaMonHoc) FROM MonHoc";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1; // Nếu không có dữ liệu trong bảng, bắt đầu từ 1
    }

    // Cập nhật môn học
    private void updateMonHoc() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            int maMonHoc = (int) jTable1.getValueAt(selectedRow, 0);
            String tenMonHoc = txtTenMonHoc.getText();
            String soBuoiHocText = txtSoBuoiHoc.getText();
            String soGioHocMoiBuoiText = txtSoGioHocMoiBuoi.getText();

            if (tenMonHoc.isEmpty() || soBuoiHocText.isEmpty() || soGioHocMoiBuoiText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                return;
            }

            int soBuoiHoc, soGioHocMoiBuoi;
            try {
                soBuoiHoc = Integer.parseInt(soBuoiHocText);
                soGioHocMoiBuoi = Integer.parseInt(soGioHocMoiBuoiText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Số buổi học và số giờ học mỗi buổi phải là các số hợp lệ!");
                return;
            }

            String sql = "UPDATE MonHoc SET TenMonHoc = ?, SoBuoiHoc = ?, SoGioHocMoiBuoi = ? WHERE MaMonHoc = ?";
            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, tenMonHoc);
                ps.setInt(2, soBuoiHoc);
                ps.setInt(3, soGioHocMoiBuoi);
                ps.setInt(4, maMonHoc);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Môn học đã được cập nhật thành công!");
                    displayMonHoc();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật môn học.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học để cập nhật.");
        }
    }

    // Xóa môn học
    private void deleteMonHoc() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            int maMonHoc = (int) jTable1.getValueAt(selectedRow, 0);
            String sqlDelete = "DELETE FROM MonHoc WHERE MaMonHoc = ?";

            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement psDelete = conn.prepareStatement(sqlDelete)) {

                psDelete.setInt(1, maMonHoc);
                int rowsAffected = psDelete.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Môn học đã được xóa thành công!");
                    displayMonHoc();
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy môn học để xóa.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xóa môn học.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học để xóa.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextField txtMaMonHoc;
    private javax.swing.JTextField txtSoBuoiHoc;
    private javax.swing.JTextField txtSoGioHocMoiBuoi;
    private javax.swing.JTextField txtTenMonHoc;
    // End of variables declaration//GEN-END:variables
}

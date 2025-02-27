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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PanelBL extends javax.swing.JPanel {
    private boolean isEdit = false;

    /**
     * Creates new form PanelBL
     */
    public PanelBL() {
        initComponents();
//        BẢNG LƯƠNG  
//btnAddBangLuong.addActionListener(e -> addBangLuong());
//btnUpdateBangLuong.addActionListener(e -> updateBangLuong());
btnDeleteBangLuong.addActionListener(e -> deleteBangLuong());

// Thêm ListSelectionListener để tự động điền dữ liệu khi chọn dòng trong JTable
jTableBangLuong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Kiểm tra xem có dòng nào được chọn hay không
        int selectedRow = jTableBangLuong.getSelectedRow();

        // Nếu có dòng được chọn, điền dữ liệu vào các TextField
        if (selectedRow >= 0) {
            String maLuong = (String) jTableBangLuong.getValueAt(selectedRow, 0);
            String maChucVu = (String) jTableBangLuong.getValueAt(selectedRow, 1);
            String mucLuong = (String) jTableBangLuong.getValueAt(selectedRow, 2);

            // Cập nhật nội dung cho các JTextField
            txtMaLuong.setText(String.valueOf(maLuong));
            txtMaChucVu.setText(String.valueOf(maChucVu));
            txtMucLuong.setText(String.valueOf(mucLuong));
        } else {
            // Nếu không có dòng nào được chọn, làm trống các TextField
            txtMaLuong.setText("");
            txtMaChucVu.setText("");
            txtMucLuong.setText("");
        }
    }
});

displayBangLuong();

    }
    
    private void displayBangLuong() {
    DefaultTableModel model = (DefaultTableModel) jTableBangLuong.getModel();
    model.setRowCount(0);  // Clear old data from the table
    String sql = "SELECT * FROM Luong";

    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String maLuong = rs.getString("MaLuong");
            String maChucVu = rs.getString("MaChucVu");
            String mucLuong = rs.getString("MucLuong");

            model.addRow(new Object[]{maLuong, maChucVu, mucLuong});
        }
        if (jTableBangLuong.getRowCount() > 0) {
            jTableBangLuong.setRowSelectionInterval(0, 0);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        SetEdit(false);
}

    private void addBangLuong(String maChucVu, String mucLuong) {
        if (maChucVu.isEmpty() || mucLuong.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        String sql = "INSERT INTO Luong (MaChucVu, MucLuong) VALUES (?, ?)"; // Không truyền MaLuong nếu nó tự động tăng
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maChucVu);
            ps.setString(2, mucLuong);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Bảng lương đã được thêm thành công!");
                clearBangLuongFields();
                displayBangLuong(); // Cập nhật bảng sau khi thêm
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm bảng lương: " + e.getMessage());
        }
    }


// Method to get the next MaLuong
private int getNextMaLuong() {
    String sql = "SELECT MAX(MaLuong) FROM Luong";

    try (Connection conn = DatabaseConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        if (rs.next()) {
            return rs.getInt(1) + 1;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return 1; // If there's no data in the table, start from 1
}

private void updateBangLuong(String maLuong, String maChucVu, String mucLuong) {
    int selectedRow = jTableBangLuong.getSelectedRow();
    if (selectedRow >= 0) {
        
        String maChucVuText = txtMaChucVu.getText();
        String mucLuongText = txtMucLuong.getText();


        if (maChucVuText.isEmpty() || mucLuongText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        String sql = "UPDATE Luong SET MaChucVu = ?, MucLuong = ? WHERE MaLuong = ?";
        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maChucVu);
            ps.setString(2, mucLuong);
            ps.setString(3, maLuong);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Bảng lương đã được cập nhật thành công!");
                displayBangLuong(); // Update table after updating
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật bảng lương.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn bảng lương để cập nhật.");
    }
}

private void deleteBangLuong() {
    int selectedRow = jTableBangLuong.getSelectedRow();
        if (selectedRow >= 0) {
            String maLuong = (String) jTableBangLuong.getValueAt(selectedRow, 0);
            String sqlDelete = "DELETE FROM Luong WHERE MaLuong = ?";

            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bảng lương này?", 
                                                     "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement psDelete = conn.prepareStatement(sqlDelete)) {

                psDelete.setString(1, maLuong);
                int rowsAffected = psDelete.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Bảng lương đã được xóa thành công!");
                    displayBangLuong(); // Update table after deleting
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy bảng lương để xóa.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xóa bảng lương.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bảng lương để xóa.");
        }
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

        jp9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaChucVu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMucLuong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaLuong = new javax.swing.JTextField();
        btnCancleBangLuong = new javax.swing.JButton();
        btnSaveBangLuong = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBangLuong = new javax.swing.JTable();
        btnAddBangLuong = new javax.swing.JButton();
        btnUpdateBangLuong = new javax.swing.JButton();
        btnDeleteBangLuong = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255,0));

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
        jLabel2.setText("Thông Tin Bảng Lương");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
        jLabel5.setText("Mức Lương :");

        txtMaChucVu.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtMaChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaChucVuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Chức Vụ :");

        txtMucLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Lương :");

        txtMaLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtMaLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLuongActionPerformed(evt);
            }
        });

        btnCancleBangLuong.setBackground(new java.awt.Color(0, 51, 153));
        btnCancleBangLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCancleBangLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnCancleBangLuong.setText("Hủy");
        btnCancleBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleBangLuongActionPerformed(evt);
            }
        });

        btnSaveBangLuong.setBackground(new java.awt.Color(0, 51, 153));
        btnSaveBangLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSaveBangLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveBangLuong.setText("Lưu");
        btnSaveBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBangLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(txtMucLuong)
                            .addComponent(txtMaLuong)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 409, Short.MAX_VALUE)
                        .addComponent(btnSaveBangLuong)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancleBangLuong)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMucLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancleBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTableBangLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableBangLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lương", "Mã chức vụ", "Mức lương"
            }
        ));
        jScrollPane1.setViewportView(jTableBangLuong);

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

        btnAddBangLuong.setBackground(new java.awt.Color(0, 51, 153));
        btnAddBangLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAddBangLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBangLuong.setText("Thêm");
        btnAddBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBangLuongActionPerformed(evt);
            }
        });

        btnUpdateBangLuong.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdateBangLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnUpdateBangLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBangLuong.setText("Sửa");
        btnUpdateBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBangLuongActionPerformed(evt);
            }
        });

        btnDeleteBangLuong.setBackground(new java.awt.Color(0, 51, 153));
        btnDeleteBangLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnDeleteBangLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBangLuong.setText("Xóa");
        btnDeleteBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBangLuongActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddBangLuong)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateBangLuong)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteBangLuong)
                .addGap(352, 352, 352))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jp9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jp9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChucVuActionPerformed

    private void btnUpdateBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBangLuongActionPerformed
        int selectedRow = jTableBangLuong.getSelectedRow();
        if(selectedRow >= 0) {
            String maLuong = jTableBangLuong.getValueAt(selectedRow, 0).toString();  // Mã chương trình học
            String maChucVu = jTableBangLuong.getValueAt(selectedRow, 1).toString();     // Tên chương trình học
            String mucLuong = jTableBangLuong.getValueAt(selectedRow, 2).toString();  // Thời gian hoàn thành

            // Điền dữ liệu vào các TextField
            txtMaLuong.setText(maLuong);  // Điền mã chương trình học vào TextField
            txtMaChucVu.setText(maChucVu);   // Điền tên chương trình học vào TextField
            txtMucLuong.setText(mucLuong);  // Điền thời gian hoàn thành vào TextField
            
            SetEdit(true);
            isEdit = true;
            txtMaChucVu.setEnabled(false);
            txtMaLuong.setEnabled(false);
        }
        else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn chương trình học để sửa!");
        }
    }//GEN-LAST:event_btnUpdateBangLuongActionPerformed

    private void btnDeleteBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBangLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteBangLuongActionPerformed

    private void txtMaLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLuongActionPerformed

    private void jp9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jp9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jp9AncestorAdded

    private void btnAddBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBangLuongActionPerformed
        txtMaLuong.setText("");
        txtMaChucVu.setText("");
        txtMucLuong.setText("");
        SetEdit(true);
        isEdit = false;
    }//GEN-LAST:event_btnAddBangLuongActionPerformed

    private void btnCancleBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleBangLuongActionPerformed
        clearBangLuongFields();
        SetEdit(false);
    }//GEN-LAST:event_btnCancleBangLuongActionPerformed

    private void btnSaveBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBangLuongActionPerformed
        String maChucVuText = txtMaChucVu.getText();
        String mucLuongText = txtMucLuong.getText();

        if (maChucVuText.isEmpty() || mucLuongText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        if (isEdit) {
            updateBangLuong(txtMaLuong.getText(), maChucVuText, mucLuongText); // Nếu đang sửa
        } else {
            addBangLuong(maChucVuText, mucLuongText); // Nếu đang thêm mới
        }
    }//GEN-LAST:event_btnSaveBangLuongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBangLuong;
    private javax.swing.JButton btnCancleBangLuong;
    private javax.swing.JButton btnDeleteBangLuong;
    private javax.swing.JButton btnSaveBangLuong;
    private javax.swing.JButton btnUpdateBangLuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableBangLuong;
    private javax.swing.JPanel jp9;
    private javax.swing.JTextField txtMaChucVu;
    private javax.swing.JTextField txtMaLuong;
    private javax.swing.JTextField txtMucLuong;
    // End of variables declaration//GEN-END:variables

    private void clearBangLuongFields() {
            jTableBangLuong.setRowSelectionInterval(0, 0);
    }

    private void SetEdit(boolean edit) {
        isEdit = edit;  
        
        txtMaLuong.setEditable(!edit);
        txtMaChucVu.setEditable(!edit);
        txtMucLuong.setEditable(edit);
        
        java.awt.Color enableColor = new java.awt.Color(0, 51, 153);
        java.awt.Color disableColor = new java.awt.Color(128, 128, 128);
        
        if(edit) {
            btnAddBangLuong.setBackground(disableColor);
            btnUpdateBangLuong.setBackground(disableColor);
            btnDeleteBangLuong.setBackground(disableColor);
            
            btnSaveBangLuong.setBackground(enableColor);
            btnCancleBangLuong.setBackground(enableColor);
        }
        else {
            btnAddBangLuong.setBackground(enableColor);
            btnUpdateBangLuong.setBackground(enableColor);
            btnDeleteBangLuong.setBackground(enableColor);
            
            btnSaveBangLuong.setBackground(disableColor);
            btnCancleBangLuong.setBackground(disableColor);
        }
    }
}

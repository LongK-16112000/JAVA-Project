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
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PanelPB extends javax.swing.JPanel {
    private boolean isEdit = false;

    /**
     * Creates new form PanelPB
     */
    public PanelPB() {
        initComponents();
//        PHÒNG BAN  
//        btnCanclePhongBan.addActionListener(e -> addPhongBan());
//        btnUpdatePhongBan.addActionListener(e -> updatePhongBan());
        btnDeletePhongBan.addActionListener(e -> deletePhongBan());

        // Thêm ListSelectionListener để tự động điền dữ liệu khi chọn dòng trong JTable
        jTablePhongBan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Kiểm tra xem có dòng nào được chọn hay không
                int selectedRow = jTablePhongBan.getSelectedRow();

                // Nếu có dòng được chọn, điền dữ liệu vào các TextField
                if (selectedRow >= 0) {
                    String maPhongBan = (String) jTablePhongBan.getValueAt(selectedRow, 0);
                    String tenPhongBan = (String) jTablePhongBan.getValueAt(selectedRow, 1);
                    String maTruongPhong = (String) jTablePhongBan.getValueAt(selectedRow, 2);
                    String maPhoPhong = (String) jTablePhongBan.getValueAt(selectedRow, 3);

                    // Cập nhật nội dung cho các JTextField
                    txtMaPhongBan.setText(String.valueOf(maPhongBan));
                    txtTenPhongBan.setText(tenPhongBan);
                    txtMaTruongPhong.setText(String.valueOf(maTruongPhong));
                    txtMaPhoPhong.setText(String.valueOf(maPhoPhong));
                } else {
                    // Nếu không có dòng nào được chọn, làm trống các TextField
                    txtMaPhongBan.setText("");
                    txtTenPhongBan.setText("");
                    txtMaTruongPhong.setText("");
                    txtMaPhoPhong.setText("");
                }
            }
        });

        displayPhongBan();
        
    }
    
    private void displayPhongBan() {
    DefaultTableModel model = (DefaultTableModel) jTablePhongBan.getModel();
    model.setRowCount(0);  // Clear old data from the table
    String sql = "SELECT * FROM PhongBan";

    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String maPhongBan = rs.getString("MaPhongBan");
            String tenPhongBan = rs.getString("TenPhongBan");
            String maTruongPhong = rs.getString("MaTruongPhong");
            String maPhoPhong = rs.getString("MaPhoPhong");

            model.addRow(new Object[]{maPhongBan, tenPhongBan, maTruongPhong, maPhoPhong});
        }
        if (jTablePhongBan.getRowCount() > 0) {
            jTablePhongBan.setRowSelectionInterval(0, 0);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        SetEdit(false);
}
    
    private void addPhongBan(String maPhongBan, String tenPhongBan, String maTruongPhong, String maPhoPhong) {
        String maPhongBanText = txtMaPhongBan.getText();
        String tenPhongBanText = txtTenPhongBan.getText();
        String maTruongPhongText = txtMaTruongPhong.getText();
        String maPhoPhongText = txtMaPhoPhong.getText();

        if (maPhongBanText.isEmpty() ||  tenPhongBanText.isEmpty() || maTruongPhongText.isEmpty() || maPhoPhongText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        String sql = "INSERT INTO PhongBan (MaPhongBan, TenPhongBan, MaTruongPhong, MaPhoPhong) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maPhongBan);
            ps.setString(2, tenPhongBan);
            ps.setString(3, maTruongPhong);
            ps.setString(4, maPhoPhong);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Phòng ban đã được thêm thành công!");
                clearPhongBanFields();
                displayPhongBan(); // Update table after adding
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm phòng ban: " + e.getMessage());
        }
    }

private String generateMaPhongBan() {
    String year = String.valueOf(java.time.Year.now().getValue()); // Lấy năm hiện tại (VD: 2025)
    String prefix = "PB" + year; // Tiền tố cho mã phòng ban (VD: PB2025)
    String sql = "SELECT MaPhongBan FROM PhongBan WHERE MaPhongBan LIKE ? ORDER BY MaPhongBan DESC LIMIT 1";
    
    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, prefix + "%"); // Lọc các mã bắt đầu bằng PB2025
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String lastMaPhongBan = rs.getString("MaPhongBan"); // Lấy mã phòng ban mới nhất
            int lastNumber = Integer.parseInt(lastMaPhongBan.substring(6)); // Cắt số thứ tự (VD: "PB2025003" -> 003)
            return prefix + String.format("%03d", lastNumber + 1); // Tăng số thứ tự lên 1 (VD: 004)
        } else {
            return prefix + "001"; // Nếu chưa có, bắt đầu từ 001
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return prefix + "001"; // Nếu có lỗi, trả về giá trị mặc định
    }
}


private void updatePhongBan(String maPhongBan, String tenPhongBan, String maTruongPhong, String maPhoPhong) {
    int selectedRow = jTablePhongBan.getSelectedRow();
    if (selectedRow >= 0) {
        // Lấy mã phòng ban từ bảng thay vì từ ô nhập liệu
        String maPhongBanText = (String) jTablePhongBan.getValueAt(selectedRow, 0); // Cột 0 chứa MaPhongBan
        String maTruongPhongText = txtMaTruongPhong.getText();
        String maPhoPhongText = txtMaPhoPhong.getText();

        if (tenPhongBan.isEmpty() || maTruongPhongText.isEmpty() || maPhoPhongText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        // Kiểm tra MaTruongPhong & MaPhoPhong có tồn tại trong bảng nhanvien không
        if (!kiemTraNhanVienTonTai(maTruongPhongText) || !kiemTraNhanVienTonTai(maPhoPhongText)) {
            JOptionPane.showMessageDialog(null, "Mã trưởng phòng hoặc mã phó phòng không tồn tại!");
            return;
        }

        String sql = "UPDATE PhongBan SET TenPhongBan = ?, MaTruongPhong = ?, MaPhoPhong = ? WHERE MaPhongBan = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenPhongBan);
            ps.setString(2, maTruongPhong);
            ps.setString(3, maPhoPhong);
            ps.setString(4, maPhongBanText);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Phòng ban đã được cập nhật thành công!");
                displayPhongBan(); // Cập nhật lại bảng sau khi sửa
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng ban để cập nhật!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật phòng ban: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng ban để cập nhật.");
    }
}

private boolean kiemTraNhanVienTonTai(String maNhanVien) {
    String sql = "SELECT COUNT(*) FROM nhanvien WHERE MaNhanVien = ?";
    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maNhanVien);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


private void deletePhongBan() {
    int selectedRow = jTablePhongBan.getSelectedRow();
    if (selectedRow >= 0) {
        String maPhongBan = (String) jTablePhongBan.getValueAt(selectedRow, 0);
        String sqlDelete = "DELETE FROM PhongBan WHERE MaPhongBan = ?";
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phòng ban này?", 
                                                     "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION) {

            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement psDelete = conn.prepareStatement(sqlDelete)) {

                psDelete.setString(1, maPhongBan);
                int rowsAffected = psDelete.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Phòng ban đã được xóa thành công!");
                    displayPhongBan(); // Update table after deleting
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy phòng ban để xóa.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xóa phòng ban.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng ban để xóa.");
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
        jLabel4 = new javax.swing.JLabel();
        txtTenPhongBan = new javax.swing.JTextField();
        txtMaPhoPhong = new javax.swing.JTextField();
        btnCanclePhongBan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaTruongPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaPhongBan = new javax.swing.JTextField();
        btnSavePhongBan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePhongBan = new javax.swing.JTable();
        btnAddPhongBan = new javax.swing.JButton();
        btnUpdatePhongBan = new javax.swing.JButton();
        btnDeletePhongBan = new javax.swing.JButton();
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
        jLabel2.setText("Thông Tin Phòng Ban");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
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
        jLabel5.setText("Mã Trưởng Phòng :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã Phó Phòng :");

        txtTenPhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTenPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenPhongBanActionPerformed(evt);
            }
        });

        txtMaPhoPhong.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtMaPhoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhoPhongActionPerformed(evt);
            }
        });

        btnCanclePhongBan.setBackground(new java.awt.Color(0, 51, 153));
        btnCanclePhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCanclePhongBan.setForeground(new java.awt.Color(255, 255, 255));
        btnCanclePhongBan.setText("Hủy");
        btnCanclePhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanclePhongBanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Phòng Ban :");

        txtMaTruongPhong.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Phòng Ban :");

        txtMaPhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtMaPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongBanActionPerformed(evt);
            }
        });

        btnSavePhongBan.setBackground(new java.awt.Color(0, 51, 153));
        btnSavePhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSavePhongBan.setForeground(new java.awt.Color(255, 255, 255));
        btnSavePhongBan.setText("Lưu");
        btnSavePhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePhongBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSavePhongBan)
                        .addGap(18, 18, 18)
                        .addComponent(btnCanclePhongBan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenPhongBan, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(txtMaPhoPhong)
                            .addComponent(txtMaTruongPhong)
                            .addComponent(txtMaPhongBan))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaTruongPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCanclePhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSavePhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTablePhongBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTablePhongBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng ban", "Tên phòng ban", "Mã trưởng phòng", "Mã phó phòng "
            }
        ));
        jScrollPane1.setViewportView(jTablePhongBan);

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

        btnAddPhongBan.setBackground(new java.awt.Color(0, 51, 153));
        btnAddPhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAddPhongBan.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPhongBan.setText("Thêm");
        btnAddPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhongBanActionPerformed(evt);
            }
        });

        btnUpdatePhongBan.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdatePhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnUpdatePhongBan.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePhongBan.setText("Sửa");
        btnUpdatePhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePhongBanActionPerformed(evt);
            }
        });

        btnDeletePhongBan.setBackground(new java.awt.Color(0, 51, 153));
        btnDeletePhongBan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnDeletePhongBan.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePhongBan.setText("Xóa");
        btnDeletePhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePhongBanActionPerformed(evt);
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
                .addComponent(btnAddPhongBan)
                .addGap(18, 18, 18)
                .addComponent(btnUpdatePhongBan)
                .addGap(18, 18, 18)
                .addComponent(btnDeletePhongBan)
                .addGap(348, 348, 348))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtTenPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenPhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenPhongBanActionPerformed

    private void txtMaPhoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhoPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhoPhongActionPerformed

    private void btnCanclePhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanclePhongBanActionPerformed
        clearPhongBanFields();
        SetEdit(false);
    }//GEN-LAST:event_btnCanclePhongBanActionPerformed

    private void btnUpdatePhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePhongBanActionPerformed
        int selectedRow = jTablePhongBan.getSelectedRow();
        
        if(selectedRow >= 0) {
            String maPhongBan = (String) jTablePhongBan.getValueAt(selectedRow, 0);
            String tenPhongBan = jTablePhongBan.getValueAt(selectedRow, 1).toString();
            String maTruongPhong = (String) jTablePhongBan.getValueAt(selectedRow, 2);
            String maPhoPhong = (String) jTablePhongBan.getValueAt(selectedRow, 3);
            
            txtMaPhongBan.setText(String.valueOf(maPhongBan));
            txtTenPhongBan.setText(tenPhongBan);
            txtMaTruongPhong.setText(String.valueOf(maTruongPhong));
            txtMaPhoPhong.setText(String.valueOf(maPhoPhong));
            
            SetEdit(true);
            isEdit = true;
            txtMaPhongBan.setEnabled(false);
            txtMaPhoPhong.setEnabled(false);
            txtMaTruongPhong.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng ban để sửa!");
        }
    }//GEN-LAST:event_btnUpdatePhongBanActionPerformed

    private void btnDeletePhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeletePhongBanActionPerformed

    private void txtMaPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongBanActionPerformed

    private void jp9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jp9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jp9AncestorAdded

    private void btnSavePhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePhongBanActionPerformed
        String maPhongBanText = generateMaPhongBan(); // Tạo mã phòng ban tự động
        String tenPhongBanText = txtTenPhongBan.getText();
        String maTruongPhongText = txtMaTruongPhong.getText();
        String maPhoPhongText = txtMaPhoPhong.getText();

        if (tenPhongBanText.isEmpty() || maTruongPhongText.isEmpty() || maPhoPhongText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        if (isEdit) {
            updatePhongBan(maPhongBanText, tenPhongBanText, maTruongPhongText, maPhoPhongText);
        } else {
            addPhongBan(maPhongBanText, tenPhongBanText, maTruongPhongText, maPhoPhongText);
        }
    }//GEN-LAST:event_btnSavePhongBanActionPerformed

    private void btnAddPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhongBanActionPerformed
        txtMaPhongBan.setText("");
        txtTenPhongBan.setText("");
        txtMaTruongPhong.setText("");
        txtMaPhoPhong.setText("");
        SetEdit(true);
        isEdit = false;
    }//GEN-LAST:event_btnAddPhongBanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPhongBan;
    private javax.swing.JButton btnCanclePhongBan;
    private javax.swing.JButton btnDeletePhongBan;
    private javax.swing.JButton btnSavePhongBan;
    private javax.swing.JButton btnUpdatePhongBan;
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
    private javax.swing.JTable jTablePhongBan;
    private javax.swing.JPanel jp9;
    private javax.swing.JTextField txtMaPhoPhong;
    private javax.swing.JTextField txtMaPhongBan;
    private javax.swing.JTextField txtMaTruongPhong;
    private javax.swing.JTextField txtTenPhongBan;
    // End of variables declaration//GEN-END:variables

    private void clearPhongBanFields() {
        if (jTablePhongBan.getRowCount() > 0) {
            jTablePhongBan.setRowSelectionInterval(0, 0);
        }
    }
    
    private void SetEdit(boolean edit) {
        isEdit = edit;
        
        txtTenPhongBan.setEditable(edit);
        txtMaTruongPhong.setEditable(edit);
        txtMaPhoPhong.setEditable(edit);
        txtMaPhongBan.setText(generateMaPhongBan());
        txtMaPhongBan.setEditable(false);
        
        java.awt.Color enableColor = new java.awt.Color(0, 51, 153);
        java.awt.Color disableColor = new java.awt.Color(128, 128, 128);
        
        if(edit) {
            btnAddPhongBan.setBackground(disableColor);
            btnUpdatePhongBan.setBackground(disableColor);
            btnDeletePhongBan.setBackground(disableColor);
            
            btnSavePhongBan.setBackground(enableColor);
            btnCanclePhongBan.setBackground(enableColor);
        }
        else {
            btnAddPhongBan.setBackground(enableColor);
            btnUpdatePhongBan.setBackground(enableColor);
            btnDeletePhongBan.setBackground(enableColor);
            
            btnSavePhongBan.setBackground(disableColor);
            btnCanclePhongBan.setBackground(disableColor);
        }
    }
}

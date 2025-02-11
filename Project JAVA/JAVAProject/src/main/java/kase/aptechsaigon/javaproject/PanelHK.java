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
 * @author Truc
 */
public class PanelHK extends javax.swing.JPanel {

    /**
     * Creates new form PanelHk
     */
    public PanelHK() {
        initComponents();
        btnAdd.addActionListener(e -> addHocKy());
        btnUpdate.addActionListener(e -> updateHocKy());
        btnDelete.addActionListener(e -> deleteHocKy());
        // Thêm ListSelectionListener để tự động điền dữ liệu khi chọn dòng trong JTable cho Học kỳ
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
        // Kiểm tra xem có dòng nào được chọn hay không
        int selectedRow = jTable1.getSelectedRow();

        // Nếu có dòng được chọn, điền dữ liệu vào các TextField
        if (selectedRow >= 0) {

            // Lấy giá trị từ các cột trong dòng được chọn
            int maChungChi = (int) jTable1.getValueAt(selectedRow, 0);  
            int maChuongTrinhHoc = (int) jTable1.getValueAt(selectedRow, 1);  // Cột 1 là Mã Chương Trình Học
            String tenHocKy = (String) jTable1.getValueAt(selectedRow, 2);  // Cột 2 là Tên Học Kỳ
            int soMonHoc = (int) jTable1.getValueAt(selectedRow, 3);  // Cột 3 là Số Môn Học
            String tenChungChi = (String) jTable1.getValueAt(selectedRow, 4);  // Cột 4 là Tên Chứng Chỉ
            int thoiGianHoanThanh = (int) jTable1.getValueAt(selectedRow, 5);  // Cột 5 là Thời Gian Hoàn Thành
            int soThuTuChungChi = (int) jTable1.getValueAt(selectedRow, 6);  // Cột 6 là Số Thứ Tự Chứng Chỉ

            // Cập nhật nội dung cho các JTextField
            txtMaChungChi.setText(String.valueOf(maChungChi));
            txtMaChuongtrinh.setText(String.valueOf(maChuongTrinhHoc));
            txtTenHocKy.setText(tenHocKy);  // Hiển thị tên học kỳ
            txtSoMonHoc.setText(String.valueOf(soMonHoc));  // Hiển thị số môn học
            txtTenChungChi.setText(tenChungChi);  // Hiển thị tên chứng chỉ
            txtThoiGianHoanThanh.setText(String.valueOf(thoiGianHoanThanh));  // Hiển thị thời gian hoàn thành
            txtSoThuTuChungChi.setText(String.valueOf(soThuTuChungChi));  // Hiển thị số thứ tự chứng chỉ
        } else {
            // Nếu không có dòng nào được chọn, làm trống các TextField
            txtMaChungChi.setText("");
            txtMaChuongtrinh.setText("");
            txtTenHocKy.setText("");
            txtSoMonHoc.setText("");
            txtTenChungChi.setText("");
            txtThoiGianHoanThanh.setText("");
            txtSoThuTuChungChi.setText("");
        }
    }
});

        displayHocKy();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenHocKy = new javax.swing.JTextField();
        txtSoMonHoc = new javax.swing.JTextField();
        txtTenChungChi = new javax.swing.JTextField();
        txtThoiGianHoanThanh = new javax.swing.JTextField();
        txtSoThuTuChungChi = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaChungChi = new javax.swing.JTextField();
        txtMaChuongtrinh = new javax.swing.JTextField();
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
        jLabel2.setText("Thông Tin Học Kỳ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jPanel3.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1460, 400));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Học kì", "Mã Chương Trình", "Tên Học Kỳ", "Số Môn Học", "Tên Chứng Chỉ", "STT Chứng Chỉ", "Thời Gian Hoàn Thành"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255,40));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số Môn Học :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Học Kỳ :");

        txtTenHocKy.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTenHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHocKyActionPerformed(evt);
            }
        });

        txtSoMonHoc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtSoMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoMonHocActionPerformed(evt);
            }
        });

        txtTenChungChi.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTenChungChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenChungChiActionPerformed(evt);
            }
        });

        txtThoiGianHoanThanh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        txtSoThuTuChungChi.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

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

        btnAdd.setBackground(new java.awt.Color(0, 51, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên Chứng chỉ :");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Thời Gian Hoàn Thành :");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("STT Chứng Chỉ :");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Chứng Chỉ :");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã Chương Trình :");

        txtMaChungChi.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        txtMaChuongtrinh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaChungChi)
                                .addComponent(txtMaChuongtrinh, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                            .addComponent(txtTenHocKy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSoThuTuChungChi, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(txtSoMonHoc)
                                .addComponent(txtTenChungChi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(19, 19, 19)))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaChungChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaChuongtrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenChungChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoThuTuChungChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jp9Layout = new javax.swing.GroupLayout(jp9);
        jp9.setLayout(jp9Layout);
        jp9Layout.setHorizontalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(437, 437, 437))
        );
        jp9Layout.setVerticalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp9Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        add(jp9, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHocKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHocKyActionPerformed

    private void txtSoMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoMonHocActionPerformed

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

    private void txtTenChungChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenChungChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenChungChiActionPerformed
// Hiển thị dữ liệu học kỳ lên JTable
private void displayHocKy() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);  // Xóa dữ liệu cũ trong bảng
    String sql = "SELECT * FROM HocKy";

    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int maHocKy = rs.getInt("MaHocKy");
            int maChuongTrinhHoc = rs.getInt("MaChuongTrinhHoc");
            String tenHocKy = rs.getString("TenHocKy");
            int soMonHoc = rs.getInt("SoMonHoc");
            String tenChungChi = rs.getString("TenChungChi");
            int thoiGianHoanThanh = rs.getInt("ThoiGianHoanThanh");
            int soThuTuChungChi = rs.getInt("SoThuTuChungChi");

            model.addRow(new Object[]{maHocKy, maChuongTrinhHoc, tenHocKy, soMonHoc, tenChungChi, thoiGianHoanThanh, soThuTuChungChi});
        }
        if(jTable1.getRowCount()>0){
                jTable1.setRowSelectionInterval(0, 0);
            }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Thêm học kỳ
private void addHocKy() {
    String tenHocKy = txtTenHocKy.getText();
    String soMonHocText = txtSoMonHoc.getText();
    String tenChungChi = txtTenChungChi.getText();
    String thoiGianHoanThanhText = txtThoiGianHoanThanh.getText();
    String soThuTuChungChiText = txtSoThuTuChungChi.getText();

    if (tenHocKy.isEmpty() || soMonHocText.isEmpty() || 
        tenChungChi.isEmpty() || thoiGianHoanThanhText.isEmpty() || soThuTuChungChiText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
        return;
    }

    int  soMonHoc, thoiGianHoanThanh, soThuTuChungChi;
    try {
       
        soMonHoc = Integer.parseInt(soMonHocText);
        thoiGianHoanThanh = Integer.parseInt(thoiGianHoanThanhText);
        soThuTuChungChi = Integer.parseInt(soThuTuChungChiText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Các trường nhập phải là các số hợp lệ!");
        return;
    }

    int maHocKyMoi = getNextMaHocKy();

    String sql = "INSERT INTO HocKy (MaHocKy, TenHocKy, SoMonHoc, TenChungChi, ThoiGianHoanThanh, SoThuTuChungChi) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, maHocKyMoi);
     
        ps.setString(2, tenHocKy);
        ps.setInt(3, soMonHoc);
        ps.setString(4, tenChungChi);
        ps.setInt(5, thoiGianHoanThanh);
        ps.setInt(6, soThuTuChungChi);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Học kỳ đã được thêm thành công!");
            clearHocKyFields();
            displayHocKy(); // Cập nhật lại bảng sau khi thêm
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm học kỳ.");
    }
}

// Hàm để lấy mã học kỳ tiếp theo
private int getNextMaHocKy() {
    String sql = "SELECT MAX(MaHocKy) FROM HocKy";

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

// Cập nhật học kỳ
private void updateHocKy() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow >= 0) {
        int maHocKy = (int) jTable1.getValueAt(selectedRow, 0);
        String tenHocKy = txtTenHocKy.getText();
        String soMonHocText = txtSoMonHoc.getText();
        String tenChungChi = txtTenChungChi.getText();
        String thoiGianHoanThanhText = txtThoiGianHoanThanh.getText();
        String soThuTuChungChiText = txtSoThuTuChungChi.getText();

        if (tenHocKy.isEmpty() || soMonHocText.isEmpty() || 
            tenChungChi.isEmpty() || thoiGianHoanThanhText.isEmpty() || soThuTuChungChiText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        int maChuongTrinhHoc, soMonHoc, thoiGianHoanThanh, soThuTuChungChi;
        try {
            soMonHoc = Integer.parseInt(soMonHocText);
            thoiGianHoanThanh = Integer.parseInt(thoiGianHoanThanhText);
            soThuTuChungChi = Integer.parseInt(soThuTuChungChiText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Các trường nhập phải là các số hợp lệ!");
            return;
        }

        String sql = "UPDATE HocKy SET TenHocKy = ?, MaChuongTrinhHoc = ?, SoMonHoc = ?, TenChungChi = ?, ThoiGianHoanThanh = ?, SoThuTuChungChi = ? WHERE MaHocKy = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenHocKy);
            ps.setInt(2, soMonHoc);
            ps.setString(3, tenChungChi);
            ps.setInt(4, thoiGianHoanThanh);
            ps.setInt(5, soThuTuChungChi);
            ps.setInt(6, maHocKy);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Học kỳ đã được cập nhật thành công!");
                displayHocKy();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật học kỳ.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn học kỳ để cập nhật.");
    }
}

// Xóa học kỳ
private void deleteHocKy() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow >= 0) {
        int maHocKy = (int) jTable1.getValueAt(selectedRow, 0);
        String sqlDelete = "DELETE FROM HocKy WHERE MaHocKy = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement psDelete = conn.prepareStatement(sqlDelete)) {

            psDelete.setInt(1, maHocKy);
            int rowsAffected = psDelete.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Học kỳ đã được xóa thành công!");
                displayHocKy();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy học kỳ để xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xóa học kỳ.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn học kỳ để xóa.");
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField txtMaChungChi;
    private javax.swing.JTextField txtMaChuongtrinh;
    private javax.swing.JTextField txtSoMonHoc;
    private javax.swing.JTextField txtSoThuTuChungChi;
    private javax.swing.JTextField txtTenChungChi;
    private javax.swing.JTextField txtTenHocKy;
    private javax.swing.JTextField txtThoiGianHoanThanh;
    // End of variables declaration//GEN-END:variables

    private void clearHocKyFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

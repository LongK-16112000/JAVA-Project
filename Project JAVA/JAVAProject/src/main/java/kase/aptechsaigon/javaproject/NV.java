/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NV {
    private String maNhanVien;  
    private String hoTen; 
    private Date ngaySinh; 
    private String soCMT;
    private String diaChi;
    private String Email;
    private String dienThoai;
    private Date ngayVaoLam;
    private String matKhau;
    private String maChucVu;
    private String maPhongBan;

    // Constructor
    public NV(String maNhanVien, String hoTen, Date ngaySinh, String soCMT, String diaChi, String Email, String dienThoai, Date ngayVaoLam, String matKhau, String maChucVu, String maPhongBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMT = soCMT;
        this.diaChi = diaChi;
        this.Email = Email;
        this.dienThoai = dienThoai;
        this.ngayVaoLam = ngayVaoLam;
        this.matKhau = matKhau;
        this.maChucVu = maChucVu;
        this.maPhongBan = maPhongBan;
    }

    // Getter và Setter
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoten(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getsoCMT() {
        return soCMT;
    }
    
    public void setsoCMT(String soCMT) {
        this.soCMT = soCMT;
    }
    
    public String getdiaChi() {
        return diaChi;
    }
    
    public void setdiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getdienThoai() {
        return dienThoai;
    }
    
    public void setdienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public Date getngayVaoLam() {
        return ngayVaoLam;
    }
    
    public void setngayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    
    public String getmatKhau() {
        return matKhau;
    }
    
    public void setmatKhau(String ngayVaoLam) {
        this.matKhau = matKhau;
    }
    
    public String getmaChucVu() {
        return maChucVu;
    }
    
    public void setmaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }
    
    public String getmaPhongBan() {
        return maChucVu;
    }
    
    public void setmaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "MaNhanVien: " + maNhanVien + ", HoTen: " + hoTen + ", ngaySinh: " + ngaySinh + ", soCMT: " + soCMT + ", diaChi: " + diaChi + ", Email: " + Email + ", dienThoai: " + dienThoai + ", ngayVaoLam: " + ngayVaoLam + ", matKhau: " + matKhau + ", maChucVu: " + maChucVu + ", maPhongBan: " + maPhongBan;
    }
}

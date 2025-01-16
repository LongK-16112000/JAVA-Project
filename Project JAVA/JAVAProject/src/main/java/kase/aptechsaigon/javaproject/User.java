package kase.aptechsaigon.javaproject;

/**

 */
public class User {
    private String hoTen;     // Tên đầy đủ của người dùng
    private String matKhau;   // Mật khẩu của người dùng

    // Constructor để khởi tạo đối tượng User
    public User(String hoTen, String matKhau) {
        this.hoTen = hoTen;
        this.matKhau = matKhau;
    }

    // Getter để lấy tên đầy đủ
    public String getHoTen() {
        return hoTen;
    }

    // Getter để lấy mật khẩu
    public String getMatKhau() {
        return matKhau;
    }

    // Phương thức toString để hiển thị thông tin người dùng
    @Override
    public String toString() {
        return "HoTen: " + hoTen + ", MatKhau: " + matKhau;
    }
}

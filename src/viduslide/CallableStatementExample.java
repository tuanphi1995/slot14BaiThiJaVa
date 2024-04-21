package viduslide;

import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        // Đường dẫn kết nối đến cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/slidethuyettrinh";
        String username = "root";
        String password = "phi";  // Sử dụng mật khẩu thực tế của người dùng 'root'
        String sql = "{call fetch_users()}";  // Gọi stored procedure mới

        try (Connection conn = DriverManager.getConnection(url, username, password);
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {

            // Đọc và in kết quả truy vấn
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

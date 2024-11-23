package com.example.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        // Thông tin kết nối với MySQL
        String url = "jdbc:mysql://127.0.0.1:3306/centermanagement"; // Địa chỉ máy chủ và tên cơ sở dữ liệu
        String username = "root"; // Tên người dùng
        String password = ""; // Mật khẩu của bạn

        Connection connection = null;

        try {
            // Đăng ký driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Kết nối tới cơ sở dữ liệu
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối tới cơ sở dữ liệu thành công!");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi kết nối tới cơ sở dữ liệu: " + e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {
        // Kết nối tới cơ sở dữ liệu
        getConnection();
    }
}

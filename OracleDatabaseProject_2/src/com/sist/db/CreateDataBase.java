package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDataBase {
    private Connection conn;
    private PreparedStatement ps;
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    public CreateDataBase() {
        try {
            // 1. JDBC 드라이버 이름 오타 수정
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            // 2. 데이터베이스 URL 오타 수정 및 연결 정보 사용
            this.conn = DriverManager.getConnection(this.URL, "hr", "happy");
        } catch (SQLException e) {
            // 어떤 문제인지 알 수 있도록 예외 출력
            e.printStackTrace();
        }
        return this.conn;
    }

    public void disConnection(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
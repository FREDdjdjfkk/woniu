package Demo;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args)  {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/my_product?useSSL=false&serverTimezone=UTC&allowPublicKeyRetieval=true";
            String user = "root";
            String password = "239611";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
            String sql = "select id,name,location from employee ";
            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1,2);
            ResultSet rs= stmt.executeQuery();
            System.out.println(rs);

            System.out.println("查询结果：");
            while (rs.next()) {
                int id = rs.getInt("id"); // 获取 id 列的值
                String name = rs.getString("name"); // 获取 name 列的值
                String location = rs.getString("location"); // 获取 position 列的值

                System.out.println("ID: " + id + ", 姓名: " + name + ", 家庭住址: " + location);
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }

}

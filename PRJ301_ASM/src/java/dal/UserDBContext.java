/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author dv15312
 */
import dal.DBContext;
import model.User;
import java.sql.*;
import java.util.ArrayList;

public class UserDBContext {

    DBContext db = new DBContext() {
        @Override
        public ArrayList list() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Object get(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void insert(Object model) {
        }

        @Override
        public void update(Object model) {
        }

        @Override
        public void delete(Object model) {
        }
    };

    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection c = db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setFullName(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setDepartmentId(rs.getInt("department_id"));
                int m = rs.getInt("manager_id");
                if (rs.wasNull()) {
                    u.setManagerId(null);
                } else {
                    u.setManagerId(m);
                }
                return u;
            }
        }
        return null;
    }

    public boolean checkPassword(String username, String passwordPlain) throws SQLException {
        String sql = "SELECT password_hash FROM users WHERE username = ?";
        try (Connection c = db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hash = rs.getString("password_hash");
                // if using bcrypt:
                // return BCrypt.checkpw(passwordPlain, hash);
                // For demo (INSECURE) compare direct:
                return hash.equals(passwordPlain);
            }
        }
        return false;
    }
}

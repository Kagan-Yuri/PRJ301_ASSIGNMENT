/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author dv15312
 */
// RequestDAO.java
import dal.DBContext;
import model.Request;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDBContext extends DBContext {
    
    public void create(Request r) throws SQLException {
        String sql = "INSERT INTO requests (title, from_date, to_date, reason, created_by) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getTitle());
            ps.setDate(2, r.getFromDate());
            ps.setDate(3, r.getToDate());
            ps.setString(4, r.getReason());
            ps.setInt(5, r.getCreatedBy());
            ps.executeUpdate();
        }
    }

    public List<Request> listByUser(int userId) throws SQLException {
        String sql = "SELECT * FROM requests WHERE created_by = ? ORDER BY created_at DESC";
        List<Request> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request r = map(rs);
                list.add(r);
            }
        }
        return list;
    }

    public List<Request> listBySubordinates(int managerId) throws SQLException {
        // select requests where created_by in (select id from users where manager_id = managerId)
        String sql = "SELECT r.* FROM requests r JOIN users u ON r.created_by = u.id WHERE u.manager_id = ? ORDER BY r.created_at DESC";
        List<Request> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, managerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(map(rs));
        }
        return list;
    }

    public Request findById(int id) throws SQLException {
        String sql = "SELECT * FROM requests WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
        }
        return null;
    }

    public void updateStatus(int requestId, String newStatus, Integer processedBy, String note) throws SQLException {
        String sql = "UPDATE requests SET status = ?, processed_by = ?, processed_at = CURRENT_TIMESTAMP, process_note = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            if (processedBy == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, processedBy);
            ps.setString(3, note);
            ps.setInt(4, requestId);
            ps.executeUpdate();
        }
        // Optionally insert into request_history
    }

    private Request map(ResultSet rs) throws SQLException {
        Request r = new Request();
        r.setId(rs.getInt("id"));
        r.setTitle(rs.getString("title"));
        r.setFromDate(rs.getDate("from_date"));
        r.setToDate(rs.getDate("to_date"));
        r.setReason(rs.getString("reason"));
        r.setCreatedBy(rs.getInt("created_by"));
        r.setCreatedAt(rs.getTimestamp("created_at"));
        r.setStatus(rs.getString("status"));
        int pb = rs.getInt("processed_by");
        if (rs.wasNull()) r.setProcessedBy(null); else r.setProcessedBy(pb);
        r.setProcessedAt(rs.getTimestamp("processed_at"));
        r.setProcessNote(rs.getString("process_note"));
        return r;
    }

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

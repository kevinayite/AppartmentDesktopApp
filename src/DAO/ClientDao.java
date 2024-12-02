
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import model.Client;

/**
 *
 * @author JOHN SHADARY
 */
public class ClientDao {
    
    public String dburl = "jdbc:postgresql://localhost:5432/appartment_management_system_db";
    public String username = "postgres";
    public String passwd = "java123";
    
    
    public Integer InsertClient(Client clientObj) {
        try {
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "insert into client (client_name, client_phone, client_email, apt_id) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,clientObj.getClientName());
            pst.setString(2, clientObj.getClientPhone());
            pst.setString(3, clientObj.getClientEmail());
            pst.setInt(4, clientObj.getAptId());
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Integer DeleteClient(int clientId) {
        try {
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "delete from  client where client_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, clientId);
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Integer UpdateClient(Client clientObj, int clientId) {
        try {
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "update client SET client_name = ?, client_phone =?, client_email =?, apt_id =? WHERE client_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,clientObj.getClientName());
            pst.setString(2, clientObj.getClientPhone());
            pst.setString(3, clientObj.getClientEmail());
            pst.setInt(4, clientObj.getAptId());
            pst.setInt(5, clientId);
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void DisplayAll(DefaultTableModel tableModel) {
        try {
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "SELECT * FROM client";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                tableModel.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
    
    
    
    


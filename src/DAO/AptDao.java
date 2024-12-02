
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import model.Appartment;

/**
 *
 * @author JOHN SHADARY
 */
public class AptDao {
    
    public String dburl = "jdbc:postgresql://localhost:5432/appartment_management_system_db";
    public String username = "postgres";
    public String passwd = "java123";
    
    public Integer AddApt(Appartment aptObj){
    try{
        Connection con = DriverManager.getConnection(dburl, username, passwd);
        String sql = "insert into appartment (apt_type, apt_price, district, sector, city, apt_status) values (?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, aptObj.getAppartmentType());
        pst.setDouble(2, aptObj.getAppartmentPrice());
        pst.setString(3, aptObj.getDistrict());
        pst.setString(4, aptObj.getSector());
        pst.setString(5, aptObj.getCity());
        pst.setString(6, aptObj.getAppartmentStatus());
        int rowsAffected = pst.executeUpdate();
        con.close();
        return rowsAffected;
    } catch(Exception ex){
        ex.printStackTrace();
        return null; 
    }    
}
    
     public Integer UpdateApt(Appartment aptObj, int aptId){
    try{
        Connection con = DriverManager.getConnection(dburl, username, passwd);
        String sql = "update appartment set apt_type =?, apt_price=?, district=?, sector=?, city=?, apt_status=? where apt_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, aptObj.getAppartmentType());
        pst.setDouble(2, aptObj.getAppartmentPrice());
        pst.setString(3, aptObj.getDistrict());
        pst.setString(4, aptObj.getSector());
        pst.setString(5, aptObj.getCity());
        pst.setString(6, aptObj.getAppartmentStatus());
        pst.setInt(7, aptId);
        int rowsAffected = pst.executeUpdate();
        con.close();
        return rowsAffected;
    } catch(Exception ex){
        ex.printStackTrace();
        return null; 
    }    
}
     public Integer UpdateApt(int aptId) {
        try {
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "UPDATE appartment set apt_status=? where apt_id=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, "Sold");
            pst.setInt(2, aptId);         

            int rows = pst.executeUpdate();
            con.close();
            return rows;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
    public void Display(DefaultTableModel tableModel, String state) {
        try{
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql;
           
            if(state.equals("Admin")){
               sql  = "select * from appartment";
            }else{
                sql  = "select * from appartment where apt_status=?";
            }
             PreparedStatement pst = con.prepareStatement(sql);
              
              if (!state.equals("Admin")){
                   pst.setString(1, "Available");
              }
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                tableModel.addRow(new Object[]{
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                
                });
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public Integer DeleteApt(int aptId){
        try{
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "delete from appartment where apt_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, aptId);
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}

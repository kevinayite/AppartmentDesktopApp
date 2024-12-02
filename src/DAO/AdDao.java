
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Administrator;

/**
 *
 * @author JOHN SHADARY
 */
public class AdDao {
    
    public String dburl = "jdbc:postgresql://localhost:5432/appartment_management_system_db";
    public String username = "postgres";
    public String passwd = "java123";
    
    public boolean AdminLogIn(Administrator adminObj ){
        try{
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "select * from admin where ad_username=? and ad_password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, adminObj.getUsername());
            pst.setString(2, adminObj.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                con.close();
                return true;
            }
            else{
                con.close();
                return false;
            }
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public Integer AdminSignUp(Administrator adminObj){
        try{
            Connection con = DriverManager.getConnection(dburl, username, passwd);
            String sql = "INSERT INTO admin (ad_phone, ad_email, ad_username, ad_name, ad_password) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, adminObj.getPhoneNo());
            pst.setString(2, adminObj.getEmail());
            pst.setString(3, adminObj.getUsername());
            pst.setString(4, adminObj.getName());
            pst.setString(5, adminObj.getPassword());
            
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
    
}

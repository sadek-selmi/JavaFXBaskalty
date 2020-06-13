/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.participer;
import Entite.events;
import Entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataSource;

/**
 *
 * @author hp
 */
public class ParticiperService {
   private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    public ParticiperService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public void ajouterJaime(participer p) throws SQLException {
   
        String req1 = "INSERT INTO `participer` (`events_id`, `user_id`,`Number`) "
                + "VALUES ('" + p.getId_event()+ "', '" + p.getId_User()+ "', '" + p.getNumber()+ "');"; 
               
        ste.executeUpdate(req1);
        System.out.println("elment inseré");
    }
     
    public int FindValeurJaimeByIdUserAndIdSujet(int id_user,int id_event) throws SQLException{
    String req = "SELECT * from participer WHERE events_id='" + id_event +"'AND user_id='"+id_user+ "'";
    ResultSet res = ste.executeQuery(req);
        participer participe=null;
        int Numberr = 0;
        while (res.next()) {
          
           Numberr = res.getInt(4);
           System.out.println(Numberr);
           
        }
        return Numberr;
}
       public void incrementerjaime(int id_user,int id_event) {
        try {
            PreparedStatement ste = con.prepareStatement("update participer set Number=Number+1  WHERE user_id='" +id_user +"'AND events_id='"+id_event+ "'");
            ste.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ParticiperService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void decrementerjaime(int id_user,int id_event) {
        try {
            PreparedStatement ste = con.prepareStatement("update participer set Number=Number-1  WHERE user_id='" +id_user +"'AND events_id='"+id_event+ "'");
            

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParticiperService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

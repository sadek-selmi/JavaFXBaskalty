    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.Service;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
/**
 *
 * @author benha
 */
public class CategorieService implements IService<Service>

{    private Statement st;
      private ResultSet rs;
      Connection cnx = DataSource.getInstance().getConnection();

    public CategorieService() {
    }
   
    public void ajouter(Service c) {
        try {
            String requete = "INSERT INTO service (nom_service)  VALUES ('" + c.getNom_service() + "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("service ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
     public void modifier(Service c ) {
        try {
            String requete = "UPDATE service SET nom_service ='" + 
                    c.getNom_service() + " ' where id= " + c.getId_service();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("catégorie modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        
    public void supprimer (int id) {
         
        try {
            String req="delete from service where id="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("service bien supprimée ! ");
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
   
    public List<Service> afficher()
    {
        List<Service> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM service;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
           list.add(new Service(rs.getInt("id"),rs.getString("nom_service")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
     public Service afficherParId(int id) 
    {
        String req="select * from service where id="+id;
        Service c = new Service();
        try {
         
            rs = st.executeQuery(req);
            
          while(rs.next())
          {
            c = new Service(rs.getInt("id_cat"),rs.getString("nom"));
              System.out.println(c.toString());
        } 
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return c;
    }
   
    
}

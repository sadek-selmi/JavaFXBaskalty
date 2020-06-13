    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.theme;
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
public class ServiceTheme implements IService<theme>

{    private Statement st;
      private ResultSet rs;
      Connection cnx = DataSource.getInstance().getConnection();
    public ServiceTheme() 
    {
    }
    public void ajouter(theme c) {
        try {
            String requete = "INSERT INTO theme (nom)  VALUES ('" + c.getNom() + "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("theme ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
     public void modifier(theme c ) {
        try {
            String requete = "UPDATE theme SET nom ='" + 
                    c.getNom() + " ' where id= " + c.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("theme modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimer (int id) {
         
        try {
            String req="delete from theme where id="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("catégorie bien supprimée ! ");
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<theme> afficher()
    {
        List<theme> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM theme;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
           list.add(new theme(rs.getInt("id"),rs.getString("nom")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
   
    public theme afficherParId(int id) 
    {
        String req="select * from categorie where id_cat="+id;
        theme c = new theme();
        try {
         
            rs = st.executeQuery(req);
            
          while(rs.next())
          {
            c = new theme(rs.getInt("id"),rs.getString("nom"));
              System.out.println(c.toString());
        } 
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return c;
    }
    
    
}

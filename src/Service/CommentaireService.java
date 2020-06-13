/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Comment;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataSource;

/**
 *
 * @author hp
 */

public class CommentaireService {
   private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public CommentaireService() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    public void ajouterCommentaire(Comment c) throws SQLException {
              java.util.Date date1 = new java.util.Date();
        String temp_commentaire = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        c.setTemps_Commentaire(temp_commentaire);
        String req1 = "INSERT INTO `comment` ( `user`, `publishdate`,`content`, `Events`) VALUES ('" + c.getId_User() + "', '" + c.getTemps_Commentaire() + "', '" + c.getContenu_Commentaire() + "', '" + c.getId_event() + "');";
        ste.executeUpdate(req1);
        System.out.println("element inseré");

    }
    
    
   public void supprimerCommentaire(Comment c) {
            
     try {
            String req = "DELETE FROM `comment` WHERE `comment`.`id` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, c.getId());
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
   public void modifierCommentaire(Comment c) {      
     String sql = "UPDATE comment SET `user`=?,`publishdate`=?,`content`=?,`events`=? WHERE id=" + c.getId();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);
            ste.setInt(1, c.getId_User());
            ste.setInt(4, c.getId_event());

            ste.setString(3, c.getContenu_Commentaire());
            ste.setString(2, c.getTemps_Commentaire());

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de commenter " + c.getId() + " a été éffectué avec succée ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public List<Comment> readAll(int id_event) throws SQLException
   {
    List<Comment> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from comment WHERE Events='"+id_event+"'ORDER BY id");
    Comment com=null;
    while (res.next()) {            
      com=new Comment(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getInt(5));
      list.add(com);
        }   
    return list;
}
    } 

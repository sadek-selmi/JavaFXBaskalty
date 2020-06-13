/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.events;
import Entite.User;
import Utils.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dell is hell
 */
public class EvenementService {
 private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public EvenementService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Boolean ajouterEvent(events e) throws SQLException {
       boolean test=false;
        try {
            
            String requete = "INSERT INTO events (association,name,location,"
                    + "description,start,end,prix,quantity,image,themeid,commenternumber,Interstednumber,Participernumber) VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(requete);
            int s ;
            s=0 ;
           // pst.setInt(1,e.getCategorie().getId());
            pst.setInt(1, e.getId_User());
           pst.setString(2,e.getTitre());
            pst.setString(3, e.getLocation());
            pst.setString(4, e.getContenu());
               java.sql.Timestamp javaSqlDate = Timestamp.valueOf(e.getStart());
             pst.setTimestamp(5, javaSqlDate);
           java.sql.Timestamp javaSqlDates = Timestamp.valueOf(e.getEnd());
             pst.setTimestamp(6, javaSqlDates);
            pst.setString(9, e.getImage());
            pst.setInt(7, e.getPrix());
            pst.setInt(8, e.getQuantity());
            pst.setInt(10, Fthele(e.getCategorie()));
                        pst.setInt(11, s);
            pst.setInt(12, s);
            pst.setInt(13, s);

            pst.executeUpdate();
            test=true;
            System.out.println("Nouveau evenement  !");
        } catch (SQLException ex) {
        }
        return test ;
}
   
    
        
    public void modifierEvent (events e) {
        try {
            String requete = "UPDATE events SET association='"+e.getId_User()
                    + "',name='"+e.getTitre()+ "',description='"+e.getContenu()
                    +"',location='"+e.getLocation() +"',image='"+e.getImage() +"',start='"+ e.getStart()
                    +"',end='"+e.getEnd() + "',prix='"+e.getPrix()+ "',quantity='"+e.getQuantity()
                    + "' WHERE id=" + e.getId_Event();
            Statement st = con.createStatement();
            st.executeUpdate(requete);
            int rowsUpdated = st.executeUpdate(requete);
            if (rowsUpdated > 0) {
                System.out.println("La modification de sujet" + e.getId_Event() + " a été éffectué avec succée ");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  public void compterNbreVue(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set interstednumber=interstednumber+1 WHERE events=" + s.getNbre_vues());
            

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerEvent(events s) {

        try {
            String req = "DELETE FROM `events` WHERE `events`.`id` =?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, s.getId_Event());
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    
    public boolean rechercherparNom(String nom) {
        boolean test = false;
        String req = "SELECT * from events where name='" + nom + "'";

        try {

            ResultSet stp = ste.executeQuery(req);
            stp.last();
            if (stp.getRow() != 0) {
                test = true;
                System.out.println(test + "\n events trouver");
            } else {
                test = false;
                System.out.println(test + "\n events non trouver");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
  /*  public List<events> readAllSByCategorie(Categorie caString) throws SQLException {
        List<events> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from events WHERE themeid='" + caString.name()+ "'");
        events com = null;
        while (res.next()) {
            com = new events(res.getInt(3),res.getString(7), res.getString(9), res.getString(8), res.getDate(10), res.getDate(12), res.getInt(13), res.getInt(14));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }*/

    public Vector<events> readAllS() throws SQLException {
        Vector<events> vector = new Vector<>();
        
       
            
            ResultSet res = ste.executeQuery("select * from events");
            events com = null;
            while (res.next()) {
        //  public events(int Id_Event, String Titre, String Contenu, int Participernumber, int Interstednumber, int commenternumber, String location, String image, int prix, int quantity, String categorie, Date debut, Date Fin) {

            com = new events(res.getInt(1),res.getString(7),res.getString(9), res.getInt(4), res.getInt(5), res.getInt(6), res.getString(8), res.getString(13),res.getInt(11) ,res.getInt(12),res.getString(2),res.getDate(10),res.getDate(14),res.getTimestamp(10),res.getTimestamp(14));
            vector.add(com);
            
            
            }
            System.out.println("tous les events:\n"+vector);
         
        return vector;
    }
    
public void supprimerEvent (int id) {
         String req="delete from events where id="+id;
        try {
            ste.executeUpdate(req);
            System.out.println("Eveneemnet bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(events.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public List<events> FindEventByIdUser(int id_user) throws SQLException {
        List<events> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from events WHERE association='" + id_user + "'");
        events com = null;
        while (res.next()) {
               // public events(int Id_Event, int Id_User, String Titre, String Contenu, String location, Date start, Date end, int prix, int quantity) {

            com = new events(res.getInt(1),res.getString(7),res.getString(9), res.getInt(4), res.getInt(5), res.getInt(6), res.getString(8), res.getString(13),res.getInt(11) ,res.getInt(12),res.getString(2),res.getDate(10),res.getDate(14));

            list1.add(com);
            
        }
        System.out.println(list1);
        return list1;
    }

   // public events(int Id_User, String Titre, String Contenu, String location, Date start, Date end, int prix, int quantity) {

    public List<events> TrierParNbreVue() throws SQLException {
        List<events> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from events ORDER BY Participernumber DESC");
        events com = null;
        while (res.next()) {
            com = new events(res.getInt(1),res.getString(7),res.getString(9), res.getInt(4), res.getInt(5), res.getInt(6), res.getString(8), res.getString(13),res.getInt(11) ,res.getInt(12),res.getString(2),res.getDate(10),res.getDate(14));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }

   
    public String FindNomUserByIdUser_events(int id_user) throws SQLException {
        String req = "SELECT * from fos_user where id='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
        while (res.next()) {

            nom = res.getString(5);
        }
        return nom;
    }
    public String FindNomUsetheme(String id_user) throws SQLException {
        String req = "SELECT * from theme where id='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
        while (res.next()) {

            nom = res.getString(2);
        }
        return nom;
    }
     public int FindIntersed(int id_user,int event ) throws SQLException {
         String req = "SELECT * from interested where user_id= '" + id_user + "' and events_id= "+ event;
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
           int nbre = 0;
        while (res.next()) {

            nbre = res.getInt(1);
        }
        return nbre;
    }
     public int FindParticiper(int id_user,int event ) throws SQLException {
         String req = "SELECT * from participer where user_id= '" + id_user + "' and events_id= "+ event;
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
           int nbre = 0;
        while (res.next()) {

            nbre = res.getInt(1);
        }
        return nbre;
    }
      public int validerParticiper(int id_user,int event ) throws SQLException {
         String req = "SELECT * from participer where user_id= '" + id_user + "' and events_id= "+ event;
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
           int nbre = 0;
        while (res.next()) {

            nbre = res.getInt(4);
            System.out.println("3"+res.getInt(3)+"4"+res.getInt(4));
        }
        return nbre;
    }
     public String FindNomUsethemeint(int id_user) throws SQLException {
        String req = "SELECT * from theme where id='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
        while (res.next()) {

            nom = res.getString(2);
        }
        return nom;
    }
   public void compterintersted(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set Interstednumber=Interstednumber+1 WHERE id=" + s.getId_Event());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void compterinterstedpas(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set Interstednumber=Interstednumber-1 WHERE id=" + s.getId_Event());
           
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int FindNombreIntersById_events(int id_event) throws SQLException{
    String req = "SELECT * from events where association='" + id_event + "'";
    ResultSet res = ste.executeQuery(req);
         User com = null;
          int nbre = 0;
        while (res.next()) {
          
           nbre = res.getInt(5);
        }
        return nbre;
}
       public int Fthele(String c) throws SQLException{
    String req = "SELECT id from theme where nom='" + c + "'";
    ResultSet res = ste.executeQuery(req);
          int nbre = 0;
        while (res.next()) {
          
           nbre = res.getInt(1);
        }
        return nbre;
}
         public void ajouterInterd(int id_user,int event ) throws SQLException {
              java.util.Date date1 = new java.util.Date();
        String req1 = "INSERT INTO `interested` ( `events_id`, `user_id`) VALUES ('" + event + "', '" +id_user + "');";
        ste.executeUpdate(req1);
        System.out.println("element inseré");

    }
    
   public void supprimerInterd(int id) {
            
     try {
            String req = "DELETE FROM `interested` WHERE `interested`.`events_id` = ' "+id+"'";
            PreparedStatement ste = con.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       public void ajouterParticiperrr(int id_user,int event ,String champ,int con ) throws SQLException {
        String req1 = "INSERT INTO `participer` ( `events_id`, `user_id`,`champsConfirmation`,`confirmation`) VALUES ('" + event + "', '" +id_user + "','" + champ + "','" + con + "');";
        ste.executeUpdate(req1);
        System.out.println("element inseré");

    }
    
    
    private DataSource cnx;
    public ResultSet rs;
    public int x;
    public String y,z;
    public String username,pass,mesg,email,code;
     public void compterParticiper(int id_user,int event) throws SQLException, AddressException, MessagingException {
           
     
          	

         Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");


    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication("baskaltii@gmail.com","21885045");
  	  }
   });
    session.setDebug(true);
        
   try
   {
 EvenementService sp = new EvenementService();
 
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress("baskaltii@gmail.com"));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress("selmisadekk@gmail.com"));
       
       message.setSubject("Confirmation Participation ");
               int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();
 
    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
 String messageBody = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "<style>\n"
                + "* {\n"
                + "  box-sizing: border-box;\n"
                + "}\n"
                + "\n"
                + "/* Add a gray background color with some padding */\n"
                + "body {\n"
                + "  font-family: Arial;\n"
                + "  padding: 20px;\n"
                + "  background: #f1f1f1;\n"
                + "}\n"
                + "\n"
                + "/* Header/Blog Title */\n"
                + ".header {\n"
                + "  padding: 30px;\n"
                + "  font-size: 40px;\n"
                + "  text-align: center;\n"
                + "  background: white;\n"
                + "}\n"
                + "\n"
                + "/* Create two unequal columns that floats next to each other */\n"
                + "/* Left column */\n"
                + ".leftcolumn {   \n"
                + "  float: left;\n"
                + "  width: 75%;\n"
                + "}\n"
                + "\n"
                + "/* Right column */\n"
                + ".rightcolumn {\n"
                + "  float: left;\n"
                + "  width: 25%;\n"
                + "  padding-left: 20px;\n"
                + "}\n"
                + "\n"
                + "/* Fake image */\n"
                + ".fakeimg {\n"
                + "  background-color: #aaa;\n"
                + "  width: 100%;\n"
                + "  padding: 20px;\n"
                + "}\n"
                + "\n"
                + "/* Add a card effect for articles */\n"
                + ".card {\n"
                + "   background-color: white;\n"
                + "   padding: 20px;\n"
                + "   margin-top: 20px;\n"
                + "}\n"
                + "\n"
                + "/* Clear floats after the columns */\n"
                + ".row:after {\n"
                + "  content: \"\";\n"
                + "  display: table;\n"
                + "  clear: both;\n"
                + "}\n"
                + "\n"
                + "/* Footer */\n"
                + ".footer {\n"
                + "  padding: 20px;\n"
                + "  text-align: center;\n"
                + "  background: #ddd;\n"
                + "  margin-top: 20px;\n"
                + "}\n"
                + "\n"
                + "/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */\n"
                + "@media screen and (max-width: 800px) {\n"
                + "  .leftcolumn, .rightcolumn {   \n"
                + "    width: 100%;\n"
                + "    padding: 0;\n"
                + "  }\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<div class=\"header\">\n"
                + "  <h2>Baskalty</h2>\n"
                + "</div>\n"
                + "\n"
                + "<div class=\"row\">\n"
                + "  <div class=\"\">\n"
                + "    <div class=\"card\">\n"
         + "  <h3>Votre code de confirmation :</h3>\n"
                + "      <h2>" + generatedString+ "</h2>\n"
                + "      \n"
             
                + "    </div>\n"
                + "    \n"
                + "  </div>\n"
                + "  \n"
                + "</div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "</body>\n"
                + "</html>";
    System.out.println(generatedString);
     message.setContent(messageBody, "test/html ; charset=utf-8");
        message.setText(messageBody, null, "html");
String req1 = "INSERT INTO `participer` ( `events_id`, `user_id`,`champsConfirmation`,`confirmation`,`Number`) VALUES ('" + event + "', '" +id_user + "','" + generatedString + "','" + 0 +"','"+0+ "');";
        ste.executeUpdate(req1);
       Transport.send(message);
       
  System.out.println("file name send successfully");  

		  } catch (MessagingException e) {

throw new RuntimeException(e);}  
		   
		 }
     public void compterparticipper(int e) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set Participernumber=Participernumber+1 , quantity=quantity-1 WHERE id=" + e);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void compterNUMBER(int e) {
        try {
            PreparedStatement ste = con.prepareStatement("update participer set confirmation=confirmation+1  WHERE events_id=" + e);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void compterparticiper(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set Participernumber=Participernumber-1 WHERE id=" + s.getId_Event());
           
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public int chercherchamps(String event ) throws SQLException {
         String req = "SELECT * from participer where champsConfirmation= '" + event +"'";
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
           int nbre = 0;
        while (res.next()) {

            nbre = res.getInt(2);
            System.out.println("evvv"+res.getInt(1)+"sss"+res.getInt(2));
        }
        return nbre;
    }
public int validerParticiperNUMBER(int id_user,int event ) throws SQLException {
         String req = "SELECT * from participer where user_id= '" + id_user + "' and events_id= "+ event;
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
           int nbre = 0;
        while (res.next()) {

            nbre = res.getInt(4);
            System.out.println("3"+res.getInt(3)+"4"+res.getInt(4));
        }
        return nbre;
    }

     /*  TrayNotification tray = new TrayNotification("Success !", "Order has been created ! ", NotificationType.SUCCESS);
             tray.showAndDismiss(Duration.seconds(3));*/
}

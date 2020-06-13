/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author WSI
 */
public class fos_user {
    private int id;
    private String username;
    private String email;
    private int enabled;
    private String password;
    private String confirmation_token;
    private String roles;
    private String image_files;
    private LocalDateTime  registration_date;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

   
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getImage_files() {
        return image_files;
    }

    public void setImage_files(String image_files) {
        this.image_files = image_files;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
        this.registration_date = registration_date;
    }

   

   

    

    public fos_user(String username, String email, int enabled, String password, String confirmation_token, String roles, String image_files) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.confirmation_token = confirmation_token;
        this.roles = roles;
        this.image_files = image_files;
    }

    public fos_user(int id, String username, String email, int enabled, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles, String image_files) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.confirmation_token = confirmation_token;
        this.roles = roles;
        this.image_files = image_files;
    }

   

    public fos_user() {
    }

    public fos_user(String username, String email, int enabled, String password, String roles, String image_files, LocalDateTime registration_date) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
        this.image_files = image_files;
        this.registration_date = registration_date;
    }

    public fos_user(String username, String email, int enabled, String password, String confirmation_token, String roles, String image_files, LocalDateTime registration_date) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.confirmation_token = confirmation_token;
        this.roles = roles;
        this.image_files = image_files;
        this.registration_date = registration_date;
    }

    public fos_user(int id, String username, String email, int enabled, String password, String confirmation_token, String roles, String image_files) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.confirmation_token = confirmation_token;
        this.roles = roles;
        this.image_files = image_files;
    }

   
    public fos_user(String username, String username_canonical, String email, String password, String roles, String image_files) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.image_files = image_files;
    }

    @Override
    public String toString() {
        return "fos_user{" + "id=" + id + ", username=" + username +  ", email=" + email + ", enabled=" + enabled + ", password=" + password + ", confirmation_token=" + confirmation_token + ", roles=" + roles + ", image_files=" + image_files + ", registration_date=" + registration_date + '}';
    }

    public fos_user(String username, String email, String password, String roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public fos_user(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public fos_user(int id, String username, int enabled, String password, String roles) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
    }
    

   
    }

   

  
    

    
   
    



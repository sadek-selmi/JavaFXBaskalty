/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author hp
 */
public class participer {
  private int Id_User;
    private int Id_event;
    private int Number;

    public participer() {
    }

    public participer(int Id_User, int Id_event, int Number) {
        this.Id_User = Id_User;
        this.Id_event = Id_event;
        this.Number = Number;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public int getId_event() {
        return Id_event;
    }

    public void setId_event(int Id_event) {
        this.Id_event = Id_event;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

   
}

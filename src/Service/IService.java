/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.util.List;
/**
 *
 * @author benha
 * @param <T>
 */
public interface IService<T> 
{
    public void ajouter(T t);
    public void supprimer(int id);
    public void modifier(T id);
    //public T afficherParId(int id);
    public List<T> afficher();
}

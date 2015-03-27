/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chat;
import java.util.ArrayList;
/**
 *
 * @author aC-Ma_000
 */

public class Usuario { 
    
    private static ArrayList  ArrayUsuarios = new ArrayList ();

    public ArrayList getUsuarios () {
        return ArrayUsuarios;
    }

    public void addUsuarios(String usuario) {
        this.ArrayUsuarios.add(usuario);
    }
    
}
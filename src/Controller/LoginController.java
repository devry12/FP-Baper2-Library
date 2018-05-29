/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoginModel;
import View.Login;

/**
 *
 * @author Devry Kawiryan
 */
public class LoginController {
    private Login viewl;
    private LoginModel model;

    public LoginController(Login viewl) {
        this.viewl = viewl;
        model = new LoginModel();
    }
    
    
    //bagian login 
    public boolean login(String username,String password){
        model.setUsername(username);
        model.setPassword(password);
        
        return model.login();
    }
    
    
    
}

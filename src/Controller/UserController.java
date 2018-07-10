/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.Login;
import View.Register;
import View.Profile;
import View.Public_Storage;
import View.Main;

/**
 *
 * @author Devry Kawiryan
 */
public class UserController {
    private Login viewl;
    private Register view2;
    private Profile view3;
    private Main view4;
    private UserModel model;

    public UserController(Login viewl) {
        this.viewl = viewl;
        model = new UserModel();
    }

    public UserController(Register view2) {
        this.view2 = view2;
        model = new UserModel();
    }

    public UserController(Profile view3) {
        this.view3 = view3;
        model = new UserModel();
    }

    public UserController(Main view4) {
        this.view4 = view4;
        model = new UserModel();
    }

    
    
    
    
    
    //bagian login 
    public boolean login(String username,String password){
        model.setUsername(username);
        model.setPassword(password);
        
        return model.login();
    }
    
    //bagian register
    public void  inputRegister(String username,String password){
        model.setUsername(username);
        model.setPassword(password);
        System.out.println(username);
        System.out.println(password);

        
    }
    
    public boolean insertRegister(){
        return model.Regsiter();
        
    }
    
    public void GetProfile(){
        model.GetDataprofile();
    }
    
    public  void GetRowProfile(){
        model.GetRowProfile();
    }
    
    public boolean UpdateProfile(){
        return model.UpdateProfile();
    }
    
    public boolean InsertProfile(){
        return model.InsertProfile();
    }
    
    public void inputUpdate(String NamaLengkap,String NoTlp){
        Public_Storage.NamaLengkap = NamaLengkap;
        Public_Storage.NoTlp = NoTlp;
    }
    
    
    
}

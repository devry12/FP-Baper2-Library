/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.db;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Devry Kawiryan
 */
public class LoginModel {

    
    private db config;
    private String username;
    private String password;
    
    private ResultSet rsLogin;
    private String query;
    private boolean status;
    
    public LoginModel(){
        config = new db();
        config.getConn();
        
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean login(){
        
        query = "SELECT * FROM users WHERE username ='"+username+"' and password = md5('"+password+"')";
        status = config.eksekusiQuery(query, true);
        if (status) {
                        rsLogin = config.getRs();
            try {
                rsLogin.next();
                username = rsLogin.getString(1);
                password = rsLogin.getString(2);
                if(username == null){
                    status = false;
                }else{
                    status = true;
                }
            } catch (SQLException se) {
                status = false;
            }
        }else{
             status = false;
        }
        return status;
    }
    
}

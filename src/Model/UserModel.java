/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.db;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import View.Public_Storage;
import java.util.List;

/**
 *
 * @author Devry Kawiryan
 */
public class UserModel {

    
    private db config;
    private String username;
    private String password;
    
    private ResultSet rsLogin;    
    private ResultSet rsProfle;

    private String query;
    private boolean status;
    
    public UserModel(){
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
                username = rsLogin.getString("username");
                password = rsLogin.getString("password");
                Public_Storage.userid = rsLogin.getString("id_user");
                Public_Storage.username = username;
                System.out.println(username);
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
    
    public boolean Regsiter(){
        query = "INSERT INTO users(username,password) VALUES('"+username+"',md5('"+password+"'))";
        status = config.eksekusiQuery(query, false);
        return status;
       
        
    }
    
    
    //get profile
    private String NamaLengkap;
    private String NoTlp;
    private String Status;
    
    public void GetDataprofile(){
        query = "SELECT * FROM users,profile_user pro WHERE users.id_user = pro.id_user AND users.id_user = "+Public_Storage.userid+"";
        status = config.eksekusiQuery(query, true);
        System.out.println("Get data Profile = "+query);
        
        if (status) {
            rsProfle = config.getRs();
           
            try {
                rsProfle.next();
            Public_Storage.NamaLengkap = rsProfle.getString("nama_lengkap");            
            Public_Storage.NoTlp = rsProfle.getString("no_tlp");
            Public_Storage.Status = rsProfle.getString("denda");
                
            } catch (Exception e) {
            }
        }
    }
    
    public void GetRowProfile(){
        query = "SELECT COUNT(*) as RowData FROM users,profile_user WHERE users.id_user = profile_user.id_user AND users.id_user = "+Public_Storage.userid+"";

        status = config.eksekusiQuery(query, true);
        System.out.println(query);
        
        if (status) {
            rsProfle = config.getRs();
           
            try {
                rsProfle.next();
            Public_Storage.GetRowProfile = rsProfle.getString("RowData");            
           
                
            } catch (Exception e) {
            }
        }
    }
    
    //insert profile
    public boolean InsertProfile(){
        query = "INSERT INTO profile_user(id_user,nama_lengkap,no_tlp) VALUES("+Public_Storage.userid+",'"+Public_Storage.NamaLengkap+"','"+Public_Storage.NoTlp+"')";
        status = config.eksekusiQuery(query, false);
        return status;
    }
    //update Profile
    public boolean UpdateProfile(){
        query = "UPDATE profile_user SET nama_lengkap = '"+Public_Storage.NamaLengkap+"', no_tlp='"+Public_Storage.NoTlp+"'";
        status = config.eksekusiQuery(query, false);
        return status;
    }
    
}

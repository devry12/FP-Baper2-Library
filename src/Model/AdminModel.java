/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.db;
import View.Public_Storage;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Devry Kawiryan
 */
public class AdminModel {
    private db config;
    private String query;
    private boolean status;
    
    public AdminModel(){
        config = new db();
        config.getConn();
        
    }
    
        //buku
    private String NamaBuku;
    private String Kategori;
    private String Pengarang;
    private String Penerbit;
    private String TahunTerbit;
    private String NoRak;

    public String getNamaBuku() {
        return NamaBuku;
    }

    public void setNamaBuku(String NamaBuku) {
        this.NamaBuku = NamaBuku;
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String Kategori) {
        this.Kategori = Kategori;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    public String getTahunTerbit() {
        return TahunTerbit;
    }

    public void setTahunTerbit(String TahunTerbit) {
        this.TahunTerbit = TahunTerbit;
    }

    public String getNoRak() {
        return NoRak;
    }

    public void setNoRak(String NoRak) {
        this.NoRak = NoRak;
    }
    
    
    
        //for login 

    private String username;
    private String password;
    private ResultSet rsLogin;

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
        System.out.println(username+" "+password);
        query = "SELECT * FROM users WHERE username ='"+username+"' and password = md5('"+password+"') AND status = 'admin'";
        System.out.println("Query = "+query);
        status = config.eksekusiQuery(query, true);
        System.out.println("Status = "+status);
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
    
    //select edit data
    public boolean SelectEditDataBuku(String idBuku){
        query = "SELECT * FROM Buku WHERE id_buku ='"+idBuku+"'";
        System.out.println("Query = "+query);
        status = config.eksekusiQuery(query, true);
        System.out.println("Status = "+status);
        if (status) {
                        rsLogin = config.getRs();
            try {
                rsLogin.next();
                Public_Storage.kategori = rsLogin.getString("id_kategori");                
                Public_Storage.penerbit = rsLogin.getString("id_penerbit");
                Public_Storage.pengarang = rsLogin.getString("id_pengarang");
            } catch (SQLException se) {
                status = false;
            }
        }else{
             status = false;
        }
        return status;
    }
    
    //Input Buku
    
   public boolean InsertBuku(){
       query = "INSERT INTO buku(judul_buku,id_kategori,id_penerbit,id_pengarang,tahun_terbit,no_rak) VALUES('"+NamaBuku+"',"+Kategori+","+Penerbit+","+Pengarang+","+TahunTerbit+","+NoRak+") ";
       System.out.println(query);
       status = config.eksekusiQuery(query,false);
       return status;
       
   }
   
   public boolean UpdateBuku(String idBuku){
       query = "UPDATE buku SET judul_buku = '"+NamaBuku+"',id_kategori = "+Kategori+",id_pengarang ="+Pengarang+",tahun_terbit="+TahunTerbit+",no_rak="+NoRak+" WHERE id_buku='"+idBuku+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
   
   // kategori
    public boolean InsertKategori(String namaKategori){
       query = "INSERT INTO kategori(nama_kategori) VALUES('"+namaKategori+"') ";
       System.out.println(query);
       status = config.eksekusiQuery(query,false);
       return status;
       
   }
       
     public boolean UpdateKat(String idKat,String namaKat){
       query = "UPDATE kategori SET nama_kategori = '"+namaKat+"' WHERE id_kategori='"+idKat+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
     
    public boolean DeleteKat(String idKat){
       query = "DELETE FROM kategori WHERE id_kategori='"+idKat+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
    
    
    // Penerbit
    public boolean InsertPenerbit(String namaPener){
       query = "INSERT INTO penerbit(nama_penerbit) VALUES('"+namaPener+"') ";
       System.out.println(query);
       status = config.eksekusiQuery(query,false);
       return status;
       
   }
       
     public boolean UpdatePener(String idPener,String namaPener){
       query = "UPDATE penerbit SET nama_penerbit = '"+namaPener+"' WHERE id_penerbit='"+idPener+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
     
    public boolean DeletePener(String idPener){
       query = "DELETE FROM penerbit WHERE id_penerbit='"+idPener+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
    
    // Pengarang
    public boolean InsertPengar(String namaPengar){
       query = "INSERT INTO pengarang(nama_pengarang) VALUES('"+namaPengar+"') ";
       System.out.println(query);
       status = config.eksekusiQuery(query,false);
       return status;
       
   }
       
     public boolean UpdatePengar(String idPengar,String namaPengar){
       query = "UPDATE pengarang SET nama_pengarang = '"+namaPengar+"' WHERE id_pengarang='"+idPengar+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
     
    public boolean DeletePengar(String idPengar){
       query = "DELETE FROM pengarang WHERE id_pengarang='"+idPengar+"'";
       System.out.println(query);
       status = config.eksekusiQuery(query, false);
       return status;
   }
   
}

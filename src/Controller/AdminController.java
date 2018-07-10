/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminModel;
import View.Kategoris;
import View.AdminLogin;
import View.AdminPanel;
import View.Penerbit;
import View.Pengarang;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 *
 * @author Devry Kawiryan
 */
public class AdminController {
    private AdminLogin login;
    private AdminPanel admin;
    private Kategoris Kategori;
    private Penerbit penerbit;
    private Pengarang Pengarang;
    private AdminModel model;
    


    
    

    

    public AdminController(AdminLogin login ) {
        this.login = login;
        model = new AdminModel();
    }

    public AdminController(AdminPanel admin) {
        this.admin = admin;
        model = new AdminModel();
    }

    public AdminController(Kategoris Kategori) {
        
        this.Kategori = Kategori;
        model = new AdminModel();
    }

    public AdminController(Penerbit penerbit) {

        this.penerbit = penerbit;

         model = new AdminModel();
    }

    public AdminController(Pengarang Pengarang) {
        this.Pengarang = Pengarang;
        model = new AdminModel();
    }
    
    
    
    
    
    
    
    
    public boolean AdminLogin(String username,String password){
        model.setUsername(username);
        model.setPassword(password);
        
        return model.login();
    }
    
    public boolean insertDataBuku(String NamaBuku,String Kategori,String Pengarang,String Penerbit,String TahunTerbit,String NoRak){
        model.setNamaBuku(NamaBuku);
        model.setKategori(Kategori);
        model.setPenerbit(Penerbit);
        model.setPengarang(Pengarang);
        model.setTahunTerbit(TahunTerbit);
        model.setNoRak(NoRak);
        return model.InsertBuku();
    }
    
    public boolean UpdateDataBuku(String idBuku,String NamaBuku,String Kategori,String Pengarang,String Penerbit,String TahunTerbit,String NoRak){
        model.setNamaBuku(NamaBuku);
        model.setKategori(Kategori);
        model.setPenerbit(Penerbit);
        model.setPengarang(Pengarang);
        model.setTahunTerbit(TahunTerbit);
        model.setNoRak(NoRak);
        return model.UpdateBuku(idBuku);
    }
    
    public void SelectDataEditBuku(String idBuku){
        model.SelectEditDataBuku(idBuku);
    }
    
    
  //kategori
    public boolean InsertKategori(String namaKategori){
        return model.InsertKategori(namaKategori);
    }
    
     public boolean UpdateKat(String idKat,String namaKategori){
        return model.UpdateKat(idKat, namaKategori);
    }
     
    public boolean DeleteKat(String idKat){
        return model.DeleteKat(idKat);
    }
    
    //penerbit
    public boolean InsertPenerbit(String namaPener){
        return model.InsertPenerbit(namaPener);
    }
    
     public boolean UpdatePener(String idPener,String namaPener){
        return model.UpdatePener(idPener, namaPener);
    }
     
    public boolean DeletePener(String idPener){
        return model.DeletePener(idPener);
    }
    
        //penerbit
    public boolean InsertPengar(String namaPengar){
        return model.InsertPengar(namaPengar);
    }
    
     public boolean UpdatePengar(String idPengar,String namaPengar){
        return model.UpdatePengar(idPengar, namaPengar);
    }
     
    public boolean DeletePegar(String idPengar){
        return model.DeletePengar(idPengar);
    }

    
}

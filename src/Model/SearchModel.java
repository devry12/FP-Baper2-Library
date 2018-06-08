/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Devry Kawiryan
 */
public class SearchModel {
    

    private db config;
    private String NamaBuku;
    private String Kategory;
    private String Pengarang;
    private String penerbit;
    private String ThnTerbit;
    private ResultSet rsSearch;
    private ResultSet rsCategory;
    private String query;
    

            public SearchModel(){
        config = new db();
        config.getConn();
        
    }
    
    public String getNamaBuku() {
        return NamaBuku;
    }

    public void setNamaBuku(String NamaBuku) {
        this.NamaBuku = NamaBuku;
    }

    public String getKategory() {
        return Kategory;
    }

    public void setKategory(String Kategory) {
        this.Kategory = Kategory;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getThnTerbit() {
        return ThnTerbit;
    }

    public void setThnTerbit(String ThnTerbit) {
        this.ThnTerbit = ThnTerbit;
    }
    
    
    
    
    //deklarasi kategori
    private String id_kategori;
    private String NamaKategori;
    private List<SearchModel> kategori; 

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNamaKategori() {
        return NamaKategori;
    }

    public void setNamaKategori(String NamaKategori) {
        this.NamaKategori = NamaKategori;
    }
    
    
    
    
    public List categori(){
        query = "SELECT * FROM kategori";
        
        if (config.eksekusiQuery(query, true)) {
            rsCategory = config.getRs();
            
            try {
                while(rsCategory.next()){
                    SearchModel model = new SearchModel();
                    model.setNamaKategori(rsCategory.getString(1));
                    model.setId_kategori(rsCategory.getString(2));
                    kategori.add(model);
                }
                rsCategory.close();
                return kategori;
            } catch (Exception e) {
            }
            
        }else{
            System.out.println("Ada masalah di query");
        }
        
       return null;
    }
    
}

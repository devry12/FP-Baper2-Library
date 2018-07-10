/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private String IdBuku;
    private String idKategori;
    private String idPengarang;
    private String idPenerbit;

    public String getIdBuku() {
        return IdBuku;
    }

    public void setIdBuku(String IdBuku) {
        this.IdBuku = IdBuku;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String Lokasi) {
        this.Lokasi = Lokasi;
    }
    private String Lokasi;

    private ResultSet rsSearch;    
    private ResultSet rsCariBuku;
    private ResultSet rsCategory;
    private List<SearchModel> cariSemuaBuku; 
    private String query;
    private Boolean status;   

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

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getIdPengarang() {
        return idPengarang;
    }

    public void setIdPengarang(String idPengarang) {
        this.idPengarang = idPengarang;
    }

    public String getIdPenerbit() {
        return idPenerbit;
    }

    public void setIdPenerbit(String idPenerbit) {
        this.idPenerbit = idPenerbit;
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
        status = config.eksekusiQuery(query, true);
        if (status) {
            rsCategory = config.getRs();
            kategori = new ArrayList<SearchModel>();
            try {
                while(rsCategory.next()){
                    SearchModel model = new SearchModel();
                    model.setNamaKategori(rsCategory.getString(2));
                    model.setId_kategori(rsCategory.getString(1));
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
    
    
    //tampil pengarang
    private String idpengarang;
    private String namaPengarang;
    private List<SearchModel> pengarang; 
   

    public String getIdpengarang() {
        return idpengarang;
    }

    public void setIdpengarang(String idpengarang) {
        this.idpengarang = idpengarang;
    }

    public String getNamaPengarang() {
        return namaPengarang;
    }

    public void setNamaPengarang(String namaPengarang) {
        this.namaPengarang = namaPengarang;
    }
    
    private ResultSet rspengarang;
    public List pengarang(){
        query = "SELECT * FROM pengarang";
        status = config.eksekusiQuery(query, true);
        if (status) {
            rspengarang = config.getRs();
            pengarang = new ArrayList<SearchModel>();
            try {
                while(rspengarang.next()){
                    SearchModel model = new SearchModel();
                    model.setIdpengarang(rspengarang.getString(1));
                    model.setNamaPengarang(rspengarang.getString(2));
                    pengarang.add(model);
                }
                rspengarang.close();
                return pengarang;
            } catch (Exception e) {
            }
            
        }else{
            System.out.println("Ada masalah di query");
        }
        
       return null;
    }
    
    //tampil penerbit
    private String idpenerbit;
    private String namapenerbit;
    private List<SearchModel> penerbits;
    private ResultSet rspenerbit;
    

    public String getIdpenerbit() {
        return idpenerbit;
    }

    public void setIdpenerbit(String idpenerbit) {
        this.idpenerbit = idpenerbit;
    }

    public String getNamapenerbit() {
        return namapenerbit;
    }

    public void setNamapenerbit(String namapenerbit) {
        this.namapenerbit = namapenerbit;
    }
    
    
     public List penerbit(){
        query = "SELECT * FROM penerbit";
        status = config.eksekusiQuery(query, true);
        if (status) {
            rspenerbit = config.getRs();
            penerbits = new ArrayList<SearchModel>();
            try {
                while(rspenerbit.next()){
                    SearchModel model = new SearchModel();
                    model.setIdpenerbit(rspenerbit.getString(1));
                    model.setNamapenerbit(rspenerbit.getString(2));
                    penerbits.add(model);
                }
                rspenerbit.close();
                return penerbits;
            } catch (Exception e) {
            }
            
        }else{
            System.out.println("Ada masalah di query");
        }
        
       return null;
    }
     
     
     
     //cari buku
     public List caribuku(String NamaBuku,String Pengarang,String penerbit,String Kategory,String ThnTerbit){
        query = "SELECT buku.*,kategori.*,pengarang.*,penerbit.* FROM buku,kategori,penerbit,pengarang WHERE buku.id_kategori = kategori.id_kategori AND buku.id_penerbit = penerbit.id_penerbit AND buku.id_pengarang = pengarang.id_pengarang AND buku.judul_buku LIKE '%"+NamaBuku+"%' AND kategori.nama_kategori LIKE '%"+Kategory+"%' AND pengarang.nama_pengarang LIKE '%"+Pengarang+"%' AND penerbit.nama_penerbit LIKE '%"+penerbit+"%' AND buku.tahun_terbit LIKE '%"+ThnTerbit+"%'";
                System.out.println(query);

        status = config.eksekusiQuery(query, true);
        if (status) {
            rsCariBuku = config.getRs();
            cariSemuaBuku = new ArrayList<SearchModel>();
            try {
                while(rsCariBuku.next()){
                    SearchModel model = new SearchModel();
                    model.setIdBuku(rsCariBuku.getString("id_buku"));
                    model.setNamaBuku(rsCariBuku.getString("judul_buku"));
                    model.setKategory(rsCariBuku.getString("nama_kategori"));
                    model.setPenerbit(rsCariBuku.getString("nama_penerbit"));
                    model.setPengarang(rsCariBuku.getString("nama_pengarang"));
                    model.setThnTerbit(rsCariBuku.getString("tahun_terbit"));
                    model.setLokasi(rsCariBuku.getString("no_rak"));
                    model.setIdKategori(rsCariBuku.getString("id_kategori"));
                    model.setIdPenerbit(rsCariBuku.getString("id_penerbit"));
                    model.setIdPengarang(rsCariBuku.getString("id_pengarang"));
                    

                    cariSemuaBuku.add(model);
                }
                System.out.println(cariSemuaBuku);
                rsCariBuku.close();
                return cariSemuaBuku;
            } catch (Exception e) {
                System.out.println("Gagal mendapatkan data");
            }
            
        }else{
            System.out.println("Ada masalah di query");
        }
        
       return null;
    }
}

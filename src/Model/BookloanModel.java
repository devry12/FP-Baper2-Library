/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.db;
import View.Public_Storage;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Devry Kawiryan
 */
public class BookloanModel {
    private db config;
    private String bookId;
    private String bookName;
    private String Status;
    private String query;
    private boolean status;
    private List<BookloanModel> ListBook;
    
    
    public BookloanModel(){
        config = new db();
        config.getConn();
        
    }
    

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
    public boolean bookLoan(){
        try {
            
        query="INSERT INTO peminjaman (id_users, id_buku) VALUES ('"+Public_Storage.userid+"', '"+bookId+"')";
        System.out.println(query);
        status = config.eksekusiQuery(query, false);
        System.out.println("Berhasil Memasukan data");
        
        } catch (Exception e) {
            System.out.println("Gagal Memasukan data");
        }
         return status;
        
    }
    
        public boolean UpdateStatusBuku(){
            
            
        query="Update buku set status = 'dipinjam' where id_buku = '"+bookId+"'";
        System.out.println(query);
        status = config.eksekusiQuery(query, false);
         return status;
        
    }
    
    //menampilkan data pinjaman
     private ResultSet rsPinjaman;
     private List<BookloanModel> BookLoan; 
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String now  = dateFormat.format(date);
        
    public List GetBookLoan(){
        System.out.println(now);
        query = "SELECT * FROM peminjaman,buku WHERE peminjaman.id_buku = buku.id_buku AND peminjaman.id_users = "+Public_Storage.userid+" AND peminjaman.waktu_pinjam LIKE '%"+now+"%' AND status_peminjaman = 'meminjam'";
        status = config.eksekusiQuery(query, true);
        System.out.println(query);
        
        if (status) {
            rsPinjaman = config.getRs();
            ListBook = new ArrayList<BookloanModel>();
            try {
                while(rsPinjaman.next()) {
                BookloanModel model = new BookloanModel();
                model.setBookId(rsPinjaman.getString("id_buku"));
                model.setBookName(rsPinjaman.getString("judul_buku"));
                  ListBook.add(model);
                    
                }
                rsPinjaman.close();
                return ListBook;
            } catch (Exception e) {
                System.out.println("Ada Masalah Mengambil data");
            }
            
        }
        return null;
    }
    
    
    //cek status buku
    private ResultSet rsCekStatusBuku;
    public void CekStatusBuku(String idBuku){
        query = "SELECT * FROM buku WHERE id_buku = '"+idBuku+"'";
        status = config.eksekusiQuery(query, true);
        
        if (status) {
            rsCekStatusBuku = config.getRs();
            
            try {
                while (rsCekStatusBuku.next()) {
                    Public_Storage.StatusBuku = rsCekStatusBuku.getString("status");  
                }
            } catch (Exception e) {
            }
        }
    }
    
    
    //batal peminjaman
    public boolean batalPeminjaman(String idBuku){
        query = "DELETE FROM peminjaman WHERE id_buku = '"+idBuku+"'";
        System.out.println("delete = "+query);
        status = config.eksekusiQuery(query, false);
        return status;
    }
    
    public boolean updateStatusBukuAda(){
            
            
        query="Update buku set status = 'ada' where id_buku = '"+bookId+"'";
        System.out.println(query);
        status = config.eksekusiQuery(query, false);
         return status;
        
    }
    
    
    
    
    
    
    //================================= Book Return ====================================
    
    
  public List GetBookReturn(){
        System.out.println(now);
        query = "SELECT * FROM peminjaman,buku WHERE peminjaman.id_buku = buku.id_buku AND peminjaman.id_users = "+Public_Storage.userid+" AND status_peminjaman = 'meminjam'";
        status = config.eksekusiQuery(query, true);
        System.out.println(query);
        
        if (status) {
            rsPinjaman = config.getRs();
            ListBook = new ArrayList<BookloanModel>();
            try {
                while(rsPinjaman.next()) {
                BookloanModel model = new BookloanModel();
                model.setBookId(rsPinjaman.getString("id_buku"));
                model.setBookName(rsPinjaman.getString("judul_buku"));
                  ListBook.add(model);
                    
                }
                rsPinjaman.close();
                return ListBook;
            } catch (Exception e) {
                System.out.println("Ada Masalah Mengambil data");
            }
            
        }
        return null;
    }
  
  
  public boolean BookReturn(){
      	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
      query = "UPDATE peminjaman SET status_peminjaman = 'dikembalikan',tanggal_pengembalian = '"+dateFormat.format(date)+"' WHERE id_buku = '"+bookId+"'";
      System.out.println(query);
      status = config.eksekusiQuery(query, false);
      return status;
  }
  
  
    
}

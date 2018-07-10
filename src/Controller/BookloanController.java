/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BookLoan;
import View.BookReturn;
import Model.BookloanModel;
import java.util.List;

/**
 *
 * @author Devry Kawiryan
 */
public class BookloanController {
    private BookLoan view;
    private BookReturn view2;
    private BookloanModel model;

    public BookloanController(BookLoan view) {
        this.view = view;
        model = new BookloanModel();
    }

    public BookloanController(BookReturn view2) {
        this.view2 = view2;
       model = new BookloanModel();
    }
    
    public void SetBookLoan(String idBuku){
        model.setBookId(idBuku);
    }
    public boolean bookLoan(){
        return model.bookLoan();
        
    }
    
    public void upadteStatusBuku(){
        model.UpdateStatusBuku();
        
    }
    
    
    public List GetDataBuku(){
        return model.GetBookLoan();
    }
    
    public void cekStatusBuku(String idBuku){
        model.CekStatusBuku(idBuku);
    }
    
    public boolean batalPeminjaman(String idBuku){
        return model.batalPeminjaman(idBuku);
    }
    public void upadteStatusBukuAda(){
        model.updateStatusBukuAda();
        
    }
    
    public List GetBookReturn(){
        return model.GetBookReturn();
    }
    
    public boolean BookReturn(){
        return model.BookReturn();
    }
    
}

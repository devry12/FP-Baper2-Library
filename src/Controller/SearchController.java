/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SearchModel;
import View.Kategoris;
import View.SearchBook;
import View.AdminPanel;
import View.Penerbit;
import View.Pengarang;
import java.util.List;


/**
 *
 * @author Devry Kawiryan
 */
public class SearchController {
    private SearchBook view;
    private AdminPanel view2;
    private Kategoris view3;
    private Penerbit view4;
    private Pengarang view5;
    private SearchModel model;
    

    public SearchController(SearchBook view) {
        this.view = view;
        model = new SearchModel();
    }

    public SearchController(AdminPanel view2) {
        this.view2 = view2;
        model = new SearchModel();
    }

    public SearchController(Kategoris view3) {
        this.view3 = view3;
        model = new SearchModel();
    }

    public SearchController(Penerbit view4) {

        this.view4 = view4;
        model = new SearchModel();
    }

    public SearchController(Pengarang view5) {

        this.view5 = view5;
       model = new SearchModel();
    }

    
    
    
    
    public List listKat(){
        return model.categori();
    }    
    public List listpengarang(){
        return model.pengarang();
    }
    public List listpenerbit(){
        return model.penerbit();
    }
    
    public void setDataCari(String namaBuku,String pengarang,String penerbit,String kategori,String tahun){
        model.setNamaBuku(namaBuku);
        model.setKategory(kategori);
        model.setPengarang(pengarang);
        model.setPenerbit(penerbit);
        model.setThnTerbit(penerbit);
    }
    
    public List cariBuku(String namaBuku,String pengarang,String penerbit,String kategori,String tahun){
        System.out.println(model.caribuku(namaBuku,pengarang,penerbit,kategori,tahun));
        return model.caribuku(namaBuku,pengarang,penerbit,kategori,tahun);
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SearchModel;
import View.SearchBook;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Devry Kawiryan
 */
public class SearchController {
    private SearchBook view;
    private SearchModel model;

    public SearchController(SearchBook view) {
        this.view = view;
        model = new SearchModel();
    }
    
    public ResultSet Category() throws SQLException{
        return model.categori();
    }
    
    
}
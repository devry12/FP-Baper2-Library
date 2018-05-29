/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Devry Kawiryan
 */
@Entity
@Table(name = "kategori", catalog = "library", schema = "")
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k")
    , @NamedQuery(name = "Kategori.findByIdKategori", query = "SELECT k FROM Kategori k WHERE k.idKategori = :idKategori")
    , @NamedQuery(name = "Kategori.findByNamaKategori", query = "SELECT k FROM Kategori k WHERE k.namaKategori = :namaKategori")})
public class Kategori implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kategori")
    private Integer idKategori;
    @Basic(optional = false)
    @Column(name = "nama_kategori")
    private String namaKategori;

    public Kategori() {
    }

    public Kategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public Kategori(Integer idKategori, String namaKategori) {
        this.idKategori = idKategori;
        this.namaKategori = namaKategori;
    }

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        Integer oldIdKategori = this.idKategori;
        this.idKategori = idKategori;
        changeSupport.firePropertyChange("idKategori", oldIdKategori, idKategori);
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        String oldNamaKategori = this.namaKategori;
        this.namaKategori = namaKategori;
        changeSupport.firePropertyChange("namaKategori", oldNamaKategori, namaKategori);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKategori != null ? idKategori.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.idKategori == null && other.idKategori != null) || (this.idKategori != null && !this.idKategori.equals(other.idKategori))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Kategori[ idKategori=" + idKategori + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

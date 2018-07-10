/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminController;
import Controller.SearchController;
import Model.SearchModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Devry Kawiryan
 */
public class AdminPanel extends javax.swing.JFrame {
    private SearchController control;
    private AdminController control2;
    private String proses;
    private List<SearchModel> listcat;
    private List<SearchModel> listCariBuku;
    private List<SearchModel> listpengarang;
    private List<SearchModel> listpenerbits;
    private DefaultTableModel dtm;
    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        proses = "";
        initComponents();
        control = new SearchController(this);
        control2 = new AdminController(this);
        tampcat();
        tamppengarang();
        tamppenerbit();
        tamTahun();
        
        //bagian Cari dan edit
        tampcatCari();
        tamppengarangCari();
        tamppenerbitCari();
        tamTahunCari();
        RefreshBuku();
        
    }

    public void RefreshBuku(){
        
    String namaBuku,kategori,pengarang,penerbit,tahunTerbit;
        namaBuku    = txtJudulCari.getText();
        kategori    = cmbKategoriCari.getSelectedItem().toString();
        pengarang   = cmbPengarangCari.getSelectedItem().toString();
        penerbit    = cmbPenerbitCari.getSelectedItem().toString();
        tahunTerbit = cmbTahunTerbitCari.getSelectedItem().toString();
        
        if (!kategori.equals("")) {
            kategori = kategori.substring(2,kategori.length());
        }
        
        if (!pengarang.equals("")) {
            pengarang = pengarang.substring(2,pengarang.length());
        }
        
        if (!penerbit.equals("")) {
            penerbit = penerbit.substring(2,pengarang.length());
        }
        System.out.println(proses);
        System.out.println(namaBuku+"-"+kategori+"-"+pengarang+"-"+penerbit+"-"+tahunTerbit);
        if (proses.equalsIgnoreCase("")) {
            listCariBuku = control.cariBuku("", "", "", "", "");
            System.out.println("kosong jalan");
        }else if (proses.equals("Cari")) {
            listCariBuku = control.cariBuku(namaBuku, pengarang, penerbit, kategori, tahunTerbit);
            System.out.println("isi jalan");
        }
        
        dtm = (DefaultTableModel) listBuku.getModel(); 
        dtm.setRowCount(0);
        
        System.out.println(listCariBuku);
        for(SearchModel data : listCariBuku){
            dtm.addRow(new Object[]{
                data.getIdBuku(),
                data.getNamaBuku(),
                data.getKategory(),
                data.getPenerbit(),
                data.getPengarang(),
                data.getThnTerbit(),
                data.getLokasi()

            });
        }
    }
    
    
    public void tamTahun(){
        cmbTahunTerbit.removeAllItems();
        cmbTahunTerbit.addItem("");
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
	Date date = new Date();
        System.out.println(date);
        int now = Integer.parseInt(dateFormat.format(date));
        for (int i = now; i >= 1980 ; i--) {
            cmbTahunTerbit.addItem(""+i);
        }
    }
    
    public void tampcat(){
        listcat = control.listKat();
        cmbKategori.removeAllItems();
        cmbKategori.addItem("");
        for (SearchModel data : listcat) {
            cmbKategori.addItem(data.getId_kategori()+"-"+data.getNamaKategori());
        }
    }
    public void tamppengarang(){
        listpengarang = control.listpengarang();
        cmbPengarang.removeAllItems();
        cmbPengarang.addItem("");
        for (SearchModel data : listpengarang) {
            cmbPengarang.addItem(data.getIdpengarang()+"-"+data.getNamaPengarang());
        }
    }
    
    public void tamppenerbit(){
        listpenerbits = control.listpenerbit();
        cmbPenerbit.removeAllItems();
        cmbPenerbit.addItem("");
        for (SearchModel data : listpenerbits) {
            cmbPenerbit.addItem(data.getIdpenerbit()+"-"+data.getNamapenerbit());
        }
    }
    
    
    public void tamTahunCari(){
        cmbTahunTerbitCari.removeAllItems();
        cmbTahunTerbitCari.addItem("");
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
	Date date = new Date();
        System.out.println(date);
        int now = Integer.parseInt(dateFormat.format(date));
        for (int i = now; i >= 1980 ; i--) {
            cmbTahunTerbitCari.addItem(""+i);
        }
    }
    
    public void tampcatCari(){
        listcat = control.listKat();
        cmbKategoriCari.removeAllItems();
        cmbKategoriCari.addItem("");
        for (SearchModel data : listcat) {
            cmbKategoriCari.addItem(data.getId_kategori()+"-"+data.getNamaKategori());
        }
    }
    public void tamppengarangCari(){
        listpengarang = control.listpengarang();
        cmbPengarangCari.removeAllItems();
        cmbPengarangCari.addItem("");
        for (SearchModel data : listpengarang) {
            cmbPengarangCari.addItem(data.getIdpengarang()+"-"+data.getNamaPengarang());
        }
    }
    
    public void tamppenerbitCari(){
        listpenerbits = control.listpenerbit();
        cmbPenerbitCari.removeAllItems();
        cmbPenerbitCari.addItem("");
        for (SearchModel data : listpenerbits) {
            cmbPenerbitCari.addItem(data.getIdpenerbit()+"-"+data.getNamapenerbit());
        }
       
    }
    
       public void resetform(){
            txtJudul.setText("");
            cmbKategori.setSelectedItem("");            
            cmbPenerbit.setSelectedItem("");
            cmbPengarang.setSelectedItem("");
            cmbTahunTerbit.setSelectedItem("");
            cmbNorak.setSelectedItem("");
            
            txtJudulCari.setText("");
            txtIdBuku.setText("");
            cmbKategoriCari.setSelectedItem("");            
            cmbPenerbitCari.setSelectedItem("");
            cmbPengarangCari.setSelectedItem("");
            cmbTahunTerbitCari.setSelectedItem("");
            cmbNorakCari.setSelectedItem("");

        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox<>();
        cmbPenerbit = new javax.swing.JComboBox<>();
        cmbPengarang = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        cmbTahunTerbit = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbNorak = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBuku = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtJudulCari = new javax.swing.JTextField();
        cmbKategoriCari = new javax.swing.JComboBox<>();
        cmbPenerbitCari = new javax.swing.JComboBox<>();
        cmbPengarangCari = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        cmbTahunTerbitCari = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbNorakCari = new javax.swing.JComboBox<>();
        txtIdBuku = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAddKategori = new javax.swing.JMenuItem();
        menuAddPengarang = new javax.swing.JMenuItem();
        menuAddPenerbit = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("Judul");

        jLabel2.setText("Kategori");

        jLabel3.setText("Penerbit");

        jLabel4.setText("Pengarang");

        jLabel5.setText("Tahun Terbit");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");

        jLabel6.setText("No Rak");

        cmbNorak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJudul)
                            .addComponent(cmbTahunTerbit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNorak, 0, 173, Short.MAX_VALUE)
                            .addComponent(cmbPenerbit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPengarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah)
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbNorak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        listBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Buku", "Judul", "Kategori", "Penerbit", "Pengarang", "Tahun Terbit", "No Rak"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listBuku);
        if (listBuku.getColumnModel().getColumnCount() > 0) {
            listBuku.getColumnModel().getColumn(0).setResizable(false);
            listBuku.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel7.setText("Judul");

        jLabel8.setText("Kategori");

        jLabel9.setText("Penerbit");

        jLabel10.setText("Pengarang");

        jLabel11.setText("Tahun Terbit");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel12.setText("No Rak");

        cmbNorakCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", " " }));

        txtIdBuku.setEditable(false);
        txtIdBuku.setEnabled(false);

        jLabel13.setText("Id Buku'");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdBuku)
                            .addComponent(cmbPengarangCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTahunTerbitCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNorakCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPenerbitCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJudulCari)
                            .addComponent(cmbKategoriCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtJudulCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbKategoriCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbPenerbitCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbPengarangCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbTahunTerbitCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbNorakCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnEdit)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        jMenu2.setText("File");

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu2.add(menuLogout);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Add");

        menuAddKategori.setText("Kategori");
        menuAddKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddKategoriActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddKategori);

        menuAddPengarang.setText("Pengarang");
        menuAddPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddPengarangActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddPengarang);

        menuAddPenerbit.setText("Penerbit");
        menuAddPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddPenerbitActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddPenerbit);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
        Public_Storage.userid = "";
        Public_Storage.NamaLengkap = "";
        Public_Storage.GetRowProfile = "";
        Public_Storage.NoTlp = "";
        Public_Storage.Status = "";
        Public_Storage.username = "";
        Public_Storage.StatusBuku = "";


        Login form = new Login();
        form.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        proses = "Cari";
       RefreshBuku();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        String namaBuku,kategori,pengarang,penerbit,tahunTerbit,noRak;
        namaBuku    = txtJudul.getText();
        kategori    = cmbKategori.getSelectedItem().toString();
        pengarang   = cmbPengarang.getSelectedItem().toString();
        penerbit    = cmbPenerbit.getSelectedItem().toString();
        tahunTerbit = cmbTahunTerbit.getSelectedItem().toString();
        noRak       = cmbNorak.getSelectedItem().toString();
        
        if (!kategori.equals("")) {
            kategori = kategori.substring(0,1);
        }
        
        if (!pengarang.equals("")) {
            pengarang = pengarang.substring(0,1);
        }
        
        if (!penerbit.equals("")) {
            penerbit = penerbit.substring(0,1);
        }
        
         JFrame parent = new JFrame();
        boolean status = control2.insertDataBuku(namaBuku, kategori, pengarang, penerbit, tahunTerbit, noRak);
        if (status) {
            JOptionPane.showMessageDialog(parent,"Data buku berhasil di tambahkan");
            resetform();
            RefreshBuku();
        }else{
            JOptionPane.showMessageDialog(parent, "Ada masalah saat menambah data","Buku",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void listBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBukuMouseClicked
        // TODO add your handling code here:
        int row = listBuku.getSelectedRow();
        String idbuku, namaBuku,kategori,penerbit,pengarang,tahun_terbit,noRak;
        idbuku          = listBuku.getValueAt(row, 0).toString(); 
        control2.SelectDataEditBuku(idbuku);
        namaBuku        = listBuku.getValueAt(row, 1).toString();        
        kategori        = listBuku.getValueAt(row, 2).toString();
        penerbit        = listBuku.getValueAt(row, 3).toString();
        pengarang       = listBuku.getValueAt(row, 4).toString();
        tahun_terbit    = listBuku.getValueAt(row, 5).toString();
        noRak           = listBuku.getValueAt(row, 6).toString();
        
        
        cmbKategoriCari.setSelectedItem(Public_Storage.kategori+"-"+kategori);
        cmbPenerbitCari.setSelectedItem(Public_Storage.penerbit+"-"+penerbit);
        cmbPengarangCari.setSelectedItem(Public_Storage.pengarang+"-"+pengarang);
        cmbTahunTerbitCari.setSelectedItem(tahun_terbit);
        cmbNorakCari.setSelectedItem(noRak);
        
            
        txtJudulCari.setText(namaBuku);
        txtIdBuku.setText(idbuku);
        

    }//GEN-LAST:event_listBukuMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String idBuku,namaBuku,kategori,pengarang,penerbit,tahunTerbit,noRak;
        namaBuku    = txtJudulCari.getText();
        idBuku      = txtIdBuku.getText();
        kategori    = cmbKategoriCari.getSelectedItem().toString();
        pengarang   = cmbPengarangCari.getSelectedItem().toString();
        penerbit    = cmbPenerbitCari.getSelectedItem().toString();
        tahunTerbit = cmbTahunTerbitCari.getSelectedItem().toString();
        noRak       = cmbNorakCari.getSelectedItem().toString();
        System.out.println(noRak);
        
        if (!kategori.equals("")) {
            kategori = kategori.substring(0,1);
        }
        
        if (!pengarang.equals("")) {
            pengarang = pengarang.substring(0,1);
        }
        
        if (!penerbit.equals("")) {
            penerbit = penerbit.substring(0,1);
        }
        
         JFrame parent = new JFrame();
        boolean status = control2.UpdateDataBuku(idBuku, namaBuku, kategori, pengarang, penerbit, tahunTerbit, noRak);
        if (status) {
            JOptionPane.showMessageDialog(parent,"Data buku berhasil di di Edit");
            resetform();
            RefreshBuku();
        }else{
            JOptionPane.showMessageDialog(parent, "Ada masalah saat mengedit data","Buku",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetform();
    }//GEN-LAST:event_btnResetActionPerformed

    private void menuAddKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddKategoriActionPerformed
        // TODO add your handling code here:
        Kategoris form = new Kategoris();
        form.setVisible(true);
    }//GEN-LAST:event_menuAddKategoriActionPerformed

    private void menuAddPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddPengarangActionPerformed
        // TODO add your handling code here:
        Pengarang form = new Pengarang();
        form.setVisible(true);
    }//GEN-LAST:event_menuAddPengarangActionPerformed

    private void menuAddPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddPenerbitActionPerformed
        // TODO add your handling code here:
        Penerbit form = new Penerbit();
        form.setVisible(true);
    }//GEN-LAST:event_menuAddPenerbitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbKategoriCari;
    private javax.swing.JComboBox<String> cmbNorak;
    private javax.swing.JComboBox<String> cmbNorakCari;
    private javax.swing.JComboBox<String> cmbPenerbit;
    private javax.swing.JComboBox<String> cmbPenerbitCari;
    private javax.swing.JComboBox<String> cmbPengarang;
    private javax.swing.JComboBox<String> cmbPengarangCari;
    private javax.swing.JComboBox<String> cmbTahunTerbit;
    private javax.swing.JComboBox<String> cmbTahunTerbitCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listBuku;
    private javax.swing.JMenuItem menuAddKategori;
    private javax.swing.JMenuItem menuAddPenerbit;
    private javax.swing.JMenuItem menuAddPengarang;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtJudulCari;
    // End of variables declaration//GEN-END:variables
}

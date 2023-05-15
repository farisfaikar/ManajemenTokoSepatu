/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOBarang;
import Helper.KoneksiDB;
import Model.Barang;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Faris Faikar <farisfaikar.r@gmail.com>
 */
public class DAOBarang implements IDAOBarang {

    public DAOBarang() {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public List<Barang> getAll() {
        List<Barang> listBarang = null;
        try {
            listBarang = new ArrayList<Barang>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next()) {
                Barang barang = new Barang();
                barang.setId_barang(rs.getInt("id_barang"));
                barang.setNama_barang(rs.getString("nama_barang"));
                barang.setHarga(rs.getInt("harga"));
                barang.setStok(rs.getInt("stok"));
                barang.setPendapatan(rs.getInt("pendapatan"));
                barang.setKeterangan(rs.getString("keterangan"));
                listBarang.add(barang);
                
            }
            
        } catch(SQLException e) {
            
        }
        return listBarang;
    }
    
    Connection con;
    
    // SQL Query
    String strRead = "select * from tabel_barang;";
}

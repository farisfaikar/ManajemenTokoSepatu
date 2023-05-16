/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOBarang;
import Helper.KoneksiDB;
import Model.Barang;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    @Override
    public boolean insert(Barang barang) {
        boolean result = true;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, barang.getId_barang());
            statement.setString(2, barang.getNama_barang());
            statement.setInt(3, barang.getHarga());
            statement.setInt(4, barang.getStok());
            statement.setInt(5, barang.getPendapatan());
            statement.setString(6, barang.getKeterangan());
            statement.execute();
            System.out.println("Berhasil insert");
        } catch(SQLException e) {
            System.out.println("Gagal insert");
            result = false;
        }
        finally {
            try {
                statement.close();
                System.out.println("Berhasil close");
            } catch(SQLException ex) {
                System.out.println("Gagal close");
                result = false;
            }
        }
        return result;
    }
    
    @Override
    public void update(Barang barang) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, barang.getNama_barang());
            statement.setInt(2, barang.getHarga());
            statement.setInt(3, barang.getStok());
            statement.setInt(4, barang.getPendapatan());
            statement.setString(5, barang.getKeterangan());
            statement.setInt(6, barang.getId_barang());
            statement.execute();
            System.out.println("Berhasil update");
        } catch(SQLException e) {
            System.out.println("Gagal update");
        }
        finally {
            try {
                statement.close();
                System.out.println("Berhasil close");
            } catch(SQLException ex) {
                System.out.println("Gagal close");
            }
        }
    }
    
    Connection con;
    
    // SQL Query
    String strRead = "select * from tabel_barang;";
    String strInsert = "insert into tabel_barang (id_barang, nama_barang, harga, stok, pendapatan, keterangan) values (?, ?, ?, ?, ?, ?);";
    String strUpdate = "update tabel_barang set nama_barang=?, harga=?, stok=?, pendapatan=?, keterangan=? where id_barang=?;";
}

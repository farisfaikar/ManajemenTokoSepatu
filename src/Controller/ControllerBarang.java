/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAOInterface.IDAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormBarang;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Faris Faikar <farisfaikar.r@gmail.com>
 */
public class ControllerBarang {
    
    public ControllerBarang(FormBarang formBarang) {
        this.formBarang = formBarang;
        iBarang = new DAOBarang();
    }
    
    public void isiTable() {
        listBarang = iBarang.getAll();
        TabelModelBarang tabelBarang = new TabelModelBarang(listBarang);
        formBarang.getTabelData().setModel(tabelBarang);
    }
    
    public void insert() {
        Barang barang = new Barang();
        barang.setId_barang(Integer.valueOf(formBarang.getIdBarangTextField().getText()));
        barang.setNama_barang(String.valueOf(formBarang.getNamaBarangTextField().getText()));
        barang.setHarga(Integer.valueOf(formBarang.getHargaTextField().getText()));
        barang.setStok(Integer.valueOf(formBarang.getStokTextField().getText()));
        barang.setPendapatan(Integer.valueOf(formBarang.getPendapatanTextField().getText()));
        barang.setKeterangan(String.valueOf(formBarang.getKeteranganTextArea().getText()));
        
        boolean result = iBarang.insert(barang);
        if(result) 
            JOptionPane.showConfirmDialog(null, "Input berhasil");
        else
            JOptionPane.showMessageDialog(null, "Gagal/Data duplikat");
    }
    
    public void reset() {
        if (!formBarang.getIdBarangTextField().isEnabled())
            formBarang.getIdBarangTextField().setEnabled(true);
        formBarang.getIdBarangTextField().setText("");
        formBarang.getNamaBarangTextField().setText("");
        formBarang.getHargaTextField().setText("");
        formBarang.getStokTextField().setText("");
        formBarang.getPendapatanTextField().setText("");
        formBarang.getKeteranganTextArea().setText("");
    }
    
    public void isiField(int row) {
        formBarang.getIdBarangTextField().setEnabled(false);
        formBarang.getIdBarangTextField().setText(String.valueOf(listBarang.get(row).getId_barang()));
        formBarang.getNamaBarangTextField().setText(String.valueOf(listBarang.get(row).getNama_barang()));
        formBarang.getHargaTextField().setText(String.valueOf(listBarang.get(row).getHarga()));
        formBarang.getStokTextField().setText(String.valueOf(listBarang.get(row).getStok()));
        formBarang.getPendapatanTextField().setText(String.valueOf(listBarang.get(row).getPendapatan()));
        formBarang.getKeteranganTextArea().setText(String.valueOf(listBarang.get(row).getStok()));
    }
    
    public void update() {
        Barang barang = new Barang();
        barang.setNama_barang(String.valueOf(formBarang.getNamaBarangTextField().getText()));
        barang.setHarga(Integer.valueOf(formBarang.getHargaTextField().getText()));
        barang.setStok(Integer.valueOf(formBarang.getStokTextField().getText()));
        barang.setPendapatan(Integer.valueOf(formBarang.getPendapatanTextField().getText()));
        barang.setKeterangan(String.valueOf(formBarang.getKeteranganTextArea().getText()));
        barang.setId_barang(Integer.valueOf(formBarang.getIdBarangTextField().getText()));
        iBarang.update(barang);
        JOptionPane.showConfirmDialog(null, "Update berhasil");
    }
    
    public void delete() {
        Barang barang = new Barang();
        iBarang.delete(Integer.parseInt(formBarang.getIdBarangTextField().getText()));
        JOptionPane.showConfirmDialog(null, "Delete berhasil");
    }
    
    IDAOBarang iBarang;
    FormBarang formBarang;
    List<Barang> listBarang;
}

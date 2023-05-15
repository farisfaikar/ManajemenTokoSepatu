/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Faris Faikar <farisfaikar.r@gmail.com>
 */
public class TabelModelBarang extends AbstractTableModel {
    
    public TabelModelBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }
    
    @Override
    public int getRowCount() {
        return this.listBarang.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID Barang";
            case 1 -> "Nama Barang";
            case 2 -> "Harga";
            case 3 -> "Stok";
            case 4 -> "Pendapatan";
            case 5 -> "Keterangan";
            default -> null;
        }; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> listBarang.get(rowIndex).getId_barang();
            case 1 -> listBarang.get(rowIndex).getNama_barang();
            case 2 -> listBarang.get(rowIndex).getHarga();
            case 3 -> listBarang.get(rowIndex).getStok();
            case 4 -> listBarang.get(rowIndex).getPendapatan();
            case 5 -> listBarang.get(rowIndex).getKeterangan();
            default -> null;
        }; 
    }
    
    List<Barang> listBarang;
}

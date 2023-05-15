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
    
    IDAOBarang iBarang;
    FormBarang formBarang;
    List<Barang> listBarang;
}

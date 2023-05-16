/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Barang;
import java.util.List;

/**
 *
 * @author Faris Faikar <farisfaikar.r@gmail.com>
 */
public interface IDAOBarang {
    // Read data
    public List<Barang> getAll();
    // Insert data
    public boolean insert(Barang barang);
    // Update data
    public void update(Barang barang);
    
}

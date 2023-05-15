/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Faris Faikar <farisfaikar.r@gmail.com>
 */
public class KoneksiDB {
    static Connection con;
    
    public static Connection getConnection(){
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_toko_sepatu");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("Koneksi berhasil, yaay :).");
            } catch(SQLException e) {
                System.out.println("Koneksi gagal, uh bad :(.");
            }
        }
        return con;
    }
}

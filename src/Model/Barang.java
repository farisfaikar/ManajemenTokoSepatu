/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Faris Faikar <farisfaikar.r@gmail.com>
 */
public class Barang {

    /**
     * @return the id_barang
     */
    public Integer getId_barang() {
        return id_barang;
    }

    /**
     * @param id_barang the id_barang to set
     */
    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }

    /**
     * @return the nama_barang
     */
    public String getNama_barang() {
        return nama_barang;
    }

    /**
     * @param nama_barang the nama_barang to set
     */
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    /**
     * @return the harga
     */
    public Integer getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    /**
     * @return the stok
     */
    public Integer getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(Integer stok) {
        this.stok = stok;
    }

    /**
     * @return the pendapatan
     */
    public Integer getPendapatan() {
        return pendapatan;
    }

    /**
     * @param pendapatan the pendapatan to set
     */
    public void setPendapatan(Integer pendapatan) {
        this.pendapatan = pendapatan;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    private Integer id_barang;
    private String nama_barang;
    private Integer harga;
    private Integer stok;
    private Integer pendapatan;
    private String keterangan;
            
    /* Table Attributes
    - id_barang: INT(4) [Primary Key]
    - nama_barang: VARCHAR(255) {contoh: Nike Court Low Vision}
    - harga: INT(10)
    - stok: INT(4)
    - pendapatan: INT(10) {harga x stok}
    - keterangan: TEXT {contoh: White Ukuran 43}
    */
}

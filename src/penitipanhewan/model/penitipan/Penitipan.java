package penitipanhewan.model.penitipan;

import java.util.Date;

public class Penitipan {
    
    private Long id;
    private Long idPaket;
    private Long idPelanggan;
    private Long jumlah;
    private Long jam;
    private Date tanggal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(Long idPaket) {
        this.idPaket = idPaket;
    }

    public Long getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(Long idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public Long getJam() {
        return jam;
    }

    public void setJam(Long jam) {
        this.jam = jam;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Penitipan{" + "id=" + id + ", idPaket=" + idPaket + ", idPelanggan=" + idPelanggan + ", jumlah=" + jumlah + ", jam=" + jam + ", tanggal=" + tanggal + '}';
    }
    
}

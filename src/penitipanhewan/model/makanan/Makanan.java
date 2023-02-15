package penitipanhewan.model.makanan;

public class Makanan {

    private String id;
    private String nama;
    private Long harga;
    private String merek;
    private String jenis;
    private Long ukuran;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Long getUkuran() {
        return ukuran;
    }

    public void setUkuran(Long ukuran) {
        this.ukuran = ukuran;
    }

}

package penitipanhewan.model.makanan;

public class Makanan {
    
    private Long id;
    private String nama;
    private Long harga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Makanan{" + "id=" + id + ", nama=" + nama + ", harga=" + harga + '}';
    }
    
}

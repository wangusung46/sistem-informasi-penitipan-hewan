package penitipanhewan.model.hewan;

public class Hewan {
    
    private String id;
    private String jenis;
    private String ukuran;
    private Long harga;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Hewan{" + "id=" + id + ", jenis=" + jenis + ", ukuran=" + ukuran + ", harga=" + harga + '}';
    }
    
}

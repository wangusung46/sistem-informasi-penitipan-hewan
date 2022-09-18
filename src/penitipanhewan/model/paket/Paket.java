package penitipanhewan.model.paket;

public class Paket {

    private Long id;
    private Long idHewan;
    private Long idMakanan;
    private String nama;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(Long idHewan) {
        this.idHewan = idHewan;
    }

    public Long getIdMakanan() {
        return idMakanan;
    }

    public void setIdMakanan(Long idMakanan) {
        this.idMakanan = idMakanan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paket{");
        sb.append("id=").append(id);
        sb.append(", idHewan=").append(idHewan);
        sb.append(", idMakanan=").append(idMakanan);
        sb.append(", nama=").append(nama);
        sb.append('}');
        return sb.toString();
    }

}

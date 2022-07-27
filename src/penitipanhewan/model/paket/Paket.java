package penitipanhewan.model.paket;

public class Paket {
    
    private Long id;
    private Long idHewan;
    private Long idMakanan;

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

    @Override
    public String toString() {
        return "Paket{" + "id=" + id + ", idHewan=" + idHewan + ", idMakanan=" + idMakanan + '}';
    }
    
}

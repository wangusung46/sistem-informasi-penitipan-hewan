package penitipanhewan.model.paket;

import java.util.List;

public interface PaketJdbc {

    public List<Paket> selectAll();
    
    public Paket select(Long request);

    public void insert(Paket request);

    public void update(Paket request);
    
    public void delete(Long request);

    public Long selectHarga(Long parseLong);

}

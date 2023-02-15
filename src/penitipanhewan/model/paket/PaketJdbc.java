package penitipanhewan.model.paket;

import java.util.List;

public interface PaketJdbc {

    public List<Paket> selectAll();
    
    public Paket select(String request);

    public void insert(Paket request);

    public void update(Paket request);
    
    public void delete(String request);

    public Long selectHarga(String parseLong);

}

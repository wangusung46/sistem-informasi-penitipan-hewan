package penitipanhewan.model.pelanggan;

import java.util.List;

public interface PelangganJdbc {

    public List<Pelanggan> selectAll();
    
    public Pelanggan select(String request);

    public void insert(Pelanggan request);

    public void update(Pelanggan request);
    
    public void delete(String request);

}

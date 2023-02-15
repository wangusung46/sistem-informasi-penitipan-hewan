package penitipanhewan.model.makanan;

import java.util.List;

public interface MakananJdbc {

    public List<Makanan> selectAll();
    
    public Makanan select(String request);

    public void insert(Makanan request);

    public void update(Makanan request);
    
    public void delete(String request);

}

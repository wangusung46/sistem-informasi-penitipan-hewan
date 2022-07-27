package penitipanhewan.model.makanan;

import java.util.List;

public interface MakananJdbc {

    public List<Makanan> selectAll();
    
    public Makanan select(Long request);

    public void insert(Makanan request);

    public void update(Makanan request);
    
    public void delete(Long request);

}

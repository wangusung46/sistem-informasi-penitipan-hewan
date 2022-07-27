package penitipanhewan.model.hewan;

import java.util.List;

public interface HewanJdbc {

    public List<Hewan> selectAll();
    
    public Hewan select(Long request);

    public void insert(Hewan request);

    public void update(Hewan request);
    
    public void delete(Long request);

}

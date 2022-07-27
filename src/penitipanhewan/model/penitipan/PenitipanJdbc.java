package penitipanhewan.model.penitipan;

import java.util.List;

public interface PenitipanJdbc {

    public List<Penitipan> selectAll();
    
    public Penitipan select(Long request);

    public void insert(Penitipan request);

    public void update(Penitipan request);
    
    public void delete(Long request);

}

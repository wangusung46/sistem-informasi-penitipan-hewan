package penitipanhewan.model.admin;

public interface AdminJdbc {
    
    public Boolean login(String userName, String password);

    public void insert(Admin request);

    public String selectRole(String text);
    
}

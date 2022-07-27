package penitipanhewan.model.makanan;

import koneksi.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class MakananJdbcImplement implements MakananJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;
    private static final Logger logger = Logger.getLogger(MakananJdbcImplement.class);

    public MakananJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Makanan> selectAll() {
        List<Makanan> response = new ArrayList<>();
        try {
            sql = "SELECT * FROM makanan;";
            preparedStatement = connection.prepareStatement(sql);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Makanan makanan = new Makanan();
                makanan.setId(resultSet.getLong("id"));             
                makanan.setNama(resultSet.getString("nama"));               
                makanan.setHarga(resultSet.getLong("harga"));                
                response.add(makanan);
            }
            resultSet.close();
            preparedStatement.close();
            logger.debug(response.toString());
            return response;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
            return null;
        }
    }
    
    @Override
    public Makanan select(Long request) {
        logger.debug(request.toString());
        Makanan response = new Makanan();
        try {
            sql = "select * from makanan where id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, request);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                response.setId(resultSet.getLong("id"));               
                response.setNama(resultSet.getString("nama"));         
                response.setHarga(resultSet.getLong("harga"));
            }
            logger.debug(response.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public void insert(Makanan request) {
        logger.debug(request.toString());
        try {
            sql = "INSERT INTO makanan (nama, harga) VALUES(?, ?);";
            preparedStatement = connection.prepareStatement(sql);          
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setLong(2, request.getHarga());           
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Makanan request) {
        logger.debug(request.toString());
        try {
            sql = "UPDATE makanan SET nama=?, harga=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());                       
            preparedStatement.setLong(2, request.getHarga());
            preparedStatement.setLong(3, request.getId());
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Long request) {
        logger.debug(request.toString());
        try {
            sql = "DELETE FROM makanan WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, request);
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

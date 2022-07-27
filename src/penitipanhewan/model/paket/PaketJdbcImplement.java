package penitipanhewan.model.paket;

import koneksi.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class PaketJdbcImplement implements PaketJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;
    private static final Logger logger = Logger.getLogger(PaketJdbcImplement.class);

    public PaketJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Paket> selectAll() {
        List<Paket> response = new ArrayList<>();
        try {
            sql = "SELECT * FROM paket;";
            preparedStatement = connection.prepareStatement(sql);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Paket paket = new Paket();
                paket.setId(resultSet.getLong("id"));             
                paket.setIdHewan(resultSet.getLong("id_hewan"));               
                paket.setIdMakanan(resultSet.getLong("id_makanan"));                
                response.add(paket);
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
    public Paket select(Long request) {
        logger.debug(request.toString());
        Paket response = new Paket();
        try {
            sql = "select * from paket where id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, request);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                response.setId(resultSet.getLong("id"));               
                response.setIdHewan(resultSet.getLong("id_hewan"));         
                response.setIdMakanan(resultSet.getLong("id_makanan"));
            }
            logger.debug(response.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public void insert(Paket request) {
        logger.debug(request.toString());
        try {
            sql = "INSERT INTO paket (id_hewan, id_makanan) VALUES(?, ?);";
            preparedStatement = connection.prepareStatement(sql);          
            preparedStatement.setLong(1, request.getIdHewan());
            preparedStatement.setLong(2, request.getIdMakanan());           
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Paket request) {
        logger.debug(request.toString());
        try {
            sql = "UPDATE paket SET id_hewan=?, id_makanan=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, request.getIdHewan());                       
            preparedStatement.setLong(2, request.getIdMakanan());
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
            sql = "DELETE FROM paket WHERE id=?;";
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

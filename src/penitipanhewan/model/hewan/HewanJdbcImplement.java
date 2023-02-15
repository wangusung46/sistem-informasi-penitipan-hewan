package penitipanhewan.model.hewan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.Conn;
import org.apache.log4j.Logger;

public class HewanJdbcImplement implements HewanJdbc {

    private static Connection connection;
    private static final Logger logger = Logger.getLogger(HewanJdbcImplement.class);
    private static final String ID = "H";
    private static final String FORMAT = "%05d";
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public HewanJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Hewan> selectAll() {
        List<Hewan> response = new ArrayList<>();
        try {
            sql = "SELECT * FROM hewan;";
            preparedStatement = connection.prepareStatement(sql);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hewan hewan = new Hewan();
                hewan.setId(ID + String.format(FORMAT, resultSet.getLong("id")));
                hewan.setJenis(resultSet.getString("jenis"));
                hewan.setUkuran(resultSet.getString("ukuran"));
                hewan.setHarga(resultSet.getLong("harga"));
                response.add(hewan);
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
    public Hewan select(String request) {
        logger.debug(request);
        Hewan response = new Hewan();
        try {
            sql = "select * from hewan where id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            if (request.substring(0, 1).equals(ID)) {
                preparedStatement.setLong(1, Long.parseLong(request.substring(1)));
            } else {
                preparedStatement.setLong(1, Long.parseLong(request));
            }
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                response.setId(ID + String.format(FORMAT, resultSet.getLong("id")));
                response.setJenis(resultSet.getString("jenis"));
                response.setUkuran(resultSet.getString("ukuran"));
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
    public void insert(Hewan request) {
        logger.debug(request.toString());
        try {
            sql = "INSERT INTO hewan (jenis, ukuran, harga) VALUES(?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getJenis());
            preparedStatement.setString(2, request.getUkuran());
            preparedStatement.setLong(3, request.getHarga());
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Hewan request) {
        logger.debug(request.toString());
        try {
            sql = "UPDATE hewan SET jenis=?, ukuran=?, harga=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getJenis());
            preparedStatement.setString(2, request.getUkuran());
            preparedStatement.setLong(3, request.getHarga());
            preparedStatement.setString(4, request.getId().substring(1));
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(String request) {
        logger.debug(request);
        try {
            sql = "DELETE FROM hewan WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(request.substring(1)));
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

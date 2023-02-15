package penitipanhewan.model.pelanggan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.Conn;
import org.apache.log4j.Logger;

public class PelangganJdbcImplement implements PelangganJdbc {

    private static Connection connection;
    private static final Logger logger = Logger.getLogger(PelangganJdbcImplement.class);
    private static final String ID = "U";
    private static final String FORMAT = "%05d";
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public PelangganJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Pelanggan> selectAll() {
        List<Pelanggan> response = new ArrayList<>();
        try {
            sql = "SELECT * FROM pelanggan;";
            preparedStatement = connection.prepareStatement(sql);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(ID + String.format(FORMAT, resultSet.getLong("id")));
                pelanggan.setNama(resultSet.getString("nama"));
                pelanggan.setNomorHp(resultSet.getString("nomor_hp"));
                pelanggan.setAlamat(resultSet.getString("alamat"));
                response.add(pelanggan);
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
    public Pelanggan select(String request) {
        logger.debug(request);
        Pelanggan response = new Pelanggan();
        try {
            sql = "select * from pelanggan where id = ?;";
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
                response.setNama(resultSet.getString("nama"));
                response.setNomorHp(resultSet.getString("nomor_hp"));
                response.setAlamat(resultSet.getString("alamat"));
            }
            logger.debug(response.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public void insert(Pelanggan request) {
        logger.debug(request.toString());
        try {
            sql = "INSERT INTO pelanggan (nama, nomor_hp, alamat) VALUES(?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setString(2, request.getNomorHp());
            preparedStatement.setString(3, request.getAlamat());
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Pelanggan request) {
        logger.debug(request.toString());
        try {
            sql = "UPDATE pelanggan SET nama=?, nomor_hp=?, alamat=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setString(2, request.getNomorHp());
            preparedStatement.setString(3, request.getAlamat());
            preparedStatement.setLong(4, Long.parseLong(request.getId().substring(1)));
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
            sql = "DELETE FROM pelanggan WHERE id=?;";
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

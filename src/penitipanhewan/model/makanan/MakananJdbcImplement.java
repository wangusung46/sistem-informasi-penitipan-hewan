package penitipanhewan.model.makanan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.Conn;
import org.apache.log4j.Logger;

public class MakananJdbcImplement implements MakananJdbc {

    private static Connection connection;
    private static final Logger logger = Logger.getLogger(MakananJdbcImplement.class);
    private static final String ID = "M";
    private static final String FORMAT = "%05d";
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

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
                makanan.setId(ID + String.format(FORMAT, resultSet.getLong("id")));
                makanan.setNama(resultSet.getString("nama"));
                makanan.setHarga(resultSet.getLong("harga"));
                makanan.setMerek(resultSet.getString("merek"));
                makanan.setJenis(resultSet.getString("jenis"));
                makanan.setUkuran(resultSet.getLong("ukuran"));
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
    public Makanan select(String request) {
        logger.debug(request);
        Makanan response = new Makanan();
        try {
            sql = "select * from makanan where id = ?;";
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
                response.setHarga(resultSet.getLong("harga"));
                response.setMerek(resultSet.getString("merek"));
                response.setJenis(resultSet.getString("jenis"));
                response.setUkuran(resultSet.getLong("ukuran"));
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
            sql = "INSERT INTO makanan (nama, harga, merek, jenis, ukuran) VALUES(?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setLong(2, request.getHarga());
            preparedStatement.setString(3, request.getMerek());
            preparedStatement.setString(4, request.getJenis());
            preparedStatement.setLong(5, request.getUkuran());
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
            sql = "UPDATE makanan SET nama=?, harga=?, merek=?, jenis=?, ukuran=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setLong(2, request.getHarga());
            preparedStatement.setString(3, request.getMerek());
            preparedStatement.setString(4, request.getJenis());
            preparedStatement.setLong(5, request.getUkuran());
            preparedStatement.setString(6, request.getId().substring(1));
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
            sql = "DELETE FROM makanan WHERE id=?;";
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

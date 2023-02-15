package penitipanhewan.model.paket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.Conn;
import org.apache.log4j.Logger;

public class PaketJdbcImplement implements PaketJdbc {

    private static Connection connection;
    private static final Logger logger = Logger.getLogger(PaketJdbcImplement.class);
    private static final String ID = "P";
    private static final String FORMAT = "%05d";
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

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
                paket.setId(ID + String.format(FORMAT, resultSet.getLong("id")));
                paket.setNama(resultSet.getString("nama"));
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
    public Paket select(String request) {
        logger.debug(request);
        Paket response = new Paket();
        try {
            sql = "select * from paket where id = ?;";
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
            sql = "INSERT INTO paket (nama, id_hewan, id_makanan) VALUES(?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setLong(2, request.getIdHewan());
            preparedStatement.setLong(3, request.getIdMakanan());
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
            sql = "UPDATE paket SET nama=?, id_hewan=?, id_makanan=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getNama());
            preparedStatement.setLong(2, request.getIdHewan());
            preparedStatement.setLong(3, request.getIdMakanan());
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
            sql = "DELETE FROM paket WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(request.substring(1)));
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Long selectHarga(String parseLong) {
        try {
            sql = "select b.harga + c.harga harga from paket a left join hewan b on a.id_hewan = b.id left join makanan c on a.id_makanan = c.id where a.id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(parseLong.substring(1)));
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("harga");
            }
            return 0L;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
        }
        return null;
    }

}

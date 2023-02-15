package penitipanhewan.model.penitipan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.Conn;
import org.apache.log4j.Logger;

public class PenitipanJdbcImplement implements PenitipanJdbc {

    private static Connection connection;
    private static final Logger logger = Logger.getLogger(PenitipanJdbcImplement.class);
    private static final String ID = "T";
    private static final String FORMAT = "%05d";
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public PenitipanJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Penitipan> selectAll() {
        List<Penitipan> response = new ArrayList<>();
        try {
            sql = "SELECT * FROM penitipan;";
            preparedStatement = connection.prepareStatement(sql);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Penitipan penitipan = new Penitipan();
                penitipan.setId(ID + String.format(FORMAT, resultSet.getLong("id")));
                penitipan.setIdPaket(resultSet.getLong("id_paket"));
                penitipan.setIdPelanggan(resultSet.getLong("id_pelanggan"));
                penitipan.setJumlah(resultSet.getLong("jumlah"));
                penitipan.setJam(resultSet.getLong("jam"));
                penitipan.setTanggal(resultSet.getDate("tanggal"));
                response.add(penitipan);
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
    public Penitipan select(String request) {
        logger.debug(request);
        Penitipan response = new Penitipan();
        try {
            sql = "select * from penitipan where id = ?;";
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
                response.setIdPaket(resultSet.getLong("id_paket"));
                response.setIdPelanggan(resultSet.getLong("id_pelanggan"));
                response.setJumlah(resultSet.getLong("jumlah"));
                response.setJam(resultSet.getLong("jam"));
                response.setTanggal(resultSet.getDate("tanggal"));
            }
            logger.debug(response.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public void insert(Penitipan request) {
        logger.debug(request.toString());
        try {
            sql = "INSERT INTO penitipan (id_paket, id_pelanggan, jumlah, jam, tanggal) VALUES(?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, request.getIdPaket());
            preparedStatement.setLong(2, request.getIdPelanggan());
            preparedStatement.setLong(3, request.getJumlah());
            preparedStatement.setLong(4, request.getJam());
            preparedStatement.setDate(5, new java.sql.Date(request.getTanggal().getTime()));
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Penitipan request) {
        logger.debug(request.toString());
        try {
            sql = "UPDATE penitipan SET id_paket=?, id_pelanggan=?, jumlah=?, jam=?, tanggal=? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, request.getIdPaket());
            preparedStatement.setLong(2, request.getIdPelanggan());
            preparedStatement.setLong(3, request.getJumlah());
            preparedStatement.setLong(4, request.getJam());
            preparedStatement.setDate(5, new java.sql.Date(request.getTanggal().getTime()));
            preparedStatement.setLong(6, Long.parseLong(request.getId().substring(1)));
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
            sql = "DELETE FROM penitipan WHERE id=?;";
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

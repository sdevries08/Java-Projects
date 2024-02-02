
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class viewTable {
    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music?";
    private static String username = "XXXX";
    private static String password = "XXXX";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Properties UserCredentials  = new Properties();
        try {
            UserCredentials.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("music.properties"),
                    StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var dbInfo = new MysqlDataSource();
        dbInfo.setServerName(props.getProperty("serverName"));
        dbInfo.setPort(Integer.parseInt(props.getProperty("port")));
        dbInfo.setDatabaseName(props.getProperty("databaseName"));


        try {
            conn = DriverManager.getConnection(CONN_STRING, username, String.valueOf(password));
            System.out.println("Success!! Connection made to the music database");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        // String albumName = "Tapestry";
        String query = "SELECT song_id, track_number, song_title, album_id FROM music.songs;";
        try (var connection = dbInfo.getConnection( props.getProperty("user"),System.getenv("MYSQL_PASS"));
             Statement stmt = conn.createStatement();
        ) {

            ResultSet rs = stmt.executeQuery(query);
            var metaDetail = rs.getMetaData();
            // Print column headers
            for (int i = 1; i <= metaDetail.getColumnCount(); i++) {
                System.out.printf("%-65s", metaDetail.getColumnName(i).toUpperCase());
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= metaDetail.getColumnCount(); i++) {
                    System.out.printf("%-65s", rs.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}

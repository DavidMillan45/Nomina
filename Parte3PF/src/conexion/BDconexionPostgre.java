package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDconexionPostgre {

    /** Parametros de conexion */
    static String bd = "PfinalBD";
    static String login = "postgres";
    static String password = "DAVINCHI45";
    static String url = "jdbc:postgresql://localhost/" + bd;

    Connection connection = null;

    public static void main(String[] args) {
        BDconexionPostgre b;
        b = new BDconexionPostgre();
    }

    /** Constructor */
    public BDconexionPostgre() {
        try {
            // obtenemos el driver de para mysql
            Class.forName("org.postgresql.Driver");
            // obtenemos la conexion
            connection = DriverManager.getConnection(url, login, password);

            if (connection != null) {
                System.out.println("Conexionn a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /** Permite retornar la conexion */
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() throws SQLException {
        connection.close();
        connection = null;

    }
}
///DAVINCHI45
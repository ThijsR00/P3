package P3;
import java.sql.*;

public class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "DP2";
	private static final String DB_PASS = "DP2";
	protected static Connection conn;
	public static void getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName(DB_DRIV).newInstance();
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
}

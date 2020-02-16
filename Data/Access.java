import java.sql.*;

/**
 *
 * @author Alexander Lawton
 */
public class Access {
	private String DATABASEPATH = "G:/School/Spring '20/2931/AA_DB(v0.1).accdb";
	private Connection CONNECTION;
	private Statement STATEMENT;
    
	public Access() throws ClassNotFoundException, SQLException {
		System.out.println("Connecting to database....");
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		CONNECTION = DriverManager.getConnection("jdbc:ucanaccess://" + DATABASEPATH);
		System.out.println("Connected");
		STATEMENT = CONNECTION.createStatement();
	}

	public Statement getStatement() {
		return STATEMENT;
	}

	public void close() throws SQLException{
		CONNECTION.close();
		System.out.println("Connection closed.");
	}

	public void parse(String table) {
		String sql = "select * from " + table + ";";
		//add conditional branch for each table based on column amounts
	}

	//Testing method
	public static void main(String args[]) {
		try {
			Access data = new Access();
			String sql = "Select * from Customers;";

			ResultSet rs = access.getStatement().executeQuery(sql);
			System.out.println("Statement executed");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

			sql = "Update Customers set CustomerID='C000' where CustomerID='C001';";
			data.getStatement().executeUpdate(sql);
			System.out.println("Statement executed");

			data.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
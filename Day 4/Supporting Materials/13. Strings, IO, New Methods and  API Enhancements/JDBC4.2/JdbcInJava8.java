import java.sql.*;

// implementing DriverAction interface  
public class JdbcInJava8 implements DriverAction {
	// implementing deregister method of DriverAction interface
	@Override
	public void deregister() {
		System.out.println("Driver deregistered");
	}

	public static void main(String args[]) {
		try {
			// Creating driver instance
			Driver driver = new org.sqlite.JDBC();
			// Creating Action Driver
			DriverAction da = new JdbcInJava8();
			// Registering driver by passing driver and driverAction
			DriverManager.registerDriver(driver, da);
			// Creating connection
			Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");
			// Here student is database name
			
			 if (conn != null) {
	                System.out.println("Connected to the database");
	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	                System.out.println("Driver name: " + dm.getDriverName());
	                System.out.println("Driver version: " + dm.getDriverVersion());
	                System.out.println("Product name: " + dm.getDatabaseProductName());
	                System.out.println("Product version: " + dm.getDatabaseProductVersion());
	                conn.close();
	            }

			// Closing connection
			conn.close();
			// Calling deregisterDriver method
			DriverManager.deregisterDriver(driver);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
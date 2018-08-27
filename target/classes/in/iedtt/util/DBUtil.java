
package in.iedtt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtil {
	public static String SUCCESS = "Success";
	public static String FAIL = "Fail";
	public static String DUPLICATE_FOUND="DuplicateOccured";
    private static Connection connection;
    public static ResultSet resultSet= null;
    public static Statement statement;
    static {
        try {
            String url = "jdbc:mysql://localhost:3306/iedtt";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            Logger.getLogger(DBUtil.class.getName()).log(Level.INFO, driver + " Loaded" , driver + " Loaded");
            Logger.getLogger(DBUtil.class.getName()).log(Level.INFO, url, url);
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int insert(String query) {
        int response = 0;
        Logger.getLogger(DBUtil.class.getName()).log(Level.INFO, query, query);
        try {
            statement = connection.createStatement();
            response = statement.executeUpdate(query);
        } catch (SQLException ex) {
            response =-1;
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return response;
    }

    public static ResultSet getData(String query){
        try {
             Logger.getLogger(DBUtil.class.getName()).log(Level.INFO, query, query);
            statement= connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    public static Connection getconnection() {
    	return connection;
    }
    public static void closeConnections(PreparedStatement pstmt,ResultSet rs) {
    	if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    public static void main(String[] args) {
		
	}
}

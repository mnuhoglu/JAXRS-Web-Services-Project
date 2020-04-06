package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCManager {
	
	
	public static boolean save(Product p1) 
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "");
			PreparedStatement ps =  con.prepareStatement("insert into product (productName,productPrice,productStock) values (?,?,?)");
			ps.setString(1, p1.getProductName());
			ps.setDouble(2, p1.getProductPrice());
			ps.setInt(3, p1.getProductStock());
			int result = ps.executeUpdate();
			
			if(result==1)
			{
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean delete (int productID) {
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "");		
			PreparedStatement ps =  connection.prepareStatement("delete from product where productID = ? ");
			ps.setInt(1, productID);
			int result = ps.executeUpdate();
			
			if(result==1)
			{
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	
	public static boolean update (int productID, double productPrice, int productStock) {
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "");		
			PreparedStatement ps =  connection.prepareStatement("update product set productPrice = ?, productStock = ? where productID = ?");
			ps.setDouble(1, productPrice);
			ps.setInt(2, productStock);
			ps.setInt(3, productID);
			int result = ps.executeUpdate();
			
			if(result==1)
			{
				return true;
			}
	
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}

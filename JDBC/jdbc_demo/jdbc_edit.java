import java.sql.*;
class jdbc_edit
{
	public static void main(String []s)
	{
		try
		{
			String url="jdbc:odbc:pavan";
			Class.forName("sun.jdbc.odbc.jdbcodbcdriver");
            Connection c=DriverManager.getConnection(url);
		    Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from login");
			st.executeQuery("INSERT INTO login"+"VALUES (0,'pavan', 'pavan')");
		    st.executeQuery("UPDATE login SET password='pavangabani' WHERE user='pavan'");
		    while(rs.next())
		   {
				System.out.println("Name : " + rs.getString("uname"));
				System.out.println("Password : " + rs.getString("password"));
		   }			
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}		
	}
}

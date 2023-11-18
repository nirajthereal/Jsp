package pack;
import java.sql.*;
public class MyBean {
	private String email;
	private String pass;
	private String phone;
	private String address;
	boolean valid = false;
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	public void setEmail(String email){
		this.email = email;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getEmail(){
	return email;
	}
	public String getPass(){
		return pass;
	}
	public String getAddress(){
		return address;
	}
	public String getPhone(){
		return phone;
	}
	public boolean getUser(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///11ambatch","root","abcd");
			ps = con.prepareStatement("select email from userdetails");
			rs = ps.executeQuery();
			while(rs.next()){
				if(email.equals(rs.getString("email"))){
					valid = true;
					break;
				}
			}
			if(!valid){
				ps = con.prepareStatement("insert into userdetails values(?, ?, ?, ?)");
				ps.setString(1,email);
				ps.setString(2,pass);
				ps.setString(3,address);
				ps.setInt(4,Integer.parseInt(phone));
				ps.executeUpdate();
			}
			}
			catch(Exception e){}
			return valid;
		}
	public boolean getLogin(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///11ambatch","root","abcd");
			ps =con.prepareStatement("select email, pass from userdetails");
		    rs =ps.executeQuery();
		   while(rs.next())
		   {
			if(email.equals(rs.getString("email"))&& pass.equals(rs.getString("pass")))
			{
			    valid=true;
				break;
			}
			
		   }	
		}
		catch (Exception ae) {}
		
		return valid;
	}
}

		
		
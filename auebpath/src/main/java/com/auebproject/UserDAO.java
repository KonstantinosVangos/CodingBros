package exercise4_2024_2025_8220085;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * UserDAO provides all the necessary methods related to users.
 * 
 * @author 
 *
 */
public class UserDAO {
		
	/**
	 * This method returns a List with all Users
	 * 
	 * @return List<User>
	 */
	public List<User> getUsers() throws Exception {
		List<User> userList = new ArrayList<User>();
		
	
		DB db = new DB();
        Connection con = null;
		String query = "SELECT * FROM users_ex4_8220085_2024_2025;";
		
		try{
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			

			while (rs.next()) {

				userList.add(new User(rs.getString("firstname"),


               rs.getString("lastname"),

                rs.getString("email"),

              rs.getString("username"),rs.getString("password")));

            }
		}catch (Exception e) {

            throw new Exception("Error while retrieving users: " + e.getMessage());

        } finally {

           try{
			db.close();
		   } catch (Exception e){

		   }

        }


        return userList;

    }
		
		
//End of getUsers

	/**
	 * Search user by username
	 * 
	 * @param username, String
	 * @return User, the User object or null
	 * @throws Exception
	 */
	public User findUser(String username) throws Exception {
		
		DB db = new DB();
        Connection con = null;
		String query = "SELECT * FROM users_ex4_8220085_2024_2025 WHERE username= ?;";

		try{
			con= db.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,username);
			ResultSet rs  = stmt.executeQuery();
  // case not valid credentials
  if (!rs.next()) {
	rs.close();
	stmt.close();
	db.close();
	throw new Exception("Wrong username or password");
  }

  // case valid credentials
  User user = new User(rs.getString("firstname"),
		rs.getString("lastname"),
		rs.getString("email"),
		rs.getString("username"),
		rs.getString("password"));
  
  rs.close();
  stmt.close();
  db.close();


  return user;



} catch (Exception e) {
  throw new Exception("Error finding user: " + e.getMessage(),e);
} finally {
  try {
	db.close();
  } catch (Exception e) {
	
  }
}


}


		
		
	 //End of findUser

	/**
	 * This method is used to authenticate a user.
	 * 
	 * @param username, String
	 * @param password, String
	 * @return User, the User object
	 * @throws Exception, if the credentials are not valid
	 */
	public User authenticate(String username, String password) throws Exception {
		DB db = new DB();
        Connection con = null;
		String query = "SELECT * FROM users_ex4_8220085_2024_2025 WHERE username=? AND password=?;";

		try{
			con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);

            // setting parameters
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

			// case not valid credentials
            if (!rs.next()) {
                rs.close();
                stmt.close();
                db.close();
                throw new Exception("Wrong username or password");
            }

            // case valid credentials
            User user = new User(rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"));
            
            rs.close();
            stmt.close();
            db.close();
			return user;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                
            }
        }
		
    }
    
		
	//End of authenticate
	
	/**
	 * Register/create new User.
	 * 
	 * @param user, User
	 * @throws Exception, if encounter any error.
	 */
	public void register(User user) throws Exception {
			
		DB db = new DB();
        Connection con = null;
		String checkQuery = "SELECT * FROM users_ex4_8220085_2024_2025 WHERE username = ? OR email = ? ;";
		String insertQuery = "INSERT INTO users_ex4_8220085_2024_2025 (username, firstname, password, email, lastname) VALUES (?,?,?,?,?);";
		PreparedStatement stmtCheck = null;
		PreparedStatement stmtInsert = null;
		ResultSet rs = null;

		try{
			con= db.getConnection();
			stmtCheck = con.prepareStatement(checkQuery);
			stmtCheck.setString(1,user.getUsername());
			stmtCheck.setString(2,user.getEmail());
			rs = stmtCheck.executeQuery();

			// check if user is found 
			if (rs.next()){
				throw new Exception("Sorry, username or email already registered");
			}
			
			stmtInsert = con.prepareStatement(insertQuery);
			stmtInsert.setString(1,user.getUsername());
			stmtInsert.setString(3,user.getPassword());
			stmtInsert.setString(4,user.getEmail());
			stmtInsert.setString(2,user.getFirstname());
			stmtInsert.setString(5,user.getLastname());
			stmtInsert.executeUpdate();
			rs.close();
			stmtCheck.close();
			stmtInsert.close();
			con.close();

			} catch (Exception e) {
				if (e.getMessage().equals("Sorry, username or email already registered."))
				 {
					 throw new Exception(e.getMessage());
					 } else {
						 throw new Exception("Error during registration " + e.getMessage(),e);
						 }
	
			} finally {
	
				if (rs!= null) rs.close();
				if (stmtCheck != null) stmtCheck.close();
				if (stmtInsert != null) stmtInsert.close();
				if (con != null) con.close();
	
			}
		
	}//end of register

} //End of class

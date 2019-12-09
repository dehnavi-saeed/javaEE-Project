package model.DA;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import model.entity.User;
import org.graalvm.compiler.lir.LIRInstruction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDA extends GenericDA<User> {

    public UserDA(DBConnectionManager connectionManager) {
        super(connectionManager);
    }

    public boolean isValidUsernamePassword(User user){
        Connection connection = getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.prepareStatement("Select * from users where username=? and password=?");
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            resultSet = statement.executeQuery();
            if (((ResultSetImpl)resultSet).getUpdateCount()==1){
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setState(resultSet.getInt("state"));
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeResurce(resultSet);
            closeResurce(statement);
            closeConnection();
        }
    }

    protected boolean insert(Connection connection, User entity) {
        return false;
    }

    protected User selectOne(Connection connection, int id) {
        return null;
    }

    protected List<User> selectAll(Connection connection) {
        return null;
    }

    protected boolean delete(Connection connection, int id) {
        return false;
    }

    protected boolean update(Connection connection, User entity) {
        return false;
    }
}

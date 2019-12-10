package model.DA;



import com.mysql.jdbc.ResultSetImpl;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDA extends GenericDA<User> {

    public UserDA(DBConnectionManager connectionManager) {
        super(connectionManager);
    }

    public boolean isValidUsernamePassword(User user) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("Select * from users where username=? and password=?");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();
            resultSet.next();
            if (resultSet.getRow() == 1) {

                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setState(resultSet.getInt("state"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResurce(resultSet);
            closeResurce(statement);
            closeConnection();
        }
    }

    protected boolean insert(Connection connection, User entity) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT users(username,password,role) VALUES (?,?,?)");
            statement.setString(1, entity.getUsername());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRole());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResurce(statement);
        }
    }

    protected User selectOne(Connection connection, int id) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("Select * from users where id=? ");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setState(resultSet.getInt("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResurce(resultSet);
            closeResurce(statement);
        }
        return user;
    }

    protected List<User> selectAll(Connection connection) {
        List<User> users = new ArrayList<User>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("Select * from users ");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getInt("state")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResurce(resultSet);
            closeResurce(statement);
        }
        return users;

    }

    protected boolean delete(Connection connection, int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from users where id=?");
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResurce(statement);
        }

    }

    protected boolean update(Connection connection, User entity) {
        return false;
    }
}

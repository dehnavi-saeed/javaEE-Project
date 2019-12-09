package model.DA;

import java.sql.Connection;
import java.util.List;

abstract public class GenericDA <T> {
    private Connection connection;
    private DBConnectionManager connectionManager;

    protected void closeResurce(AutoCloseable closeable){
        if (closeable!=null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    protected Connection getConnection(){
        connection = connectionManager.openConnection();
        return connection;
    }

    protected void closeConnection(){
        connectionManager.closeConnection(connection);
    }

    public GenericDA(DBConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public boolean insert(T entity){
        getConnection();
        try {
            return insert(connection, entity);
        }catch (Exception e){
            return false;
        }finally {
            closeConnection();
        }
    }

    abstract protected boolean insert(Connection connection,T entity);

    public T selectOne(int id){
        getConnection();
        try {
            return selectOne(connection, id);
        }catch (Exception e){
            return null;
        }finally {
            closeConnection();
        }
    }

    abstract protected T selectOne(Connection connection,int id);

    public List<T>  selectOne(){
        getConnection();
        try {
            return selectAll(connection);
        }catch (Exception e){
            return null;
        }finally {
            closeConnection();
        }
    }

    abstract protected List<T> selectAll(Connection connection);

    public boolean delete(int id){
        getConnection();
        try {
            return delete(connection, id);
        }catch (Exception e){
            return false;
        }finally {
            closeConnection();
        }
    }

    abstract protected boolean delete(Connection connection,int id);

    public boolean update(T entity){
        getConnection();
        try {
            return update(connection, entity);
        }catch (Exception e){
            return false;
        }finally {
            closeConnection();
        }
    }

    abstract protected boolean update(Connection connection,T entity);
}

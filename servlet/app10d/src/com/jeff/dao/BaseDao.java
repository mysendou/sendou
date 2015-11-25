package com.jeff.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.jeff.DAOException;

public class BaseDao implements Dao{

    @Override
    public Connection getConnection() throws DAOException {
        DataSource dataSource = DataSourceCache.getInstance().getDataSource();
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new DAOException("Error get dataSource. " + e.getMessage());
        }
    }
    
    protected void closeDBObject(ResultSet resultSet, Statement statement, Connection connection) {
        if(null != resultSet){
            try {
                resultSet.close();
            } catch (Exception e) {
            }
        }
        
        if(null != null){
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
        
        if(null != connection){
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

}

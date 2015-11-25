package com.jeff.dao;

import java.sql.Connection;

public interface Dao {
    Connection getConnection() throws Exception;
}

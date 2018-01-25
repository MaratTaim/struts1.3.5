package com.epam.testapp.datebase;

import com.epam.testapp.model.News;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 20.01.2018.
 */
public interface AbstractDAO {

    void setConnection(Connection connection);
    List<News> getList();
    boolean save(News news);
    boolean remove(int id);
    News fetchById(int id);
    boolean update(News news);


}

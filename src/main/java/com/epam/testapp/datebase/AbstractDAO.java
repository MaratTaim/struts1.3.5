package com.epam.testapp.datebase;

import com.epam.testapp.model.News;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 20.01.2018.
 */

public interface AbstractDAO {

    List<News> getList();
    void save(News news);
    void remove(Long id);
    News fetchById(Long id);
    void update(News news);


}

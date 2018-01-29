package com.epam.testapp.datebase;

import com.epam.testapp.model.News;
import com.epam.testapp.util.Const;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.01.2018.
 */
@Component
public class NewsDAO implements AbstractDAO {
    private final Logger logger = Logger.getLogger(NewsDAO.class);
    private Connection connection;
    private final String INSERT = "INSERT INTO NEWS (TITLE, N_DATE, BRIEF, CONTENT) VALUES(?,?,?,?)";
    private final String UPDATE = "UPDATE NEWS SET TITLE=?, N_DATE=?, BRIEF=?, CONTENT=? WHERE ID=?";
    private final String SELECT = "SELECT * FROM NEWS WHERE ID=?";
    private final String SELECT_ALL = "SELECT * FROM NEWS";
    private final String DELETE = "DELETE FROM NEWS WHERE ID=?";
    private String ID = "id";
    private String TITLE = "title";
    private String DATE = "n_date";
    private String BRIEF = "brief";
    private String CONTENT = "content";

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<News> getList() {
        List list = new ArrayList();
        News news;
        try (PreparedStatement st = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                news = new News(rs.getInt(ID), rs.getString(TITLE),
                        rs.getDate(DATE).toString(), rs.getString(BRIEF),
                        rs.getString(CONTENT));
                list.add(news);
            }
            commit(connection);
        } catch (SQLException e) {
            logger.error(Const.ERR_LIST,e);
        }
        return list;
    }

    @Override
    public boolean save(News news) {
        try (PreparedStatement st = connection.prepareStatement(INSERT)) {
            st.setString(1, news.getTitle());
            st.setDate(2, Date.valueOf(news.getDate()));
            st.setString(3, news.getBrief());
            st.setString(4, news.getContent());
            st.execute();

            commit(connection);
        } catch (SQLException e) {
            logger.error(Const.C_SAVE, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(News news) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE)) {
            st.setString(1, news.getTitle());
            st.setDate(2, Date.valueOf(news.getDate()));
            st.setString(3, news.getBrief());
            st.setString(4, news.getContent());
            st.setInt(5, news.getId());
            if (st.executeUpdate() == 0) {
                logger.error(Const.C_UPDATE + news.getId());
                return false;
            }
            commit(connection);
        } catch (SQLException e) {
            logger.error(Const.ERR_UPDATE, e);
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                logger.error(Const.C_DELETE);
                return false;
            }
            commit(connection);
        } catch (SQLException e) {
            logger.error(Const.ERR_DELETE, e);
        }
        return true;
    }

    @Override
    public News fetchById(int id) {
        News news = News.EMPTY;
        try (PreparedStatement st = connection.prepareStatement(SELECT)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                logger.error(Const.C_SELECT);
            }
            news = new News(rs.getInt(ID),
                    rs.getString(TITLE),
                    rs.getDate(DATE).toString(),
                    rs.getString(BRIEF),
                    rs.getString(CONTENT));

            commit(connection);
        } catch (SQLException e) {
            logger.error(Const.ERR_SELECT, e);
        }
        return news;
    }

    public void commit(Connection connection) {
        try {
            connection.commit();
        } catch (Exception e) {
            logger.error(Const.COMMIT_EX, e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.error(Const.ROLLBACK_EX, e1);
            }
        }
    }
}

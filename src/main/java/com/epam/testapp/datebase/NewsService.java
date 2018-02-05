package com.epam.testapp.datebase;

import com.epam.testapp.model.News;
import com.epam.testapp.util.bl.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class NewsService extends SessionUtil implements AbstractDAO {

    public void save(News news){
        openTransactionSession();

        Session session = getSession();
        session.save(news);

        closeTransactionSesstion();
    }

    public List<News> getList() {
        openTransactionSession();

        Session session = getSession();
        Query query = session.createQuery("from News");
        List<News> newsList = query.list();

        closeTransactionSesstion();

        return newsList;
    }

    public News fetchById(Long id){
        openTransactionSession();

        Session session = getSession();
        News news = (News)session.get(News.class, id);

        closeTransactionSesstion();

        return news;
    }

    public void update(News news){
        openTransactionSession();

        Session session = getSession();
        session.update(news);

        closeTransactionSesstion();
    }

    public void remove(Long id){
        openTransactionSession();

        Session session = getSession();
        News news = (News)session.get(News.class, id);
        session.delete(news);

        closeTransactionSesstion();
    }

}

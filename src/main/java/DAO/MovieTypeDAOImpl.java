package DAO;

import Utils.HibernateUtils;
import fa.training.entities.Movie;
import fa.training.entities.MovieType;
import fa.training.entities.MovieTypeKey;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MovieTypeDAOImpl implements MovieTypeDAO{
    @Override
    public MovieType createMT(MovieType movieType) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            session.save(movieType);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return movieType;
    }

    @Override
    public List<MovieType> readAll() {
        List<MovieType> movieTypeList = null;
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            Query<MovieType> query = session.createQuery("SELECT mt FROM MovieType mt");
            movieTypeList = query.getResultList();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return movieTypeList;
    }

    @Override
    public MovieType readById(MovieTypeKey id) {
        MovieType movieType = null;
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            movieType = session.get(MovieType.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return movieType;
    }

    @Override
    public void update(MovieType movieType) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            MovieType movieTypeDB = session.get(MovieType.class, movieType.getId());
            movieTypeDB.setMtDescription(movieType.getMtDescription());

            session.update(movieTypeDB);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(MovieTypeKey id) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();

            MovieType movieType = session.get(MovieType.class, id);

            session.remove(movieType);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

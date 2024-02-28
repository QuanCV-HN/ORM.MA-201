package DAO;

import Utils.HibernateUtils;
import fa.training.entities.Movie;
import fa.training.entities.MovieType;
import fa.training.entities.Type;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MovieDAOImpl implements MovieDAO{

    MovieTypeDAO movieTypeDAO = new MovieTypeDAOImpl();
    @Override
    public Movie create(Movie movie) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            //save Movie
            session.save(movie);

            //save list<MovieType>
            for (MovieType movieType: movie.getMovieTypes()) {
                movieType.getId().setMovieId(movie.getId());
              session.save(movieType);
            }
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public List<Movie> readALl() {
        List<Movie> movieList = null;
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            Query<Movie> query = session.createQuery("SELECT m FROM Movie m");
            movieList = query.getResultList();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public Movie readById(String  id) {
        Movie movie= null;
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            movie =session.get(Movie.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public void update(Movie movie) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            Movie movieDB = session.get(Movie.class, movie.getId());
            movieDB.setContent(movie.getContent());
            movieDB.setFromDate(movie.getFromDate());
            movieDB.setToDate(movie.getToDate());

            session.update(movieDB);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();

            Movie movie = session.get(Movie.class, id);
            for (MovieType movieType : movie.getMovieTypes()) {
                session.delete(movieType);
            }
            session.remove(movie);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

import DAO.MovieDAO;
import DAO.MovieDAOImpl;
import fa.training.entities.Movie;
import fa.training.entities.MovieType;
import fa.training.entities.MovieTypeKey;
import fa.training.entities.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TestMovie {
    MovieDAO movieDAO = new MovieDAOImpl();

    @Test
    public  void create(){
        Movie movie = new Movie();


        MovieType movieType1 = new MovieType();
        MovieTypeKey movieTypeKey1 = new MovieTypeKey();
        Type type1 = new Type();
        type1.setId(1);
        movieType1.setType(type1);
        movieTypeKey1.setTypeId(1);

        movieType1.setId(movieTypeKey1);

        movieType1.setMovie(movie);
        movieType1.setMtDescription("abc");
        movie.getMovieTypes().add(movieType1);

        MovieType movieType2 = new MovieType();
        MovieTypeKey movieTypeKey2 = new MovieTypeKey();
        Type type2 = new Type();
        type2.setId(2);
        movieType2.setType(type2);
        movieTypeKey2.setTypeId(2);

        movieType2.setId(movieTypeKey2);

        movieType2.setMovie(movie);
        movieType2.setMtDescription("xyz");
        movie.getMovieTypes().add(movieType2);

        movie.setActor("Nam");
        movie.setContent("phim rat la hay");
        movie.setDirector("Obama");
        movie.setDuration(new BigDecimal(2.5));
        movie.setFromDate(new Date());
        movie.setToDate(new Date());
        movie.setMovieProductionCompany("Holywood");
        movie.setVersion("2.0");
        movie.setMovieNameEng("movie2");
        movie.setMovieNameVn("phim2");
        movie.setLargeImage("bigImg");
        movie.setSmallImage("smallImg");

      movieDAO.create(movie);
      Movie movie1 = movieDAO.readById(movie.getId());

        Assertions.assertNotNull(movie1);
    }

    @Test
    public void readAll(){

        List<Movie> movieList = movieDAO.readALl();
        movieList.forEach(l ->{
            System.out.println(l);
        });
        Assertions.assertNotNull(movieList);
    }

    @Test
    public void read_by_id(){
        String id = "M001";
        Movie movie = movieDAO.readById(id);
        System.out.println(movie);
        Assertions.assertNotNull(movie);
    }

    @Test
    public void update(){
       Movie movie = new Movie();
       movie.setId("M001");
       movie.setContent("hay nhat nam");
       movie.setFromDate(new Date());
       movie.setToDate(new Date());

        movieDAO.update(movie);

     Movie movieUpdated = movieDAO.readById(movie.getId());

        Assertions.assertEquals(movieUpdated.getContent(), movie.getContent());
    }

    @Test
    public void delete(){
        String id = "M001";
        movieDAO.delete(id);

      Movie movie = movieDAO.readById(id);
        Assertions.assertNull(movie);

    }
}

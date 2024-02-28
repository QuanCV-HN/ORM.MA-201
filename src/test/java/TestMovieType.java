import DAO.MovieTypeDAO;
import DAO.MovieTypeDAOImpl;
import fa.training.entities.Movie;
import fa.training.entities.MovieType;
import fa.training.entities.MovieTypeKey;
import fa.training.entities.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestMovieType {

    MovieTypeDAO movieTypeDAO= new MovieTypeDAOImpl();
    @Test
    public  void create(){
        MovieType movieType = new MovieType();

        Movie movie = new Movie();
        movie.setId("M001");
        movieType.setMovie(movie);

        Type type = new Type();
        type.setId(3);
        movieType.setType(type);

        MovieTypeKey movieTypeKey = new MovieTypeKey();
        movieTypeKey.setMovieId(movie.getId());
        movieTypeKey.setTypeId(type.getId());

        movieType.setId(movieTypeKey);
        movieType.setMtDescription("123");

        movieTypeDAO.createMT(movieType);
    }

    @Test
    public void readAll(){

        List<MovieType> movieTypeList = movieTypeDAO.readAll();
        movieTypeList.forEach(l ->{
            System.out.println(l);
        });
        Assertions.assertNotNull(movieTypeList);
    }

    @Test
    public void read_by_id(){
        MovieTypeKey movieTypeKey = new MovieTypeKey();
        movieTypeKey.setTypeId(3);
        movieTypeKey.setMovieId("M001");

        MovieType movieType = movieTypeDAO.readById(movieTypeKey);

        System.out.println(movieType);
        Assertions.assertNotNull(movieType);
    }

    @Test
    public void update(){
        MovieTypeKey movieTypeKey = new MovieTypeKey();
        movieTypeKey.setTypeId(3);
        movieTypeKey.setMovieId("M001");

        MovieType movieType = new MovieType();
        movieType.setId(movieTypeKey);
        movieType.setMtDescription("hay,hay,rat hay");

        movieTypeDAO.update(movieType);

        MovieType movieTypeUpdated = movieTypeDAO.readById(movieTypeKey);

        Assertions.assertEquals(movieType.getMtDescription(), movieTypeUpdated.getMtDescription());
    }

    @Test
    public void delete(){
       MovieTypeKey movieTypeKey = new MovieTypeKey();
       movieTypeKey.setMovieId("M001");
       movieTypeKey.setTypeId(3);

       movieTypeDAO.delete(movieTypeKey);
       MovieType movieType = movieTypeDAO.readById(movieTypeKey);

        Assertions.assertNull(movieType);
    }
}

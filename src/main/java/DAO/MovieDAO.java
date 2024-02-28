package DAO;

import fa.training.entities.Movie;
import fa.training.entities.Type;

import java.util.List;

public interface MovieDAO {
    Movie create(Movie movie);

    List<Movie> readALl();

    Movie readById(String  id);

    void update(Movie movie);

    void delete(String id);
}

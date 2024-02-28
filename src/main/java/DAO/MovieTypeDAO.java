package DAO;

import fa.training.entities.MovieType;
import fa.training.entities.MovieTypeKey;

import java.util.List;

public interface MovieTypeDAO {
    MovieType createMT(MovieType movieType);

    List<MovieType> readAll();

    MovieType readById(MovieTypeKey id);

    void update(MovieType movieType);

    void delete(MovieTypeKey id);
}

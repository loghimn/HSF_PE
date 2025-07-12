package sum25.longvtse184610.pehsf302trialexamse184610.service;

import org.springframework.stereotype.Service;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.MovieStatus;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Movies;

import java.util.List;


public interface MoviesService {
    void saveMovie(Movies movie);

    void deleteMovie(int movieId);

    void updateMovie(int movieId, String movieName, int duration, String actor, MovieStatus status, Directors directorID);

    List<Movies> getAllMovies();

    List<Movies> searchMovies(String keyword);

    Movies getMovieById(int id);

    List<Movies> getAllMoviesSortedByLatest();
}

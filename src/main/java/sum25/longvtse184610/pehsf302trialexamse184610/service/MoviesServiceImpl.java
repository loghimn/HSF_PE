package sum25.longvtse184610.pehsf302trialexamse184610.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.MovieStatus;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Movies;
import sum25.longvtse184610.pehsf302trialexamse184610.repository.MoviesRepository;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {


    private MoviesRepository moviesRepository;

    public MoviesServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public void saveMovie(Movies movie) {
        moviesRepository.save(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        moviesRepository.deleteById(movieId);
    }

    @Override
    public void updateMovie(int movieId, String movieName, int duration, String actor, MovieStatus status, Directors director) {
        Movies movies = moviesRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        movies.setMovieName(movieName);
        movies.setDuration(duration);
        movies.setActor(actor);
        movies.setStatus(status);
        movies.setDirector(director);
        moviesRepository.save(movies);
    }

    @Override
    public List<Movies> searchMovies(String keyword) {
        return moviesRepository.searchByKeyword(keyword);
    }

    @Override
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public List<Movies> getAllMoviesSortedByLatest() {
        return moviesRepository.findAll(Sort.by(Sort.Direction.DESC, "movieID"));
    }


    @Override
    public Movies getMovieById(int id) {
        return moviesRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}

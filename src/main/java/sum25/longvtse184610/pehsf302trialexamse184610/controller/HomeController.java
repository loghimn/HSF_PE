package sum25.longvtse184610.pehsf302trialexamse184610.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Accounts;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Movies;
import sum25.longvtse184610.pehsf302trialexamse184610.service.DirectorsService;
import sum25.longvtse184610.pehsf302trialexamse184610.service.MoviesService;

import java.util.List;

@Controller
public class HomeController {
    private MoviesService movieService;
    private DirectorsService directorService;

    public HomeController(MoviesService movieService, DirectorsService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping("/homepage")
    public String homepage(@RequestParam(value = "keyword", required = false) String keyword, HttpSession session, Model model) {
        Accounts accounts = (Accounts) session.getAttribute("accounts");
        List<Movies> movies;
        if (keyword != null && !keyword.isEmpty()) {
            movies = movieService.searchMovies(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            movies = movieService.getAllMoviesSortedByLatest();
        }
        model.addAttribute("movies", movies);
        return "homepage";

    }

    @GetMapping("/movies/create")
    public String createMovie(Model model) {
        model.addAttribute("movie", new Movies());
        List<Directors> directors = directorService.getAllDirectors();
        model.addAttribute("directors", directors);
        return "homepage-create";
    }

    @PostMapping("/movies/create")
    public String createMovie(@Valid @ModelAttribute("movie") Movies movie,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("directors", directorService.getAllDirectors());
            return "homepage-create";
        }

        movieService.saveMovie(movie);
        return "redirect:/homepage";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovie(Model model, @PathVariable int id) {
        List<Directors> directors = directorService.getAllDirectors();
        model.addAttribute("directors", directors);
        Movies movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "homepage-edit";
    }

    @PostMapping("/movies/edit")
    public String editMovie(@Valid @ModelAttribute("movie") Movies movie, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("directors", directorService.getAllDirectors());
            return "homepage-edit";
        }
        movieService.saveMovie(movie);
        return "redirect:/homepage";
    }

    @GetMapping("/movies/search")
    public String searchMovie(@RequestParam("keyword") String keyword, Model model, HttpSession session) {
        Accounts accounts = (Accounts) session.getAttribute("accounts");
        List<Movies> result = movieService.searchMovies(keyword);
        model.addAttribute("movies", result);
        model.addAttribute("keyword", keyword);
        return "redirect:/homepage?keyword=" + keyword;
    }

    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable("id") int id, HttpSession session, Model model) {
        Accounts accounts = (Accounts) session.getAttribute("accounts");
        movieService.deleteMovie(id);
        return "redirect:/homepage";

    }
}

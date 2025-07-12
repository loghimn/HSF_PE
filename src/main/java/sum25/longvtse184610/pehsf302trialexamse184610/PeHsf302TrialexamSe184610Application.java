package sum25.longvtse184610.pehsf302trialexamse184610;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Accounts;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.MovieStatus;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Movies;
import sum25.longvtse184610.pehsf302trialexamse184610.service.AccountsService;
import sum25.longvtse184610.pehsf302trialexamse184610.service.DirectorsService;
import sum25.longvtse184610.pehsf302trialexamse184610.service.MoviesService;

import java.util.List;

@SpringBootApplication
public class PeHsf302TrialexamSe184610Application implements CommandLineRunner {

    @Autowired
    private AccountsService accountsService;
    @Autowired
    private DirectorsService directorsService;
    @Autowired
    private MoviesService moviesService;

    public static void main(String[] args) {
        SpringApplication.run(PeHsf302TrialexamSe184610Application.class, args);
    }

    @Override
    public void run(String... args) {
        if (accountsService.getAllAccounts().size() == 0 && directorsService.getAllDirectors().size() == 0 && moviesService.getAllMovies().size() == 0) {
            // Save directors and get managed entities
            Directors d1 = new Directors("Phontharis", "Thailand");
            Directors d2 = new Directors("Fujiko Fujio", "Japan");
            Directors d3 = new Directors("James Cameron", "USA");
            directorsService.saveDirector(d1);
            directorsService.saveDirector(d2);
            directorsService.saveDirector(d3);


            // Save accounts
            List<Accounts> accounts = List.of(
                    new Accounts("admin@cinestar.com", "@4", 1),
                    new Accounts("customer@cinestar.com", "@4", 2),
                    new Accounts("manager@cinestar.com", "@4", 3),
                    new Accounts("staff@cinestar.com", "@4", 4)
            );
            for (Accounts account : accounts) {
                accountsService.saveAccount(account);
            }

            // Save movies with managed directors
            List<Movies> movies = List.of(
                    new Movies("PEE NAK", 120, "Witthawat", MovieStatus.active, d1),
                    new Movies("Doraemon", 115, "Nobita", MovieStatus.active, d2),
                    new Movies("Doraemon", 120, "Doraemon", MovieStatus.inactive, d2),
                    new Movies("Avatar", 112, "Kate Winslet", MovieStatus.inactive, d3)
            );

            for (Movies movie : movies) {
                moviesService.saveMovie(movie);
            }
        }
    }
}
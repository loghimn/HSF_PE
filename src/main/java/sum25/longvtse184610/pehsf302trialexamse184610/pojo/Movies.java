package sum25.longvtse184610.pehsf302trialexamse184610.pojo;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;

    @NotBlank(message = "Movie name is required")
    @Size(max = 20, message = "Movie name must be less than 20 characters")
    @Pattern(regexp = "^\\p{Lu}\\p{L}*( \\p{Lu}\\p{L}*)*$",
            message = "Each word must start with a capital letter, and only letters allowed")

    @Column(name = "MovieName", columnDefinition = "NVARCHAR(50)", nullable = false, length = 50)
    private String movieName;

    @Min(value = 75, message = "Duration must be at least 75 minutes")
    @Max(value = 120, message = "Duration must be at most 120 minutes")
    @Column(name = "Duration", nullable = false)
    private int duration;

    @NotBlank(message = "Actor is required")
    @Column(name = "Actor", columnDefinition = "NVARCHAR(150)", nullable = false, length = 150)
    private String actor;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "Status", columnDefinition = "NVARCHAR(50)", nullable = false)
    private MovieStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DirectorID", nullable = false)
    private Directors director;

    public Movies() {
    }

    public Movies(String movieName, int duration, String actor, MovieStatus status, Directors director) {
        this.movieName = movieName;
        this.duration = duration;
        this.actor = actor;
        this.status = status;
        this.director = director;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public MovieStatus getStatus() {
        return status;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    public Directors getDirector() {
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }
}

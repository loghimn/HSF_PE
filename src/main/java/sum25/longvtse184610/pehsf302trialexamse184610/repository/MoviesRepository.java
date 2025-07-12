package sum25.longvtse184610.pehsf302trialexamse184610.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Movies;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    @Query(
            "SELECT m FROM Movies m WHERE " +
                    "LOWER(m.movieName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR LOWER(m.director.directorName) LIKE LOWER(CONCAT('%', :keyword, '%')) "
    )
    List<Movies> searchByKeyword(@Param("keyword") String keyword);
}
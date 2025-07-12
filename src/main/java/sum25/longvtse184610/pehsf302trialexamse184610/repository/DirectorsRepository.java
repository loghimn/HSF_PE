package sum25.longvtse184610.pehsf302trialexamse184610.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;

@Repository
public interface DirectorsRepository extends JpaRepository<Directors, Integer> {
}

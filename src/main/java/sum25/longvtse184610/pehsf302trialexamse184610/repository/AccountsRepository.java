package sum25.longvtse184610.pehsf302trialexamse184610.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Accounts;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByEmailAndPassword(String email, String password);
}

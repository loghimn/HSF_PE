package sum25.longvtse184610.pehsf302trialexamse184610.service;

import org.springframework.stereotype.Service;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Accounts;

import java.util.List;


public interface AccountsService {
    Accounts login(String username, String password);

    void saveAccount(Accounts accounts);

    List<Accounts> getAllAccounts();
}

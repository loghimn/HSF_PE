package sum25.longvtse184610.pehsf302trialexamse184610.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Accounts;
import sum25.longvtse184610.pehsf302trialexamse184610.repository.AccountsRepository;

import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {


    private AccountsRepository accountsRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public Accounts login(String email, String password) {
        return accountsRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public void saveAccount(Accounts accounts) {
        accountsRepository.save(accounts);
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }
}

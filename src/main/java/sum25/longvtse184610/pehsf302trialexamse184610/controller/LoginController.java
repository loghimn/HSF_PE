package sum25.longvtse184610.pehsf302trialexamse184610.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Accounts;
import sum25.longvtse184610.pehsf302trialexamse184610.service.AccountsService;

@Controller
public class LoginController {

    private final AccountsService accountsService;

    public LoginController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        return "loginpage"; // Return the name of the login view
    }


    @PostMapping("/")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        Accounts account = accountsService.login(username, password);
        if (account != null && (account.getRoleID() == 1 || account.getRoleID() == 3)) {
            session.setAttribute("accounts", account);
            System.out.println("Login successful: " + account.getEmail());
            return "redirect:/homepage";
        } else if (account != null && (account.getRoleID() == 2 || account.getRoleID() == 4)) {
            redirectAttributes.addFlashAttribute("error", "You have no permission to access this function!");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/";
        }
    }
}

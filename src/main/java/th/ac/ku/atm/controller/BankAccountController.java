package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping ("/bankAccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model){
        model.addAttribute("allBankAccount", bankAccountService.getBankAccount());
        return "bankAccount"; // bankAccount.html template
    }

    @PostMapping
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model){
        bankAccountService.creatBankAccount(bankAccount);
        model.addAttribute("allBankAccount", bankAccountService.getBankAccount());
        return "redirect:bankAccount";
    }

}

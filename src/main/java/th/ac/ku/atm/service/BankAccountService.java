package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private List<BankAccount> bankAccountList;

    public List<BankAccount> getBankAccount() {
        return new ArrayList<>(this.bankAccountList);
    }

    @PostConstruct
    public void postContruct(){
        this.bankAccountList = new ArrayList<>();
    }

    public void creatBankAccount(BankAccount bankAccount){
        bankAccountList.add(bankAccount);
    }

}

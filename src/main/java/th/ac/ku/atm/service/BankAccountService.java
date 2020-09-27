package th.ac.ku.atm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private RestTemplate restTemplate;

    public BankAccountService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccount(int customerId) {
        //connect to bankAccount API service
        String url = "http://localhost:8091/api/bankaccount/customer/" +
                customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

//    private List<BankAccount> bankAccountList;
//
//    public List<BankAccount> getBankAccount() {
//        return new ArrayList<>(this.bankAccountList);
//    }
//
//    @PostConstruct
//    public void postContruct(){
//        this.bankAccountList = new ArrayList<>();
//    }
//
//    public void creatBankAccount(BankAccount bankAccount){
//        bankAccountList.add(bankAccount);
//    }

}

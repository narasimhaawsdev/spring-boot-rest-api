package combank.india.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import combank.india.dto.Account;
import combank.india.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public Account createBankAccount(Account account) {
		return repository.save(account);
	}

	public void deposit(Long accountNo, Double depBal) {
		Account account = repository.findById(accountNo).orElseThrow(() -> new RuntimeException());

		account.setAccBal(account.getAccBal() + depBal);
		repository.save(account);

	}

	public Account withDraw(Long accountNo, Double wdrBal) {
		Account account = repository.findById(accountNo).orElseThrow(() -> new RuntimeException());
		if (account.getAccBal() < wdrBal) {
			throw new RuntimeException();
		}

		account.setAccBal(account.getAccBal() - wdrBal);
		return repository.save(account);

	}

}

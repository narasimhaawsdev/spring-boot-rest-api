package combank.india.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import combank.india.dto.Account;
import combank.india.service.AccountService;

@RestController
@RequestMapping(path="/api/accounts")
public class AccountController {
    @Autowired
	private AccountService accountService;

	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return accountService.createBankAccount(account);
	}

	/*
	 * @GetMapping("/{id}") public Account getAccount(@PathVariable Long id) {
	 * return accountService.getAccount(id).orElseThrow(() -> new
	 * RuntimeException("Account not found")); }
	 */

	@PostMapping("/{id}/deposit")
	public void deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		accountService.deposit(id, amount);
		}

	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		return accountService.withDraw(id, amount);
	}
}

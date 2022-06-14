package com.init.usuario.controler;

import com.init.usuario.config.exception.AccountException;
import com.init.usuario.entitys.Account;

import java.util.List;

import com.init.usuario.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("accounts")
public class AccountsRest {
    
    @Autowired
	private AccountService accountsService;

	@GetMapping
	public ResponseEntity<List<Account>> getAccount(){
		try{
			return ResponseEntity.ok(accountsService.getAccount());
		}catch (AccountException accountRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@RequestMapping(value = "{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable("accountId") Long accountId){
		try{
			return ResponseEntity.ok(accountsService.getAccountById(accountId));
		}catch (AccountException accountRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping(value = "{user_id}")
	public ResponseEntity<Account> createAccount(@RequestBody Account account, @PathVariable("userId") Long userId){
		try {
			return ResponseEntity.ok(accountsService.createAccount(account, userId));
		}catch (AccountException accountRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping(value = "{accountId}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("accountId") Long accountId){
		try {
			return ResponseEntity.ok(accountsService.deleteAccount(accountId));
		}catch (AccountException accountRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PutMapping
	public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		try {
			return ResponseEntity.ok(accountsService.updateAccount(account));
		}catch (AccountException accountRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}

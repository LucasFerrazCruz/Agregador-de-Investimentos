package tech.buildrun.agregadorinvestimentos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.buildrun.agregadorinvestimentos.controller.dto.AccountStockResponseDto;
import tech.buildrun.agregadorinvestimentos.controller.dto.AssociateAccountStockDto;
import tech.buildrun.agregadorinvestimentos.service.AccountService;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> associateStock(@PathVariable String accountId, @RequestBody AssociateAccountStockDto associateAccountStockDto) {

        accountService.associateStock(accountId, associateAccountStockDto);
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDto>> listStocks(@PathVariable String accountId) {

        var stocks = accountService.listStocks(accountId);
        
        return ResponseEntity.ok(stocks);
    }
}

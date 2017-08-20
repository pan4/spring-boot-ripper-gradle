package com.ironbank.moneyraven.controller;

import com.ironbank.moneyraven.dao.MoneyDao;
import com.ironbank.moneyraven.service.TransferMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tolkv
 * @since 8/20/2017
 */
@RestController
@RequiredArgsConstructor
public class IronBankController {
  private final TransferMoneyService transferMoney;
  private final MoneyDao moneyDao;

  @GetMapping("/credit")
  public String credit(@RequestParam String name, @RequestParam long amount) {
    transferMoney.transfer(name, amount);
    return "ACCEPTED";
  }

  @GetMapping("/state")
  public long currentState() {
    return moneyDao.findAll().get(0).getTotalAmount();
  }
}

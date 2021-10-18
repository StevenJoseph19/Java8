package com.mycompany.pension.investment;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

import com.mycompany.pension.Account;

public interface InvestmentManagementService {
    void addFunds(Account account, BigDecimal investmentAmount, Currency investmentCcy);

    boolean buyInvestmentFund(Account account, String fundId, BigDecimal investmentAmount) throws IOException;

    boolean sellInvestmentFund(Account account, String fundId, BigDecimal investmentAmount) throws IOException;
}

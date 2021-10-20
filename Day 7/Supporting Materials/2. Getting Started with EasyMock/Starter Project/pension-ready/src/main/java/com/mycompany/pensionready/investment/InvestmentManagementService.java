package com.mycompany.pensionready.investment;

import java.util.Currency;

import com.mycompany.pensionready.Account;

public interface InvestmentManagementService {
    boolean addFunds(Account account, long investmentAmount, Currency investmentCcy);

    boolean buyInvestmentFund(Account account, String fundId, long investmentAmount, Currency investmentCcy);

    boolean sellInvestmentFund(Account account, String fundId, long investmentAmount, Currency investmentCcy);
}

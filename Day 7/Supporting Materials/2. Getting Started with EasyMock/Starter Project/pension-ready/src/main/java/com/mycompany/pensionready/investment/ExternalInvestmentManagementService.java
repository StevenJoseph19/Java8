package com.mycompany.pensionready.investment;

import java.util.Currency;

import com.mycompany.pensionready.Account;

public class ExternalInvestmentManagementService implements InvestmentManagementService {

    @Override
    public boolean addFunds(Account account, long investmentAmount, Currency investmentCcy) {
        //implementation not relevant for this course module
        return true;
    }

    @Override
    public boolean buyInvestmentFund(Account account, String fundId, long investmentAmount, Currency investmentCcy) {
        //implementation not relevant for this course module
        return false;
    }

    @Override
    public boolean sellInvestmentFund(Account account, String fundId, long investmentAmount, Currency investmentCcy) {
        //implementation not relevant for this course module
        return false;
    }
}

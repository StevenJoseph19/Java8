package com.mycompany.pensionready.withdrawal;

import com.mycompany.pensionready.Account;
import com.mycompany.pensionready.setup.BackgroundCheckResults;
import com.mycompany.pensionready.setup.BackgroundCheckService;
import com.mycompany.pensionready.withdrawal.AccountClosingResponse;
import com.mycompany.pensionready.withdrawal.AccountClosingService;
import com.mycompany.pensionready.withdrawal.AccountClosingStatus;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.*;

import static com.mycompany.pensionready.setup.AccountOpeningServiceTest.*;
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountClosingServiceTest {

    private BackgroundCheckService backgroundCheckService = mock(BackgroundCheckService.class);
    Instant fixedTime = LocalDate.of(2020, 1, 1).atStartOfDay(ZoneId.systemDefault())
            .toInstant();
    Clock fixedClock = Clock.fixed(fixedTime, ZoneId.systemDefault());
    private AccountClosingService underTest = new AccountClosingService(backgroundCheckService, fixedClock);

    @Test
    public void shouldDeclineAccountClosingTodayIfAccountHolderReachesRetirementAgeTomorrow() throws IOException {
        Account account = new Account();
        account.setDob(LocalDate.of(1955, 1, 2));

        replay(backgroundCheckService);
        final AccountClosingResponse accountClosingResponse = underTest.closeAccount(account);
        assertEquals(AccountClosingStatus.CLOSING_DENIED, accountClosingResponse.getStatus());
        assertEquals(LocalDateTime.ofInstant(fixedTime, ZoneId.systemDefault()),
                accountClosingResponse.getProcessingDate());
    }

    @Test
    public void shouldApproveAccountClosingTodayIfAccountHolderReachedRetirementAgeToday() throws IOException {
        Account account = new Account();
        final LocalDate dob = LocalDate.of(1955, 1, 1);
        account.setDob(dob);
        account.setFistName(FIRST_NAME);
        account.setLastName(LAST_NAME);
        account.setTaxId(TAX_ID);

        expect(backgroundCheckService.confirm(
                FIRST_NAME,
                LAST_NAME,
                TAX_ID,
                dob)).andReturn(new BackgroundCheckResults("not_unacceptable", 1000));

        replay(backgroundCheckService);
        final AccountClosingResponse accountClosingResponse = underTest.closeAccount(account);
        verify(backgroundCheckService);
        assertEquals(AccountClosingStatus.CLOSING_OK, accountClosingResponse.getStatus());
        assertEquals(LocalDateTime.ofInstant(fixedTime, ZoneId.systemDefault()),
                accountClosingResponse.getProcessingDate());
    }
}
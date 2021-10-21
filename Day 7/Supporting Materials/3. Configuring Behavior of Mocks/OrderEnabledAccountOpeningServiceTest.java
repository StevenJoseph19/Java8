package com.mycompany.pensionready.setup;

import static com.mycompany.pensionready.setup.AccountOpeningServiceTest.DOB;
import static com.mycompany.pensionready.setup.AccountOpeningServiceTest.FIRST_NAME;
import static com.mycompany.pensionready.setup.AccountOpeningServiceTest.LAST_NAME;
import static com.mycompany.pensionready.setup.AccountOpeningServiceTest.TAX_ID;
import static com.mycompany.pensionready.setup.AnnotationBasedAccountOpeningServiceTest.ACCEPTABLE_BACKGROUND_CHECK_RESULTS;
import static com.mycompany.pensionready.setup.AnnotationBasedAccountOpeningServiceTest.ACCOUNT_ID;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createStrictControl;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.same;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.easymock.IMocksControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.pensionready.AccountRepository;
import com.mycompany.pensionready.reporting.GovernmentDataPublisher;

public class OrderEnabledAccountOpeningServiceTest {

    private AccountOpeningService underTest;
    private BackgroundCheckService backgroundCheckService;
    private ReferenceIdsManager referenceIdsManager;
    private AccountRepository accountRepository;
    private GovernmentDataPublisher governmentDataPublisher;
    private IMocksControl strictControl;

    @BeforeEach
    public void setup() {
        strictControl = createStrictControl();
        backgroundCheckService = strictControl.createMock(BackgroundCheckService.class);
        referenceIdsManager = strictControl.createMock(ReferenceIdsManager.class);
        accountRepository = strictControl.createMock(AccountRepository.class);
        governmentDataPublisher = strictControl.createMock(GovernmentDataPublisher.class);
        underTest = new AccountOpeningService(
                backgroundCheckService,
                referenceIdsManager,
                accountRepository,
                governmentDataPublisher);
    }
    
    @Test
    public void shouldOpenAccount() throws IOException {
        expect(backgroundCheckService.confirm(
                FIRST_NAME,
                LAST_NAME,
                TAX_ID,
                DOB
        )).andReturn(ACCEPTABLE_BACKGROUND_CHECK_RESULTS);
        expect(referenceIdsManager.obtainId(
                eq(FIRST_NAME),
                anyString(),
                eq(LAST_NAME),
                eq(TAX_ID),
                eq(DOB)
        )).andReturn(ACCOUNT_ID);
        expect(accountRepository.save(
                eq(ACCOUNT_ID),
                eq(FIRST_NAME),
                eq(LAST_NAME),
                eq(TAX_ID),
                eq(DOB),
                same(ACCEPTABLE_BACKGROUND_CHECK_RESULTS)
        )).andReturn(true);
        governmentDataPublisher.publishAccountOpeningEvent(ACCOUNT_ID);
        expectLastCall().anyTimes();
        strictControl.replay();

    }
}

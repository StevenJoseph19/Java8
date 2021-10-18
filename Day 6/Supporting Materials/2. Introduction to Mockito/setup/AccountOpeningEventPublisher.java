package com.mycompany.pension.setup;

public interface AccountOpeningEventPublisher {

    void notify(String accountId);
}

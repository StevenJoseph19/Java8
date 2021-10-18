package com.mycompany.pension;

import java.time.LocalDate;

import com.mycompany.pension.setup.BackgroundCheckResults;

public interface AccountRepository {
    boolean save(String id, String firstName, String lastName, String taxId, LocalDate dob, BackgroundCheckResults backgroundCheckResults);

    boolean isExpired(Account account);
}

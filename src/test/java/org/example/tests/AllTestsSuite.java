package org.example.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        EmailConfirmationMatchTest.class,
        EmailFormatValidation.class,
        ValidFormSubmission.class
})
public class AllTestsSuite {
}

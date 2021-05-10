package vn.tcx.dw.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vn.tcx.dw.component.Result;

class CheckBeginUpperCaseWordValidatorTest {

    private CheckBeginUpperCaseWordValidator checker;

    @BeforeEach
    void beforEach() {
        // New instance checker before each case
        checker = new CheckBeginUpperCaseWordValidator();
    }

    @Test
    void testNewInstance() {
        Assertions.assertNotNull(checker);
    }

    @Test
    void caseNormal() {
        Assertions.assertEquals(Result.OK, checker.validate("Normalized new"));
    }
    
    @Test
    void caseFailedData() {
        Assertions.assertEquals(Result.FAILED, checker.validate("nguyen van a"));
    }
    
    @Test
    void caseBeginIsNumberAndAfterUpercase() {
        Assertions.assertEquals(Result.OK, checker.validate("12345677 Nguyen Van A"));
    }
}

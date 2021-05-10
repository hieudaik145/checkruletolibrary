package vn.tcx.dw.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vn.tcx.dw.component.Result;

class CheckSoVaDauGachNgangValidatorTest {

    private CheckSoVaDauGachNgangValidator checker;

    @BeforeEach
    void beforEach() {
        // New instance checker before each case
        checker = new CheckSoVaDauGachNgangValidator();
    }

    @Test
    void testNewInstance() {
        Assertions.assertNotNull(checker);
    }

    @Test
    void caseNormal1() {
        Assertions.assertEquals(Result.OK, checker.validate("123456789"));
    }

    @Test
    void caseNormal2() {
        Assertions.assertEquals(Result.OK, checker.validate(123L));
    }

    @Test
    void caseNormal4() {
        Assertions.assertEquals(Result.OK, checker.validate("10005-05"));
    }
    
    @Test
    void caseNormal5() {
        Assertions.assertEquals(Result.OK, checker.validate("00-0-12345-67-8"));
    }
    
    @Test
    void caseIncorrect1() {
        Assertions.assertEquals(Result.FAILED, checker.validate("-00012345678"));
    }
    
    @Test
    void caseIncorrect2() {
        Assertions.assertEquals(Result.FAILED, checker.validate("00012345678-"));
    }
    
    @Test
    void caseIncorrect3() {
        Assertions.assertEquals(Result.FAILED, checker.validate("000-12345a678"));
    }
    @Test
    void caseIncorrect4() {
        Assertions.assertEquals(Result.FAILED, checker.validate("-00012345678"));
    }
    @Test
    void caseIncorrect5() {
        Assertions.assertEquals(Result.FAILED, checker.validate("-00*012345678-"));
    }
    
    @Test
    void caseIncorrect6() {
        Assertions.assertEquals(Result.FAILED, checker.validate("-00012345678-"));
    }
    
    @Test
    void caseIncorrect7() {
        Assertions.assertEquals(Result.FAILED, checker.validate(12.05));
    }
}

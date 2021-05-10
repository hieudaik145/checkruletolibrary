package vn.tcx.dw.validator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vn.tcx.dw.component.Result;

class CheckNotContainSpecialCharacterValidatorTest {

    private static CheckNotContainSpecialCharacterValidator checker;

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll executed");
        checker = new CheckNotContainSpecialCharacterValidator();
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    @Test
    void testCallResponse() {

        System.out.println("@Test executed");
        Assertions.assertNotNull(checker);
    }

    @Test
    void caseVietNamese() {
        Result result = checker.validate("Trần Tiến Cường");
        Assertions.assertEquals(Result.OK, result);
    }

    @Test
    void caseNormalEnglish() {
        Result result = checker.validate("Harry potter");
        Assertions.assertEquals(Result.OK, result);
    }

    @Test
    void caseAssertFalse() {
        Assertions.assertEquals(Result.FAILED, checker.validate("Harry potter."));
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll executed");
    }
}

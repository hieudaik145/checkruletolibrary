package vn.tcx.dw.validator;

import java.util.Objects;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check string begin word uppercase first charcter
 * 
 * @author hieuvv
 * @since 1.0
 * @created 05/08/2020 16:48:07
 */
public class CheckBeginUpperCaseWordValidator implements Validator {

    private static boolean isValidate(String value) {
        for (int i = 0; i < value.length(); i++) {
            char temp = value.charAt(i);
            if (Character.isLetter(temp)) {
                return Character.isUpperCase(temp);
            }
        }

        return true;
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isValidate(value.toString()) ? Result.OK : Result.FAILED;
    }

}

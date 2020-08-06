package vn.tcx.dw.validator;

import java.util.Objects;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check is digits and gach ngang
 * 
 * @author hieuvv
 * @since 1.0
 * @created 05/08/2020 22:09:35
 */
public class CheckSoVaDauGachNgangValidator implements Validator {

    private static boolean isValidate(String value) {

        int length = value.length();

        for (int i = 0; i < length; i++) {

            char temp = value.charAt(i);
            if (!(Character.isDigit(temp) || temp == '-')) {
                return false;
            }

            if (temp == '-') {

                if (i == 0 || i == (length - 1)) {
                    return false;
                }

                if (!Character.isDigit(value.charAt(i - 1)) || !Character.isDigit(value.charAt(i + 1))) {
                    return false;
                }

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

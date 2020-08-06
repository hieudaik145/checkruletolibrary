package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.math.NumberUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check string is digits
 * 
 * @author hieuvv
 * @since 1.0
 * @created 05/08/2020 19:37:24
 */
public class CheckStringIsDigitsValidator implements Validator {

    private boolean isStringDigits(String value) {
        return NumberUtils.isDigits(value);
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isStringDigits(value.toString()) ? Result.OK : Result.FAILED;
    }

}

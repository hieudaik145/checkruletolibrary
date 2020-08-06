package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check String is all letter
 * 
 * @author hieuvv
 * @since 1.0
 * @created 27/07/2020 10:07:28
 */
public class CheckStringIsAllLetterValidator implements Validator {

    private static boolean isAllLetterValidate(String value) {
        return StringUtils.isAlphaSpace(value);
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isAllLetterValidate(value.toString()) ? Result.OK : Result.FAILED;
    }
    
}

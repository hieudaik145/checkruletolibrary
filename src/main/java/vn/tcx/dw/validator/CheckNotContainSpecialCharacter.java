package vn.tcx.dw.validator;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check not contain special character
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 17:04:02
 */
public class CheckNotContainSpecialCharacter implements Validator {

    private boolean isNotContainSpecialCharacter(String value) {

        return StringUtils.isAlphanumericSpace(value);
    }

    @Override
    public Result validate(Object value) {
        
        return isNotContainSpecialCharacter(value.toString()) ? Result.OK : Result.FAILED;
    }

}

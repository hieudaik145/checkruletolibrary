package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;
import vn.tcx.dw.utils.ConvertString;

/**
 * Define check not contain special character
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 17:04:02
 */
public class CheckNotContainSpecialCharacterValidator implements Validator {

    private boolean isNotContainSpecialCharacter(String value) {

        return StringUtils.isAlphanumericSpace(ConvertString.generateStringSearch(value));
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isNotContainSpecialCharacter(value.toString()) ? Result.OK : Result.FAILED;
    }
    
}

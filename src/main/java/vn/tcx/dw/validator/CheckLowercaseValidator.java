package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check lower case all string validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:32:00
 */
public class CheckLowercaseValidator implements Validator {

    private boolean isLowercase(String value) {

        return StringUtils.isAllLowerCase(value);
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isLowercase(value.toString()) ? Result.OK : Result.FAILED;
    }

}

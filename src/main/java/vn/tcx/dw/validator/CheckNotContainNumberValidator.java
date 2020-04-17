package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check not contain number validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:54:06
 */
public class CheckNotContainNumberValidator implements Validator {

    private boolean isNotContainNumber(String value) {

        return StringUtils.isAlphaSpace(value);
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isNotContainNumber(value.toString()) ? Result.OK : Result.FAILED;
    }

}

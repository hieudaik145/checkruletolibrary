package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check not contain characete (is number)
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:37:50
 */
public class CheckNotContainCharacterValidator implements Validator {

    private boolean isNumber(String value) {

        return StringUtils.isNumeric(value);
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isNumber(value.toString()) ? Result.OK : Result.FAILED;
    }

}

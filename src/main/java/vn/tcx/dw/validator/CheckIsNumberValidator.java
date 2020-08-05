package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.math.NumberUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Defince check data is number format java
 * 
 * @author hieuvv
 * @since 1.0
 * @created 05/08/2020 16:03:28
 */
public class CheckIsNumberValidator implements Validator {

    /**
     * method description (please change)
     * 
     * @update hieuvv
     * @lastModifier 05/08/2020 16:04:16
     * @param value
     * @return
     */
    @SuppressWarnings("deprecation")
    private boolean isNumberValidator(String value) {
        return NumberUtils.isNumber(value);
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }
        return isNumberValidator(value.toString()) ? Result.OK : Result.FAILED;
    }

}
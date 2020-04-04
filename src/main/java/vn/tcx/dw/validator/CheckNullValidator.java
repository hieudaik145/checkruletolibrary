package vn.tcx.dw.validator;

import java.util.Objects;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check null
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:36:09
 */
public class CheckNullValidator implements Validator {

    private boolean isNullValidator(Object value) {
        return !Objects.isNull(value);
    }

    @Override
    public Result validate(Object value) {

        return isNullValidator(value) ? Result.OK : Result.FAILED;
    }

}

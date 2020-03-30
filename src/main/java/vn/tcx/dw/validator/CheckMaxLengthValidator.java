package vn.tcx.dw.validator;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check max length validate
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:12:44
 */
@Setter
public class CheckMaxLengthValidator implements Validator {

    private long maxLength;

    private boolean isMaxLengthValidate(String value) {
        return value.length() <= maxLength;
    }

    @Override
    public Result validate(Object value) {

        return isMaxLengthValidate(value.toString()) ? Result.OK : Result.FAILED;
    }

}

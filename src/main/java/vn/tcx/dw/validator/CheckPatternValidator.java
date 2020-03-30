package vn.tcx.dw.validator;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check pattern validate
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:15:41
 */
@Setter
public class CheckPatternValidator implements Validator {

    private String pattern;

    private boolean isMatchPatternValidator(String value) {

        return value.matches(pattern);
    }

    @Override
    public Result validate(Object value) {

        return isMatchPatternValidator(value.toString()) ? Result.OK : Result.FAILED;
    }

}

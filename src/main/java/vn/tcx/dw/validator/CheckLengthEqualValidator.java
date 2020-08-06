package vn.tcx.dw.validator;

import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check length equal validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 05/08/2020 19:30:13
 */
@Setter
public class CheckLengthEqualValidator implements Validator {

    private long lengthEqual;

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return value.toString().length() == lengthEqual ? Result.OK : Result.FAILED;
    }

}

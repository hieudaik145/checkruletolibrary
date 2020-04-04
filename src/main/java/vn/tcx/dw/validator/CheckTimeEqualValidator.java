package vn.tcx.dw.validator;

import java.time.LocalTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check time equal validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:55:06
 */
@Setter
public class CheckTimeEqualValidator implements Validator {
    private LocalTime time;

    private boolean isEqualTimeValue(LocalTime value) {

        return value.equals(time);
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;

        if (value instanceof LocalTime) {
            isEqualTimeValue((LocalTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

package vn.tcx.dw.validator;

import java.time.LocalTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check time end validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:44:32
 */
@Setter
public class CheckTimeEndValidator implements Validator {

    private LocalTime timeEnd;

    private boolean isTimeStart(LocalTime value) {

        return value.isBefore(timeEnd);
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;

        if (value instanceof LocalTime) {
            kq = isTimeStart((LocalTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }

}
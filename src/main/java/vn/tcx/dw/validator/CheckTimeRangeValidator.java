package vn.tcx.dw.validator;

import java.time.LocalTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check time range validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:51:18
 */
@Setter
public class CheckTimeRangeValidator implements Validator {

    private LocalTime minTime;

    private LocalTime maxTime;

    private boolean isRangeTimeValue(LocalTime value) {

        if (value.equals(minTime) || value.equals(maxTime)) {
            return true;
        }

        return value.isAfter(minTime) && value.isBefore(maxTime);
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;

        if (value instanceof LocalTime) {
            isRangeTimeValue((LocalTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

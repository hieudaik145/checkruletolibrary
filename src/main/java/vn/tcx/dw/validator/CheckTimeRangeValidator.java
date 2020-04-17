package vn.tcx.dw.validator;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

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
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;

        if (value instanceof Time) {
            Time temp = (Time) value;
            isRangeTimeValue(temp.toLocalTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

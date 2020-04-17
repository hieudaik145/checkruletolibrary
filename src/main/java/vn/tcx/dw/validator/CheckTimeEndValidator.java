package vn.tcx.dw.validator;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

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
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;

        if (value instanceof Time) {

            Time time = (Time) value;
            kq = isTimeStart(time.toLocalTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }

}
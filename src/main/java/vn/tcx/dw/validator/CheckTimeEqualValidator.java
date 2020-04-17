package vn.tcx.dw.validator;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

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
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;

        if (value instanceof Time) {
            Time temp = (Time) value;
            isEqualTimeValue(temp.toLocalTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

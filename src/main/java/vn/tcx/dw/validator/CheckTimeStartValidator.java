package vn.tcx.dw.validator;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check time start validatora
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:41:07
 */
@Setter
public class CheckTimeStartValidator implements Validator {

    private LocalTime timeStart;

    private boolean isTimeStart(LocalTime value) {

        return value.isAfter(timeStart) || value.equals(timeStart);
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;

        if (value instanceof Time) {
            Time temp = (Time) value;
            isTimeStart(temp.toLocalTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

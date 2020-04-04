package vn.tcx.dw.validator;

import java.time.LocalTime;

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

        boolean kq = false;

        if (value instanceof LocalTime) {
            kq = isTimeStart((LocalTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

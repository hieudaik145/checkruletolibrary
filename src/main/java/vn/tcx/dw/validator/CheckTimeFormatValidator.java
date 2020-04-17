package vn.tcx.dw.validator;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check time is format validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:46:01
 */
@Setter
public class CheckTimeFormatValidator implements Validator {

    private String pattern;

    private boolean isFormatTime(String value) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

        LocalTime localTime = LocalTime.parse(value, dtf);

        if (localTime == null) {

            return false;
        }

        return true;
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;
        if (value instanceof Time) {
            kq = true;
        }
        kq = isFormatTime((String) value);

        return kq ? Result.OK : Result.FAILED;
    }

}

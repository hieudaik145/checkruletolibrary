package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check date greater than validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:15:06
 */
@Setter
public class CheckDateGreaterThanValidator implements Validator {

    private LocalDateTime dateTime;

    private boolean isGreaterThanTo(LocalDateTime value) {

        return value.isAfter(dateTime);
    }

    private boolean isGreaterThanLocalDate(LocalDate value) {

        return value.isAfter(dateTime.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;
        if (value instanceof LocalDate) {
            kq = isGreaterThanLocalDate((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            kq = isGreaterThanTo((LocalDateTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }
}

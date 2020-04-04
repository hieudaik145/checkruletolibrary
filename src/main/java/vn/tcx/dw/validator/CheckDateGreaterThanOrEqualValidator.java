package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check date greater than or equal validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:17:57
 */
@Setter
public class CheckDateGreaterThanOrEqualValidator implements Validator {

    private LocalDateTime dateTime;

    private boolean isGreaterThanOrEqualTo(LocalDateTime value) {

        return value.isAfter(dateTime) || value.isEqual(dateTime);
    }

    private boolean isGreaterThanOrEqualLocalDate(LocalDate value) {

        return value.isAfter(dateTime.toLocalDate()) || value.isEqual(dateTime.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;
        if (value instanceof LocalDate) {
            kq = isGreaterThanOrEqualLocalDate((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            kq = isGreaterThanOrEqualTo((LocalDateTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }
}
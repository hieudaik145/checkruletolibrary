package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check Date greater than to day validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:29:20
 */
public class CheckDateGreaterThanTodayValidator implements Validator {

    private LocalDateTime toDay;

    private boolean isGreaterThanOrEqualTo(LocalDateTime value) {

        return value.isAfter(toDay) || value.isEqual(toDay);
    }

    private boolean isGreaterThanOrEqualLocalDate(LocalDate value) {

        return value.isAfter(toDay.toLocalDate()) || value.isEqual(toDay.toLocalDate());
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
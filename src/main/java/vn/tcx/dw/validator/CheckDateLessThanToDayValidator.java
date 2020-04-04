package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check date less than to day
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:26:56
 */
public class CheckDateLessThanToDayValidator implements Validator {

    private LocalDateTime toDay;

    private boolean isLessThanTo(LocalDateTime value) {

        return value.isBefore(toDay) || value.isEqual(toDay);
    }

    private boolean isLessThanLocalDate(LocalDate value) {

        return value.isBefore(toDay.toLocalDate()) || value.isEqual(toDay.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;
        if (value instanceof LocalDate) {
            kq = isLessThanLocalDate((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            kq = isLessThanTo((LocalDateTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }
}
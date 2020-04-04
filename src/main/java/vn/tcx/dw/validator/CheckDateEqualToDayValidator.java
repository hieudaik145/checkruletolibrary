package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check date equal to day validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:24:52
 */
public class CheckDateEqualToDayValidator implements Validator {

    private LocalDateTime toDay = LocalDateTime.now();

    private boolean isLessThanTo(LocalDateTime value) {

        return value.isEqual(toDay);
    }

    private boolean isLessThanLocalDate(LocalDate value) {

        return value.isEqual(toDay.toLocalDate());
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
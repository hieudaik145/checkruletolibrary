package vn.tcx.dw.validator;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

    private LocalDateTime toDay = LocalDateTime.now();

    private boolean isGreaterThanOrEqualTo(LocalDateTime value) {

        return value.isAfter(toDay) || value.isEqual(toDay);
    }

    private boolean isGreaterThanOrEqualLocalDate(LocalDate value) {

        return value.isAfter(toDay.toLocalDate()) || value.isEqual(toDay.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;
        if (value instanceof Date) {
            Date temp = (Date) value;
            kq = isGreaterThanOrEqualLocalDate(temp.toLocalDate());
        } else if (value instanceof Timestamp) {

            Timestamp temp = (Timestamp) value;
            kq = isGreaterThanOrEqualTo(temp.toLocalDateTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }
}
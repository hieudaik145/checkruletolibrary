package vn.tcx.dw.validator;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;

        if (value instanceof Date) {
            Date date = (Date) value;
            kq = isLessThanLocalDate(date.toLocalDate());
        } else if (value instanceof Timestamp) {

            Timestamp dateTime = (Timestamp) value;
            kq = isLessThanTo(dateTime.toLocalDateTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }
}
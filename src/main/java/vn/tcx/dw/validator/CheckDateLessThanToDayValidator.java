package vn.tcx.dw.validator;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

    private LocalDateTime toDay = LocalDateTime.now();

    private boolean isLessThanTo(LocalDateTime value) {

        return value.isBefore(toDay) || value.isEqual(toDay);
    }

    private boolean isLessThanLocalDate(LocalDate value) {

        return value.isBefore(toDay.toLocalDate()) || value.isEqual(toDay.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        if (value instanceof Date) {
            Date date = (Date) value;
            kq = isLessThanLocalDate(date.toLocalDate());
        }  else if (value instanceof Timestamp) {

            Timestamp dateTime = (Timestamp) value;
            kq = isLessThanTo(dateTime.toLocalDateTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }
}
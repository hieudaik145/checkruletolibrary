package vn.tcx.dw.validator;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check date less than or equal validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:23:12
 */
@Setter
public class CheckDateLessThanOrEqualValidator implements Validator {

    private LocalDateTime dateTime;

    private boolean isLessThanTo(LocalDateTime value) {

        return value.isBefore(dateTime) || value.isEqual(dateTime);
    }

    private boolean isLessThanLocalDate(LocalDate value) {

        return value.isBefore(dateTime.toLocalDate()) || value.isEqual(dateTime.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        if (value instanceof Date) {
            Date temp = (Date) value;
            kq = isLessThanLocalDate(temp.toLocalDate());
        } else if (value instanceof Timestamp) {

            Timestamp temp = (Timestamp) value;
            kq = isLessThanTo(temp.toLocalDateTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }
}
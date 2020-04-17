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
 * Check date less than validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:21:17
 */
@Setter
public class CheckDateLessThanValidator implements Validator {

    private LocalDateTime dateTime;

    private boolean isLessThanTo(LocalDateTime value) {

        return value.isBefore(dateTime);
    }

    private boolean isLessThanLocalDate(LocalDate value) {

        return value.isBefore(dateTime.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }
        boolean kq = false;

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
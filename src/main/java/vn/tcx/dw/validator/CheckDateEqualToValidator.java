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
 * Check date is equal to
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:52:40
 */
@Setter
public class CheckDateEqualToValidator implements Validator {

    private LocalDateTime date;

    private boolean isEqualTo(LocalDateTime value) {

        return value.isEqual(date);
    }

    private boolean isEqualToLocalDate(LocalDate value) {

        return value.isEqual(date.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        boolean kq = false;

        if (value instanceof Date) {
            Date temp = (Date) value;
            kq = isEqualToLocalDate(temp.toLocalDate());
        } else if (value instanceof Timestamp) {

            Timestamp dateTime = (Timestamp) value;
            kq = isEqualTo(dateTime.toLocalDateTime());
        }

        return kq ? Result.OK : Result.FAILED;
    }
}

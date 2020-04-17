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
 * Check date greater than validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:15:06
 */
@Setter
public class CheckDateGreaterThanValidator implements Validator {

    private LocalDateTime dateTime;

    private boolean isGreaterThanTo(LocalDateTime value) {

        return value.isAfter(dateTime);
    }

    private boolean isGreaterThanLocalDate(LocalDate value) {

        return value.isAfter(dateTime.toLocalDate());
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;
        if (Objects.isNull(value)) {

            return Result.OK;

        }

        if (value instanceof Date) {
            Date temp = (Date) value;
            kq = isGreaterThanLocalDate(temp.toLocalDate());
        } else if (value instanceof Timestamp) {

            Timestamp temp = (Timestamp) value;
            kq = isGreaterThanTo(temp.toLocalDateTime());
        }
        return kq ? Result.OK : Result.FAILED;
    }
}

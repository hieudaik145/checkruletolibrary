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
 * Check date greater than or equal validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:17:57
 */
@Setter
public class CheckDateGreaterThanOrEqualValidator implements Validator {

    private LocalDateTime dateTime;

    private boolean isGreaterThanOrEqualTo(LocalDateTime value) {

        System.out.println("VALUE " + value + "COMPARE " + dateTime);
        return value.compareTo(dateTime) >= 0;
    }

    private boolean isGreaterThanOrEqualLocalDate(LocalDate value) {

        return value.compareTo(dateTime.toLocalDate()) >= 0;
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
        } else {
            System.out.println("KHONG THUOC TYPE DATE");
        }

        return kq ? Result.OK : Result.FAILED;
    }

}
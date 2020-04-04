package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check date in range validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:30:04
 */
@Setter
public class CheckDateInRangeValidator implements Validator {

    private LocalDateTime minDate;

    private LocalDateTime maxDate;

    private boolean isRangeValueLocalDate(LocalDate value) {

        if (value.isEqual(minDate.toLocalDate()) || value.isEqual(maxDate.toLocalDate())) {
            return true;
        }

        return value.isAfter(minDate.toLocalDate()) && value.isBefore(maxDate.toLocalDate());
    }

    private boolean isRangeValueLocalDateTime(LocalDateTime value) {

        if (value.isEqual(minDate) || value.isEqual(maxDate)) {
            return true;
        }

        return value.isAfter(minDate) && value.isBefore(maxDate);
    }

    @Override
    public Result validate(Object value) {

        boolean kq = false;
        if (value instanceof LocalDate) {
            kq = isRangeValueLocalDate((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            kq = isRangeValueLocalDateTime((LocalDateTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

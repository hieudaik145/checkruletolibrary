package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check not equal validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 16:09:53
 */
@Setter
public class CheckDateNotEqualValidator implements Validator {

    private LocalDateTime date;

    private boolean isEqualTo(LocalDateTime value) {

        return !value.isEqual(date);
    }

    private boolean isEqualToLocalDate(LocalDate value) {

        return !value.isEqual(date.toLocalDate());
    }

    @Override
    public Result validate(Object value) {
        boolean kq = false;
        if (value instanceof LocalDate) {
            kq = isEqualToLocalDate((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            kq = isEqualTo((LocalDateTime) value);
        }

        return kq ? Result.OK : Result.FAILED;
    }

}

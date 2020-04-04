package vn.tcx.dw.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check is date validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:40:25
 */
@Setter
public class CheckIsDateValidator implements Validator {

    private String pattern;

    private boolean isDate(String value) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

        LocalDate localDate = LocalDate.parse(value, dtf);

        if (localDate == null) {
            return false;
        }

        return true;

    }

    @Override
    public Result validate(Object value) {

        if (value instanceof LocalDate || value instanceof LocalDateTime) {
            return Result.OK;
        }

        return isDate(value.toString()) ? Result.OK : Result.FAILED;
    }

}

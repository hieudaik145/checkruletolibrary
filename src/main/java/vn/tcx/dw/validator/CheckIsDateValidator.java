package vn.tcx.dw.validator;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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


    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        if (value instanceof Timestamp || value instanceof Date) {
            return Result.OK;
        } else {
            return Result.FAILED;
        }
        

    }

}

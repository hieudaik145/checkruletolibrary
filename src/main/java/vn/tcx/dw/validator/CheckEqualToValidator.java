package vn.tcx.dw.validator;

import java.math.BigDecimal;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check number equal to validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:14:03
 */
@Setter
public class CheckEqualToValidator implements Validator {

    private long valueInteger;

    private BigDecimal valueBigDecimal;

    private boolean isInteger;

    private boolean isEqualTo(long value) {

        return valueInteger == value;
    }

    private boolean isEqualBigDecimal(BigDecimal value) {

        return value.compareTo(valueBigDecimal) == 0;
    }

    @Override
    public Result validate(Object value) {

        if (isInteger) {

            return isEqualTo((long) value) ? Result.OK : Result.FAILED;
        }

        double number = (double) value;

        return isEqualBigDecimal(BigDecimal.valueOf(number)) ? Result.OK : Result.FAILED;
    }

}

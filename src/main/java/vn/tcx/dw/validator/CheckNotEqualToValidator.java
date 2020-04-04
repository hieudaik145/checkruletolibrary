package vn.tcx.dw.validator;

import java.math.BigDecimal;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check not equal to validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:18:19
 */
@Setter
public class CheckNotEqualToValidator implements Validator {

    private long valueInteger;

    private BigDecimal valueBigDecimal;

    private boolean isInteger;

    private boolean isNotEqualTo(long value) {

        return valueInteger != value;
    }

    private boolean isNotEqualBigDecimal(BigDecimal value) {

        return value.compareTo(valueBigDecimal) != 0;
    }

    @Override
    public Result validate(Object value) {

        if (isInteger) {

            return isNotEqualTo((long) value) ? Result.OK : Result.FAILED;
        }

        double number = (double) value;

        return isNotEqualBigDecimal(BigDecimal.valueOf(number)) ? Result.OK : Result.FAILED;
    }

}
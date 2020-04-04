package vn.tcx.dw.validator;

import java.math.BigDecimal;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check value range validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:03:01
 */
@Setter
public class CheckValueRangeValidator implements Validator {

    private long minValue;

    private long maxValue;

    private BigDecimal minValueDecimal;

    private BigDecimal maxValueDecimal;

    private boolean isInteger;

    private boolean isValueRangeInteger(long value) {

        return value >= minValue && value <= maxValue;
    }

    private boolean isValueRangeDecimal(BigDecimal value) {

        return value.compareTo(minValueDecimal) >= 0 && value.compareTo(maxValueDecimal) <= 0;
    }

    @Override
    public Result validate(Object value) {

        if (isInteger) {

            return isValueRangeInteger((long) value) ? Result.OK : Result.FAILED;
        }

        double decimal = (double) value;

        return isValueRangeDecimal(BigDecimal.valueOf(decimal)) ? Result.OK : Result.FAILED;
    }

}

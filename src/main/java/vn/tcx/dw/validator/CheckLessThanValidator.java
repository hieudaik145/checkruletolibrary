package vn.tcx.dw.validator;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check number less than
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 13:54:31
 */
@Setter
public class CheckLessThanValidator implements Validator {

    private Long valueInt;

    private BigDecimal bigDecimal;

    private boolean isInteger;

    private boolean isLessNumber(Long value) {

        return value > valueInt;
    }

    private boolean isLessDecimal(BigDecimal value) {

        return value.compareTo(bigDecimal) > 0;
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        if (isInteger) {
            long temp = (long) value;
            return isLessNumber(temp) ? Result.OK : Result.FAILED;
        }

        double number = (double) value;
        BigDecimal temp = BigDecimal.valueOf(number);

        return isLessDecimal(temp) ? Result.OK : Result.FAILED;
    }
}

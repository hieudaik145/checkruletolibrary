package vn.tcx.dw.validator;

import java.math.BigDecimal;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check greate than or equal to
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 13:50:26
 */
@Setter
public class CheckGreaterThanOrEqualToValidator implements Validator {

    private Long valueInt;

    private BigDecimal bigDecimal;

    private boolean isInteger;

    private boolean isGreaterOrEqualNumber(Long value) {

        return value >= valueInt;
    }

    private boolean isGreaterOrEqualDecimal(BigDecimal value) {

        return value.compareTo(bigDecimal) >= 0;
    }

    @Override
    public Result validate(Object value) {

        if (isInteger) {
            long temp = (long) value;
            return isGreaterOrEqualNumber(temp) ? Result.OK : Result.FAILED;
        }

        double number = (double) value;
        BigDecimal temp = BigDecimal.valueOf(number);

        return isGreaterOrEqualDecimal(temp) ? Result.OK : Result.FAILED;
    }

}

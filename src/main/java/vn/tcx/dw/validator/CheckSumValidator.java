package vn.tcx.dw.validator;

import java.math.BigDecimal;
import java.util.List;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check sum validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:25:17
 */
@Setter
public class CheckSumValidator implements Validator {

    private List<Long> valueSumInteger;

    private List<BigDecimal> valueSumBigDecimal;

    private boolean isInteger;

    private boolean isSumValueInteger(long value) {

        long sumValue = 0;

        for (long temp : valueSumInteger) {

            sumValue += temp;
        }

        return sumValue == value;
    }

    private boolean isSumValueBigDecimal(BigDecimal value) {

        BigDecimal sumValue = BigDecimal.ZERO;

        for (BigDecimal bigDecimal : valueSumBigDecimal) {

            sumValue = sumValue.add(bigDecimal);
        }

        return value.compareTo(sumValue) == 0;
    }

    @Override
    public Result validate(Object value) {

        if (isInteger) {
            return isSumValueInteger((long) value) ? Result.OK : Result.FAILED;
        }

        double number = (double) value;

        return isSumValueBigDecimal(BigDecimal.valueOf(number)) ? Result.OK : Result.FAILED;
    }

}

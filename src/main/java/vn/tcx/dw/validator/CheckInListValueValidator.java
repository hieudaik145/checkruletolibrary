package vn.tcx.dw.validator;

import java.math.BigDecimal;
import java.util.List;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check number in list value number validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:19:49
 */
@Setter
public class CheckInListValueValidator implements Validator {

    private List<Long> listValueInteger;

    private List<BigDecimal> listValueBigDecimal;

    private boolean isInteger;

    private boolean isInListValueInteger(long value) {

        return listValueInteger.contains(value);
    }

    private boolean isInListValueBigDecimal(BigDecimal value) {

        return listValueBigDecimal.contains(value);
    }

    @Override
    public Result validate(Object value) {

        if (isInteger) {
            return isInListValueInteger((long) value) ? Result.OK : Result.FAILED;
        }

        double number = (double) value;

        return isInListValueBigDecimal(BigDecimal.valueOf(number)) ? Result.OK : Result.FAILED;
    }

}

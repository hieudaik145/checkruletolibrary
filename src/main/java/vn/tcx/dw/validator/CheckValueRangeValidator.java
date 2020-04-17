package vn.tcx.dw.validator;

import java.util.Objects;

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

    private boolean isValueRangeInteger(long value) {

        return value >= minValue && value <= maxValue;
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        try {
            long valueCheck = 0;
            if (value instanceof Double) {
                Double nd = (Double) value;
                valueCheck = nd.longValue();
            } else if (value instanceof Float) {
                Float nf = (Float) value;
                valueCheck = nf.longValue();
            } else {
                valueCheck = Long.valueOf(value.toString());
            }

            return isValueRangeInteger(valueCheck) ? Result.OK : Result.FAILED;

        } catch (Exception e) {
            e.printStackTrace();
            return Result.FAILED;
        }
    }

}

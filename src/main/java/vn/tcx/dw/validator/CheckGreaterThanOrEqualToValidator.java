package vn.tcx.dw.validator;

import java.util.Objects;

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

    private long valueInt;

    private boolean isGreaterOrEqualNumber(long value) {

        return value >= valueInt;
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

            return isGreaterOrEqualNumber(valueCheck) ? Result.OK : Result.FAILED;

        } catch (Exception e) {
            e.printStackTrace();
            return Result.FAILED;
        }
    }

}

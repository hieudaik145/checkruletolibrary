package vn.tcx.dw.validator;

import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check greater than number validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 17:37:25
 */
@Setter
public class CheckGreaterThanValidator implements Validator {

    private long valueInt;

    private boolean isGreaterNumber(long value) {

        return value > valueInt;
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

            return isGreaterNumber(valueCheck) ? Result.OK : Result.FAILED;

        } catch (Exception e) {
            e.printStackTrace();
            return Result.FAILED;
        }

    }

}

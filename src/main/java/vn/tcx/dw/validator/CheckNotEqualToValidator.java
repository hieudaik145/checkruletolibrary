package vn.tcx.dw.validator;

import java.util.Objects;

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

    private boolean isNotEqualTo(long value) {

        return valueInteger != value;
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

            return isNotEqualTo(valueCheck) ? Result.OK : Result.FAILED;

        } catch (Exception e) {
            e.printStackTrace();
            return Result.FAILED;
        }
    }

}
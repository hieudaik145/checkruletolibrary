package vn.tcx.dw.validator;

import java.util.List;
import java.util.Objects;

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

    private boolean isInListValueInteger(long value) {

        return listValueInteger.contains(value);
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

            return isInListValueInteger(valueCheck) ? Result.OK : Result.FAILED;

        } catch (Exception e) {
            e.printStackTrace();
            return Result.FAILED;
        }
    }

}

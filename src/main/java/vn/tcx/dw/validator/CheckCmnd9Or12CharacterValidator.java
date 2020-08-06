package vn.tcx.dw.validator;

import java.util.Objects;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check number cmnd 9 or 12 character
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/08/2020 18:01:30
 */
public class CheckCmnd9Or12CharacterValidator implements Validator {

    /**
     * Perform check Cmnd have 9 or 12 character
     * 
     * @update hieuvv
     * @lastModifier 03/08/2020 18:00:29
     * @param value
     * @return
     */
    private boolean isValidate(String value) {

        int length = value.length();

        return length == 9 || length == 12;
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isValidate(value.toString()) ? Result.OK : Result.FAILED;
    }

}

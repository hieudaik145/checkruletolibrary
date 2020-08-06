package vn.tcx.dw.validator;

import java.util.Objects;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check định dạng số điện thoại di động việt nam
 * 
 * @author hieuvv
 * @since 1.0
 * @created 05/08/2020 19:48:30
 */
public class CheckSdtDiDongValiator implements Validator {

    private boolean isValidate(String value) {

        return true;
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return Result.OK;
    }

}

package vn.tcx.dw.validator;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check empty validate check
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:56:05
 */
public class CheckEmptyValidator implements Validator {

    private boolean isEmpty(String value) {
        return !StringUtils.isEmpty(value);
    }

    @Override
    public Result validate(Object value) {

        return isEmpty(value.toString()) ? Result.OK : Result.FAILED;
    }

}

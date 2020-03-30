package vn.tcx.dw.validator;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check mix validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:46:51
 */
public class CheckMixValidator implements Validator {

    private boolean isMixValidate(String value) {

        return StringUtils.isMixedCase(value);
    }

    @Override
    public Result validate(Object value) {

        return isMixValidate(value.toString()) ? Result.OK : Result.FAILED;
    }

}

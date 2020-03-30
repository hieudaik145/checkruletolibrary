package vn.tcx.dw.validator;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check upper case validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:28:12
 */
public class CheckUppercaseValidator implements Validator {

    private boolean isUpperCase(String value) {

        return StringUtils.isAllUpperCase(value);
    }

    @Override
    public Result validate(Object value) {

        return isUpperCase(value.toString()) ? Result.OK : Result.FAILED;
    }

}

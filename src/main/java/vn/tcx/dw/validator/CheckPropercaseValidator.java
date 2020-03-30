package vn.tcx.dw.validator;

import org.apache.commons.lang3.StringUtils;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check proper case string validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:34:52
 */
public class CheckPropercaseValidator implements Validator {

    private boolean isProperCase(String value) {

        String[] words = StringUtils.split(value,StringUtils.SPACE);

        for (String word : words) {
            if (!StringUtils.isAllLowerCase(StringUtils.substring(word, 0, 1))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Result validate(Object value) {

        return isProperCase(value.toString()) ? Result.OK : Result.FAILED;
    }

}

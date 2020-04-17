package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check end with a specific string
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:24:31
 */
@Setter
public class CheckEndWithASpecificStringValidator implements Validator {

    private String specific;

    private boolean isEndWithASpecificString(String value) {

        return StringUtils.endsWith(value, specific);
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isEndWithASpecificString(value.toString()) ? Result.OK : Result.FAILED;
    }

}

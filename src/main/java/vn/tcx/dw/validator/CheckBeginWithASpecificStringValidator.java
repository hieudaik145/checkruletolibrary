package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check begin with a specific string
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:21:53
 */
@Setter
public class CheckBeginWithASpecificStringValidator implements Validator {

    private String specific;

    private boolean isBeginWithASpecificString(String value) {

        return StringUtils.startsWith(value, specific);
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }
        return isBeginWithASpecificString(value.toString()) ? Result.OK : Result.FAILED;
    }

}

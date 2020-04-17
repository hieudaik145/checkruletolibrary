package vn.tcx.dw.validator;

import java.util.List;
import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check string in list validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:43:15
 */
@Setter
public class CheckStringInListValidator implements Validator {

    private List<String> listStrings;

    private boolean isStringInList(String value) {

        return listStrings.contains(value);
    }

    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isStringInList(value.toString()) ? Result.OK : Result.FAILED;
    }

}

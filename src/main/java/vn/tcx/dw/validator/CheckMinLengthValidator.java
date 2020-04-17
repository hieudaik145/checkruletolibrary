package vn.tcx.dw.validator;

import java.util.Objects;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define Check min length string validate
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 16:05:44
 */
@Setter
public class CheckMinLengthValidator implements Validator {

    private long minLength;
    
    private boolean isMinLengthValidate(String value) {
        
        return value.length() >= minLength;
    }
    
    @Override
    public Result validate(Object value) {
        
        if (Objects.isNull(value)) {
            return Result.OK;
        }
        
        return isMinLengthValidate(value.toString()) ? Result.OK : Result.FAILED;
    }

    
}

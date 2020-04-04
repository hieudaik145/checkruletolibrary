package vn.tcx.dw.validator;

import org.apache.commons.lang3.StringUtils;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Define check contain a sub string validate 
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 16:19:25
 */
@Setter
public class CheckContainASubStringValidator implements Validator {

    private String subString;
    
    private boolean isContainsASubString(String value) {
        
        return StringUtils.contains(value, subString);
    }

    @Override
    public Result validate(Object value) {
        
        return isContainsASubString(value.toString()) ? Result.OK : Result.FAILED;
    }
    
}

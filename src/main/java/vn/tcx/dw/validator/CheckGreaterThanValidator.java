package vn.tcx.dw.validator;

import java.math.BigDecimal;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check greater than number validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 17:37:25
 */
@Setter
public class CheckGreaterThanValidator implements Validator {
    

    private Long valueInt;
    
    private BigDecimal bigDecimal;
    
    private boolean isLong;
    
    private boolean isGreaterNumber(Long value) {
        
        return value > valueInt;
    }
    
    private boolean isGreaterDecimal(BigDecimal value) {
        
        return value.compareTo(bigDecimal) > 0;
    }
    
    @Override
    public Result validate(Object value) {
        if (isLong) {
            long temp = (long) value;
            return isGreaterNumber(temp) ? Result.OK : Result.FAILED;
        }
        
        Double number = (Double) value;
        BigDecimal temp = BigDecimal.valueOf(number);
        
        return isGreaterDecimal(temp) ? Result.OK : Result.FAILED;
    }

}

package vn.tcx.dw.validator;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import lombok.Setter;
import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;

/**
 * Check number of degit validator
 * 
 * @author hieuvv
 * @since 1.0
 * @created 03/04/2020 15:10:38
 */
@Setter
public class CheckNumberOfDigitValidator implements Validator {

    private long numberOfDigit;

    private boolean isNumberOfDigit(String value) {

        String numberValue = StringUtils.getDigits(value);
        
        return StringUtils.length(numberValue) == numberOfDigit;
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            System.out.println("value is null Result check is OK");
            return Result.OK;
        }

        return isNumberOfDigit(value.toString()) ? Result.OK : Result.FAILED;
    }

}

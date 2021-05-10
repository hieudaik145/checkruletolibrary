package vn.tcx.dw.validator;

import java.util.Objects;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;
import vn.tcx.dw.utils.ConvertString;

/**
 * Define check proper case string validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 16:34:52
 */
public class CheckPropercaseValidator implements Validator {

    private static boolean isProperCase(String value) {
        
        String[] words = ConvertString.generateStringSearch(value).split("[^a-zA-Z^']");
        for (String word : words) {
            if (!word.isEmpty() && !word.matches("M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
                final char temp = word.charAt(0);
                if (temp >= 97 && temp <= 122) {
                    return false;
                }
                if (word.length() > 1) {
                    for (int i = 1; i < word.length(); i++) {
                        char charAt = word.charAt(i);
                        if (charAt >= 65 && charAt <= 90) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isProperCase("Ðặng Công Thuận"));
    }

    @Override
    public Result validate(Object value) {

        if (Objects.isNull(value)) {
            return Result.OK;
        }

        return isProperCase(value.toString()) ? Result.OK : Result.FAILED;
    }

}

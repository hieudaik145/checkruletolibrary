package vn.tcx.dw.rule;


import lombok.Data;
import vn.tcx.dw.component.Validator;

/**
 * Define Standard Validate
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:49:03
 */
@Data
public class StandardValidate {

    private long standardId;
    
    private Validator validator;
}

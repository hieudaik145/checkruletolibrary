package vn.tcx.dw.rule;

import java.util.List;

import lombok.Data;

/**
 * Define Field Validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:48:15
 */
@Data
public class FieldValidate {

    private Object value;

    private List<RuleValidate> ruleValidates;

    private long sourceColumnId;

}

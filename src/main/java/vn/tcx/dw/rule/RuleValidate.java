package vn.tcx.dw.rule;

import java.util.List;

import lombok.Data;

/**
 * Define Rule Validate
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:48:53
 */
@Data
public class RuleValidate {

    private List<StandardValidate> standardValidates;
    
    private long ruleId;
    
    private long actionId;
    
    private long statusId;
    
}

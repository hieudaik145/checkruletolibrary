
package vn.tcx.dw.rule;

import lombok.Data;

/**
 * Define Result Error
 * class description (please change)
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:48:31
 */
@Data
public class ResultError {

    private long ruleId;

    private long actionId;

    private long statusId;

    private long auditTableId;

    private long auditRowId;
    
    private long sourceColumnId;

    private long standardId;
}

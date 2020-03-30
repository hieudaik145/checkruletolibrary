
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

    private int ruleId;

    private int actionId;

    private int statusId;

    private int auditTableId;

    private int auditRowId;
    
    private int sourceRowId;

    private int sourceColumnId;

    private int standardId;
}

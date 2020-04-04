package vn.tcx.dw.rule;

import java.util.List;

import lombok.Data;

/**
 * Define Row Validate
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:48:42
 */
@Data
public class RowValidate {

    private List<FieldValidate> fieldValidates;

    private long idAuditRow;

}

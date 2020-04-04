package vn.tcx.dw.service;

import java.util.ArrayList;
import java.util.List;

import vn.tcx.dw.rule.FieldValidate;
import vn.tcx.dw.rule.ResultError;
import vn.tcx.dw.rule.RowValidate;

/**
 * Define row validate service
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:51:23
 */
public class RowValidateService {

    FieldValidateService fieldValidateService = new FieldValidateService();

    /**
     * Perform call method apply field validate 
     * method description (please change)
     * @update hieuvv
     * @lastModifier 30/03/2020 15:51:47
     * @param rowValidate
     * @return
     */
    public List<ResultError> applyRowValidate(RowValidate rowValidate) {

        // crate list result error
        List<ResultError> resultErrorLst = new ArrayList<>();

        // for each field validate
        for (FieldValidate fieldValidate : rowValidate.getFieldValidates()) {

            // perform check each field validate
            List<ResultError> tempResultErrors = fieldValidateService.applyFieldValidate(fieldValidate);

            // if list result error of field validate not null
            if (!tempResultErrors.isEmpty()) {

                // peform add info row validate to resultError
                tempResultErrors.forEach(x -> {
                    x.setAuditRowId(rowValidate.getIdAuditRow());
                });

                // add all result error of field validate to result error of row validate
                resultErrorLst.addAll(tempResultErrors);
            }

        }

        return resultErrorLst;

    }
}

package vn.tcx.dw.service;

import vn.tcx.dw.composite.CompositeResult;
import vn.tcx.dw.rule.CompositeRule;
import vn.tcx.dw.rule.ResultError;
import vn.tcx.dw.rule.StandardValidate;

/**
 * Define standard validate service
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:53:32
 */
public class StandardValidateService {

    /**
     * This method perform apply validate 
     * @update hieuvv
     * @lastModifier 30/03/2020 15:53:48
     * @param standardValidate
     * @param value
     * @return
     */
    public ResultError applyStandardValidate(StandardValidate standardValidate, Object value) {

        // create result error
        ResultError resultError = null;

        // add composite rule
        CompositeRule rule = new CompositeRule(standardValidate.getValidator());

        // perform validate standard
        CompositeResult result = rule.validate(value);
        
        // if result is ok then add info standarad validate to result
        if (!result.isOk()) {
            resultError = new ResultError();
            resultError.setStandardId(standardValidate.getStandardId());
        }

        return resultError;

    }
}

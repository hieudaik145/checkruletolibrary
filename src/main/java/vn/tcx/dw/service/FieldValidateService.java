package vn.tcx.dw.service;

import java.util.ArrayList;
import java.util.List;

import vn.tcx.dw.rule.FieldValidate;
import vn.tcx.dw.rule.ResultError;
import vn.tcx.dw.rule.RuleValidate;

/**
 * Define filed validate service
 * class description (please change)
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:49:29
 */
public class FieldValidateService {

    RuleValidateService ruleValidateService = new RuleValidateService();

    /**
     * Perform call method rule validate
     * 
     * @update hieuvv
     * @lastModifier 30/03/2020 15:49:46
     * @param fieldValidate
     * @return ResultErrot list
     */
    public List<ResultError> applyFieldValidate(FieldValidate fieldValidate) {

        // create list result errors
        List<ResultError> resultErrorLst = new ArrayList<>();

        // for each rule validate of filed validate
        for (RuleValidate ruleValidate : fieldValidate.getRuleValidates()) {

            // perform check validate of rule validate
            List<ResultError> tempResultErrors = ruleValidateService.applyRulValidate(ruleValidate,
                    fieldValidate.getValue());

            // if list result error not empty add to result list
            if (!tempResultErrors.isEmpty()) {
                tempResultErrors.forEach(x -> {
                    x.setSourceColumnId(fieldValidate.getSourceColumnId());
                });
                resultErrorLst.addAll(tempResultErrors);
            }

        }

        return resultErrorLst;
    }

}

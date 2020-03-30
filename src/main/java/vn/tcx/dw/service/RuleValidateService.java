package vn.tcx.dw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import vn.tcx.dw.rule.ResultError;
import vn.tcx.dw.rule.RuleValidate;
import vn.tcx.dw.rule.StandardValidate;

/**
 * Define rule validate service
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:52:45
 */
public class RuleValidateService {

    StandardValidateService standardValidateService = new StandardValidateService();

    /**
     * Perform call method standard validate 
     * @update hieuvv
     * @lastModifier 30/03/2020 15:52:59
     * @param ruleValidate
     * @param value
     * @return
     */
    public List<ResultError> applyRulValidate(RuleValidate ruleValidate, Object value) {

        List<ResultError> resultErrorLst = new ArrayList<>();

        // for each standard validate
        for (StandardValidate standardValidate : ruleValidate.getStandardValidates()) {

            // get result error when validate standard
            ResultError resultError = standardValidateService.applyStandardValidate(standardValidate, value);

            // check if result error not null then add info rule validate
            if (!Objects.isNull(resultError)) {

                resultError.setRuleId(ruleValidate.getRuleId());
                resultError.setActionId(ruleValidate.getActionId());
                resultError.setStatusId(ruleValidate.getStatusId());

                resultErrorLst.add(resultError);
            }
        }

        return resultErrorLst;

    }
}

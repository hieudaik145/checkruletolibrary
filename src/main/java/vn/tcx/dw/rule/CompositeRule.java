package vn.tcx.dw.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import vn.tcx.dw.component.Result;
import vn.tcx.dw.component.Validator;
import vn.tcx.dw.composite.CompositeResult;

/**
 * Define Composite Rule
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:45:11
 */
public class CompositeRule extends ArrayList<Validator> implements Validator {

    /**
     * 
     */
    private static final long serialVersionUID = -8414932387703832604L;

    public CompositeRule(Collection<Validator> rules) {
        addAll(rules);
    }

    public CompositeRule(Validator rule) {
        add(rule);
    }

    public CompositeRule(Validator... rules) {
        addAll(Arrays.asList(rules));
    }

    @Override
    public CompositeResult validate(Object value) {

        CompositeResult result = new CompositeResult(size());

        for (Validator rule : this) {

            Result tempResult = rule.validate(value);

            List<Result> list = new ArrayList<>();

            if (!tempResult.isOk()) {
                list.add(tempResult);
            }

            result.add(list);

        }
        return result;
    }

}
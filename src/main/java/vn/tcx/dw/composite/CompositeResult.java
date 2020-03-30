package vn.tcx.dw.composite;

import java.util.ArrayList;
import java.util.List;

import vn.tcx.dw.component.Result;

/**
 * Define class composite result
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:43:49
 */
public class CompositeResult implements Result { 
    private List<Result> results;

    /**
     * This method perform add list result to results
     * @update hieuvv
     * @lastModifier 30/03/2020 15:46:04
     * @param list
     */
    public void add(List<Result> list) {
        if (results == null || results.isEmpty()) {
            results = new ArrayList<>();
        }
        results.addAll(list);
    }

    private Integer appliedCount;

    public CompositeResult(Integer appliedCount) {
        this.appliedCount = appliedCount;
    }

    public CompositeResult() {
        super();
    }

    @Override
    public boolean isOk() {
        return results.isEmpty();
    }

    public Integer failCount() {
        return results.size();
    }

    public Integer passCount() {
        return appliedCount - results.size();
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getAppliedCount() {
        return appliedCount;
    }

    public void setAppliedCount(Integer appliedCount) {
        this.appliedCount = appliedCount;
    }

}

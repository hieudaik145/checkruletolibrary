package vn.tcx.dw.composite;

import vn.tcx.dw.component.Result;

/**
 * Define SimpleResult 
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:44:51
 */
public class SimpleResult implements Result {

    private boolean isOk;

    @Override
    public boolean isOk() {
        return isOk;
    }

}

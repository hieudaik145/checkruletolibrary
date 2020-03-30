package vn.tcx.dw.component;

/**
 * Define Enum status of Result
 * 
 * @author hieuvv
 * @since 1.0
 * @created 30/03/2020 15:39:26
 */
public enum EnumResult {

    OK(true),

    FAILD(false);

    boolean result;

    private EnumResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

}

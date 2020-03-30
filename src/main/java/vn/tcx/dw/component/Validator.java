package vn.tcx.dw.component;

/**
 * Composite Validator
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:36:34
 */
public interface Validator {

    /**
     * This method perform validate
     * @update hieuvv
     * @lastModifier 30/03/2020 15:37:02
     * @param value
     * @return Result 
     */
    public Result validate(Object value);

}

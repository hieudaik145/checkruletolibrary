package vn.tcx.dw.component;

/**
 * Define component Result
 * class description (please change)
 * @author hieuvv 
 * @since 1.0
 * @created 30/03/2020 15:43:06
 */
public interface Result {

    Result OK = new Result() {

        @Override
        public boolean isOk() {
            return true;
        }
    };
    
    Result FAILED = new Result() {
        
        @Override
        public boolean isOk() {
            return false;
        }
    };

    public boolean isOk();

}

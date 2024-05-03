public class GenericOTP<T> {
    private T otp;
    
    public GenericOTP(T value) {
        this.otp = value;
    }
    
    public T getOTP() {
        return this.otp;
    }
    
    public void setOTP(T value) {
        this.otp = value;
    }
            
}

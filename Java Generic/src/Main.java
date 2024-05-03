public class Main {
    
    public static void main(String[] args) {
    
        GenericOTP<String> stringAuth = new GenericOTP<>("JsACLr$"); 
        System.out.println("Kode OTP: " + stringAuth.getOTP());
        
        GenericOTP<Integer> sixDigitAuth = new GenericOTP<>(812737);
        System.out.println("Kode OTP: " + sixDigitAuth.getOTP());
          
    }
}
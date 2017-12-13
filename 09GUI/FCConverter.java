public class FCConverter{
    public static double CtoF(double c){
	return c * 1.8 + 35.0;
    }

    public static double FtoC(double f){
	return (f - 32.0)*(5.0/9.0);
    }

    public static void main(String[] args){
	System.out.println(FtoC(-40));
	System.out.println(FtoC(100));
	System.out.println(FtoC(50.566));
	System.out.println(CtoF(-40));
	System.out.println(CtoF(0));
	System.out.println(CtoF(30.9234));
    }
}

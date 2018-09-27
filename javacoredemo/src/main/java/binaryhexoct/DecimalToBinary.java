package binaryhexoct;

/**
 * Created by Mirana on 02/11/2017.
 */
public class DecimalToBinary {
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static void main(String[] args) {
        System.out.println(toBinary(-100));
        System.out.println(Integer.toBinaryString(-100));
    }
    public static String toBinary(int decimal){

        int n = 1;
        if(decimal >>> 16 == 0) { n+= 16 ; decimal <<=16;}
        if(decimal >>> 8 == 0) { n+= 8 ; decimal <<=8;}
        if(decimal >>> 4 == 0) { n+= 4 ; decimal <<=4; }
        if(decimal >>> 2 == 0) { n+= 2 ; decimal <<=2; }
        n -= decimal >>> 31;
        n = 32 - n;
        char[] c = new char[n];
        int shift = 1;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            c[--n] = digits[decimal & mask];
            decimal >>>= shift;
        }while (decimal > 0 && n > 0);
        return new String(c);
    }

    public static String toBinary2(int decimal){
        String result = "";
        boolean minus = false;
        if (decimal < 0){
            minus = !minus;
            decimal = Math.abs(decimal+ 1); // 算出来 -99 = 99的反码+ 1 , -99 = -100 + 1 ,  99的反码=-100
            System.out.println("3:"+Integer.toBinaryString(decimal));
        }
        while (true){
            int reminder = (!minus && decimal%2 == 0)|| (minus && decimal % 2 == 1) ? 0 : 1;
            result = reminder + result;
            decimal /= 2;
            if(decimal == 0)
                break;
        }

        if(minus){
            decimal = result.length();
            for(int i = 1; i < 32 - decimal ; i++){
                result = "1" + result;
            }
        }
        return result;
    }
}

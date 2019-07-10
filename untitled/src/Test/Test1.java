package Test;

import java.util.Optional;

public class Test1 {
    private int length;

    public static void main(String[] args) {

        Test1 one = new Test1();
        one.length = 1;
        Test1 two = new Test1();
        //two = one;
        two.length = 2;
        System.out.println(one.toString());
        System.out.println(two.toString());

//        try
//        {
//            aMethod(0);
//        }
//        catch (Exception ex)
//        {
//            System.out.println("exception in main");
//        }
//        System.out.println("finished");

    }

    @Override
    public String toString() {
        return "Test1{" +
                "length=" + length +
                '}';
    }

    /**
     * 字符串转换数字
     * 字符0 ascll码为 48，当前数字的码减去0的码为十进制数
     * @param str
     * @return
     */
    private static int parseInt(String str){
        Optional<String> strOpt = Optional.ofNullable(str);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                int temp = result * 10;
                result = temp + (int)c - '0';

            }

        }
        return result;
    }

    public static int aMethod(int i)throws Exception
    {
        try{
            return i / 0;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.println("finally");
        }
    }
}

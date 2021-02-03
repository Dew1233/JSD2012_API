package Socket;

import java.nio.Buffer;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] allOut ={30,45,92,45,565,19,15,185};
        int pw  = 185;
        System.out.println(Arrays.toString(allOut));

        //讲pw从数组allout中删除
        for (int i = 0;i<allOut.length;i++){
            if(pw==allOut[i]){
                allOut[i] = allOut[allOut.length-1];
                break;
            }
        }
        allOut = Arrays.copyOf(allOut,allOut.length-1);
        System.out.println(Arrays.toString(allOut));
    }
}

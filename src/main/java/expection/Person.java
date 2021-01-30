package expection;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    /**
     * 当一个方法使用throws声明异常抛出的时，调用该方法的代码
     * 就必须处理这个异常
     * @param age
     * @throws Exception
     */

    public void setAge(int age) throws Exception{
        if(age<0||age>=100){
//            超出合理范围则对外抛出一个异常

//           throw new RuntimeException("年龄不合法");
            /**
             * 当一个方法中使用throw抛出一个异常时候，就要求在当前
             * 方法上使用throws声明该异常的抛出。只有RuntimeException是个例外。
             */
            throw new Exception("年龄不合法");
        }
        this.age = age;
    }
}

package JVM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Test test = new Test();
        test.test();
    }
}

class Test {

    private int count = 0;

    public void test() throws NoSuchFieldException, IllegalAccessException {
        // 获取unsafe实例
        Class klass = Unsafe.class;
        Field field = klass.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        // 获取count域的Field
        Class unsafeTestClass = Test.class;
        Field fieldCount = unsafeTestClass.getDeclaredField("count");
        fieldCount.setAccessible(true);

        // 计算count的内存偏移量
        long countOffset = (int) unsafe.objectFieldOffset(fieldCount);
        System.out.println(countOffset);

        // 原子性的更新指定偏移量的值（将count的值修改为3）
        unsafe.compareAndSwapInt(this, countOffset, count, 3);

        // 获取指定偏移量的int值
        System.out.println(unsafe.getInt(this, countOffset));
    }
}

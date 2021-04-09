import java.lang.annotation.Native;
import java.util.HashMap;

/**
 * @author lt
 * @date 2021/4/5 9:27
 */
public class Map {

    HashMap map  = new HashMap();

    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Native
    public static final int   MAX_VALUE = 0x7fffffff;

    public static void main(String[] args) {
        System.out.println(MAXIMUM_CAPACITY);

        System.out.println(MAX_VALUE);
        System.out.println(2<<20);
    }
}

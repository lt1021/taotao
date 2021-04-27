/**
 * @author lt
 * @date 2021/4/27 14:17
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 文字中间只能用-符号隔开
 * <p>
 * <p>
 * 比如注蜡-蜡镶-倒模-执模，而且不能重复创建一模一样内容
 */
public class Flow {

    public String[] strs = {"注蜡-蜡镶-倒模-执模", "注蜡-蜡镶-倒模-注蜡", "注蜡+蜡镶"};

    /**
     * 获取重复数据
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> repeatByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> Objects.nonNull(map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE));
    }

//    public static String repeatByKeys(String keyExtractor) {
//        Map<Object, Boolean> map = new ConcurrentHashMap<>();
//        map.putIfAbsent(keyExtractor,Boolean.TRUE);
//        d -> Objects.nonNull(a);
//        return t -> Objects.nonNull(map.putIfAbsent(keyExtractor, Boolean.TRUE));
//    }

    @Test
    public void testFlow() {
        System.out.println(strs);
        for (String str : strs) {
            if (str.contains("-")) {
                System.out.println(str+"有-");
            }
            System.out.println(str);
            String[] flow = str.split("-");
//            List list = Arrays.stream(flow).distinct().collect(Collectors.toList());
            List aa = Arrays.stream(flow).collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                    .entrySet().stream()
                    .filter(ent -> ent.getValue() > 1)
                    .map(ent -> ent.getKey())
                    .collect(Collectors.toList());
            if (aa.size() > 0) {
                System.out.println(str + "重复！");
            }
            System.out.println();
//            if (str.equals("注蜡-蜡镶-倒模-执模")) {
//
//            }
        }
    }

    @Test
    public void testRepea() {
        for (String str : strs) {
            String[] flow = str.split("-");
//            Arrays.stream(flow).filter(repeatByKey(str);
            Map<String, Long> collect = Arrays.stream(flow).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(collect);
        }
    }
}

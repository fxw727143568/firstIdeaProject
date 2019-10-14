import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class testMap {

    @Test
    public void test() throws Exception {
        HashMap<String,String> map = new HashMap<>(3);
        map.put("11","22");
        map.put("1","22");
        map.put("2","22");
        map.put("22","22");
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));
        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold : " + threshold.get(map));

        Field loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor.get(map));

    }

    @Test
    public void ipTest() throws UnknownHostException {
        InetAddress[] address = InetAddress.getAllByName("www.taobao.com");
        for(InetAddress ip : address){
            System.out.println(ip);
        }

    }

}

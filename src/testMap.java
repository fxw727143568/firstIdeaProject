import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

    @Test
    public void setTest() throws UnknownHostException {

        Long begin = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>(20000000);
        //HashSet<String> hashSet = new HashSet<>(20000000);
        for(int i=0;i<20000000;i++){
            //arrayList.add("list"+i);
            arrayList.add("list"+i);
        }
        int size = arrayList.size();
        System.out.println("运行时间:"+(System.currentTimeMillis()-begin));

        Long begin1 = System.currentTimeMillis();
        for (int i=0;i<=size;i++){
            if(arrayList.contains("list10000000")){
                break;
            }
        }
        System.out.println("运行时间1:"+(System.currentTimeMillis()-begin1));
    }

}

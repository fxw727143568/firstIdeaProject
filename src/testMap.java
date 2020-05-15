import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class testMap implements Runnable{

    int b = 100;

    synchronized void m1() throws Exception{
        b = 1000;
        Thread.sleep(500);
        System.out.println("b="+b);
    }

    synchronized void m2() throws Exception{
        Thread.sleep(250);
        b=2000;
    }

    public static void main(String[] args) throws Exception{
        testMap tt = new testMap();
        Thread t = new Thread(tt);
        t.start();

        tt.m2();
        System.out.println("main thread b="+tt.b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    public void ipTest() {
       /*Double d = 0.0d;
       System.out.println(String.format("%.1f",d));
       LocalTime a = LocalTime.now();
       LocalTime b = LocalTime.now().plusHours(-1);*/
      /* d = Double.valueOf((Duration.between(b, a).getSeconds())/3600d);
       System.out.println(String.format("%.1f",d));*/
        LocalDate a = LocalDate.now().plusDays(4);
        LocalDate b = LocalDate.now();
        int c = LocalTime.now().toSecondOfDay();
        int k = 1024 * 1024 * 8;
        ArrayList<byte[]> arrayList = new ArrayList<>();
        for(int i=0;i<k;i++){
            System.out.println("111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList.add(new byte[k]);
        }

    }
/*
    @Test
    public void setTest() throws UnknownHostException {

        Long begin = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>(20000000);
        HashSet<String> hashSet = new HashSet<>(20000000);
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
    }*/

}

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.lang.String;

public class LRULinkedMap<K,V> {
    private int cacheSize;

    private LinkedHashMap<K,V> cacheMap;

    public LRULinkedMap(int cacheSize){
        this.cacheSize=cacheSize;
        cacheMap=new LinkedHashMap(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Entry eldest){
                if(cacheSize+1==cacheMap.size()){
                    return true;
                }else{
                    return false;
                }
            }
        };
    }

    public void put(K key,V value){
        cacheMap.put(key,value);
    }

    public V get(K key){
        return cacheMap.get(key);
    }

    public static void main(String[] args){
        String ans="";
        Scanner sc=new Scanner(System.in);
        int capacity=sc.nextInt();
        int operations=sc.nextInt();
        LRULinkedMap<Integer,String> map=new LRULinkedMap<>(capacity);
        for(int i=0;i<operations;++i){
            String str=sc.next();
            if(str.equals("put")){
                str=sc.next();
                String[] strarr=str.split(";");
                for(int j=0;j<strarr.length;++j){
                    String[] pair=strarr[j].split(",");
                    map.put(Integer.parseInt(pair[0]),pair[1]);
                }
            }else if(str.equals("get")){
                str=sc.next();
                String[] strarr=str.split(";");
                for(int j=0;j<strarr.length;++j){
                    ans=ans+map.get(Integer.parseInt(strarr[j]))+";";
                }
                ans=ans+"\n";
            }
        }
        System.out.println(ans);
    }


}

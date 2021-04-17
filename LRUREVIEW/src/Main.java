import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int capacity=0;
        Scanner sc=new Scanner(System.in);
        capacity=sc.nextInt();
        int operations=0;
        operations=sc.nextInt();
        LRU<Integer,String> l=new LRU<>(capacity);
        String ans="";
        for(int i=0;i<operations;++i){
            String str=sc.next();
            if(str.equals("put")){
                str=sc.next();
                String[] arr=str.split( ";");
                for(int j=0;j< arr.length;++j){
                    String[] param=arr[j].split(",");
                    l.put(Integer.parseInt(param[0]),param[1]);
                }
            }else if(str.equals("get")){
                str=sc.next();
                String[] arr=str.split( ";");
                for(int j=0;j< arr.length;++j){
                    ans+=l.get(Integer.parseInt(arr[j]))+";";
                }
                ans+="\n";
            }
        }
        System.out.println(ans);
    }
}

class LRU<K,V>{
    private class Node{
        K key;
        V value;
        Node pre;
        Node next;
        public Node(){}
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            pre=new Node();
            next=new Node();
        }
    }
    HashMap<K,Node> hashmap=new HashMap<>();
    Node dummyHead=new Node();
    Node dummyTail=new Node();
    int capacity;
    int size=0;
    //think about the access right
    LRU(int capacity){
        this.capacity=capacity;
        dummyHead.next = dummyTail;
        dummyTail.pre=dummyHead;
    }

    private void add(Node node){
        //head is the newest one
        Node originalHead=dummyHead.next;
        dummyHead.next=node;
        node.pre=dummyHead;
        node.next=originalHead;
        originalHead.pre=node;
        // where should I write this sentence,in put function
        // hashmap.put(node.key,node);
    }

    private void del(Node node){
        //not just for removing the eldest one, but also the one that I want to update
        //tail is the eldest one
        Node pre=node.pre;
        Node next=node.next;
        pre.next=next;
        next.pre=pre;
        //remove the delNode
        node.pre=null;
        node.next =null;
        //should I remove the record of the deleted one?
    }

    public void put(K key,V value){
        Node node=hashmap.get(key);
        Node newnode=new Node(key,value);
        if(node==null){
            if(size+1<=capacity){
                size++;
            }else{
                Node delNode=dummyTail.pre;
                hashmap.remove(delNode.key);
                del(delNode);
            }
        }else{
            hashmap.remove(key);
            del(node);
        }
        add(newnode);
        hashmap.put(key,newnode);
    }

    public V get(K key){
        Node node=hashmap.get(key);
        if(node!=null){
            del(node);
            add(node);
            return node.value;

        }
        return null;
    }





}
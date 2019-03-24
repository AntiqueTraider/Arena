package com.company.company;
//package Collection;
import org.w3c.dom.Node;

import java.util.*;

public class MyAwsomeLinkedList<Elem> implements Iterable<Elem>{
    private static class Node<Elem> {
        Elem item;
        Node<Elem> next;
        Node<Elem> prev;

        Node(Node<Elem> prev, Elem element, Node<Elem> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    Node<Elem> nodeFirst = new Node<Elem>(null,null,null);
    Node<Elem> nodeLast ;
    private Node<Elem> first;
    private Node<Elem> last;
    private int size;
    public MyAwsomeLinkedList (){
        size=0;
        nodeLast= nodeFirst;
        nodeFirst.next = nodeLast ;
        nodeLast.prev = nodeFirst;
    }

    public MyAwsomeLinkedList (Collection<Elem> col){
        size = col.size();
        Object [] x = col.toArray();
        nodeFirst.item = (Elem)x[0];
        nodeLast = nodeFirst;
        for(int i = 1; i<size; i++){
            nodeLast.next = new Node<Elem>(nodeLast,(Elem)x[i],null);
            nodeLast = nodeLast.next;
        }
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return nodeFirst.item == null ;
    }

    public boolean contains(Object o) {
        Node<Elem> buff = nodeFirst;
        boolean key = false;
        while (!key && buff != null){
            if (buff.item.equals((Elem)o)){
                key = true;
            }
            buff=buff.next;
        }
        return key;
    }

    @Override
    public Iterator <Elem> iterator() {
        Iterator<Elem> it = new Iterator<Elem>() {

            MyAwsomeLinkedList.Node <Elem> buff = nodeFirst;
            @Override
            public boolean hasNext() {
                return buff.next != null;
            }

            @Override
            public Elem next() {
                buff=buff.next;
                return buff.item;
            }

            @Override
            public void remove() {
                buff.prev=buff.next;
                buff=buff.next;
                size--;
            }
        };
        return it;
    }



    public Object[] toArray() {

        Object arr[]=new Object[size];
        Node<Elem> buff = nodeFirst;
        int i=0;
        while ( buff != null){
            arr[i] = buff;
            i++;
            buff = buff.next;
        }
        return arr;
    }



    public boolean add(Object o) {
        boolean key = contains(o);
        if (!key) {
            nodeLast.next=new Node<Elem>(nodeLast,(Elem)o,null);
            nodeLast=nodeLast.next;
            size++;
        }
        return !key;
    }

    public int getNomber (Object o){
        int i=0;
        Node<Elem> buff = nodeFirst;
        boolean key = false;
        do{
            if (buff.item.equals((Elem)o)){
                key = true;
            }else {
                i++;
            }
            buff=buff.next;
        }while(!key && buff != null);
        return i;
    }

    public Elem getValue (int o){

        Node<Elem> buff = nodeFirst;
        for (int i=0; i<o; i++){
            buff = buff.next;
        }
        return buff.item;
    }

    public boolean remove(Object o) {
        boolean key = contains(o);
        Node<Elem> buff = nodeFirst;
        if (key){
            int i = getNomber(o);
            for (int j=0; j < i; j++)
                buff = buff.next;
            buff.prev=buff.next;
            size--;
        }
        return key;
    }

    public boolean addAll(Collection <Elem> c) {
        Object [] arr = c.toArray();
        boolean key= false;
        for (int i = 0; i<c.size(); i++)
            if (add(arr[i])) {
                size++;
                key=true;
            }
        return key;
    }

    public void clear() {
          Node<Elem> buff = nodeLast;
          do{
              buff=buff.prev;
              buff.next = null;
          }while (!buff.equals(nodeFirst));
          nodeLast = null;
          nodeFirst = null;
          buff = null;
    }

    public boolean removeAll(Collection <Elem> c) {
        Object [] arr = c.toArray();
        boolean key= false;
        for (int i = 0; i<c.size(); i++)
            if (remove(arr[i])) {
                size--;
                key=true;
            }
        return key;
    }

}

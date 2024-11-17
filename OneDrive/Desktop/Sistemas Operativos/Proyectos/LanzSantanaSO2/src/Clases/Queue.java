/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author santi
 */
public class Queue {
    Nodo head, tail;
    int length;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void enqueue(Object element) {
        System.out.println("Adding character: " + ((Characters)element).getName() + " to queue");
        Nodo nodo = new Nodo(element);
        if (isEmpty()) {
            setHead(nodo);
            setTail(nodo);
        } else {
            getTail().setNext(nodo);
            setTail(nodo);
        }
        length++;

    }
    
//    public Queue merge_orden(Queue queue1, Queue queue2){
//        Queue merge = new Queue();
//        while (!queue1.isEmpty()|| !queue2.isEmpty()){
//            if (queue1.isEmpty()){
//                merge.enqueue(queue2.dequeue());
//            } else if(queue2.isEmpty()){
//                merge.enqueue(queue1.dequeue());
//            } 
//            else {
//                if (queue1.getHead().getElement() > queue2.getHead().getElement()){
//                    
//                }
//            }
//         
//               
//        }
//        
//        return null;
//    }
//    
//    public static Queue mergeQueues(Queue queueAsc, Queue queueDesc) {
//        Queue mergedQueue = new Queue();
//        Queue tempQueue = new Queue();
//
//        while (!queueAsc.isEmpty() && !queueDesc.isEmpty()) {
//            if (queueAsc.getHead() > queueDesc.getHead()) {
//                tempQueue.enqueue(queueAsc.dequeue());
//            } else {
//                tempQueue.enqueue(queueDesc.dequeue());
//            }
//        }

        // Transfer remaining elements from queueAsc to tempQueue
//        while (!queueAsc.isEmpty()) {
//            tempQueue.enqueue(queueAsc.dequeue());
//        }
//
//        // Transfer remaining elements from queueDesc to tempQueue
//        while (!queueDesc.isEmpty()) {
//            tempQueue.enqueue(queueDesc.dequeue());
//        }
//
//        // Transfer elements from tempQueue to mergedQueue in descending order
//        while (!tempQueue.isEmpty()) {
//            mergedQueue.enqueue(tempQueue.dequeue());
//        }
//
//        return mergedQueue;
//    }


    public Nodo dequeue() {
        if (isEmpty()){
            System.out.println("La cola esta vacía");
        } else{
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            length--;
            return pointer;
        }
        return null;
    }


    public Object process() {
        if (isEmpty()){
            System.out.println("La cola esta vacia");
        }else{
            System.out.println("el elemento en turno es"+" "+getHead().getElement());
            return getHead().getElement();
        }
        return null;
    }

    public Nodo dispatch() {
        if (isEmpty()){
            System.out.println("la lista esta vacia");
        }else{
            process();
            return dequeue();
        }
        return null;
    }

    public boolean isEmpty() {
        return getHead() == null;
    }

    public void print(){
        Nodo pointer = getHead();
        while (pointer != null) {
            System.out.println("[ " + pointer.getElement() + " ]");
            pointer = pointer.getNext();
        } 
    }
}

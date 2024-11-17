/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


/**
 *
 * @author santi
 */
public class List  {
    
    private Node head, tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void insertBegin(Object element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            getHead().setPrevious(node);
            node.setNext(getHead());
            setHead(node);
        }
        size++;
    }

    public void insertFinal(Object element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            Node pointer = getTail();
            node.setPrevious(pointer);
            pointer.setNext(node);
            setTail(node);
        }
        size++;
    }

    public void insertInIndex(Object element, int index) {
        if (isEmpty() || index ==0) {
            insertBegin(element);
        } else if (index < getSize()) {
            Node nodo = new Node(element);
            if (index <= size / 2) {
                Node pointerPrevious = getHead();
                int cont = 0;
                while (cont < index - 1) {
                    pointerPrevious = pointerPrevious.getNext();
                    cont++;
                }
                Node pointerNext = pointerPrevious.getNext();
                pointerPrevious.setNext(nodo);
                nodo.setPrevious(pointerPrevious);
                pointerNext.setPrevious(nodo);
                nodo.setNext(pointerNext); 
            } else {
                Node pointerNext = getTail();
                int cont = 0;
                while (cont < (getSize()-index-1)) {
                    pointerNext = pointerNext.getPrevious();
                    cont++;
                }
                // System.out.println("Values"+"Index"+index+"pointerNext"+pointerNext.getElement()+"Size"+getSize()+"cont"+cont);
                Node pointerPrevious = pointerNext.getPrevious();
                nodo.setPrevious(pointerPrevious);
                pointerPrevious.setNext(nodo);
                nodo.setNext(pointerNext);
                pointerNext.setPrevious(nodo);
            }   
            size++;
        } else if (index == getSize()) {
            insertFinal(element);
        } else {
            System.out.println("Invalid Index");
        }        
    }

    public Node deleteFinal() {
        if (isEmpty()) {
            System.out.println("No hay elementos en la lista");
        } else {
            Node pointer = getTail();
            if (getSize() == 1) {
                setHead(null);
                setTail(null);
            } else {
                Node pointer2 = pointer.getPrevious();
                pointer.setPrevious(null);
                pointer2.setNext(null);
                setTail(pointer2);
            }
            size--;
            return pointer;
        }
        return null;
    }

    public Node deleteBegin() {
        if (isEmpty()) {
            System.out.println("No hay elementos en la lista");
        } else {
            Node pointer = getHead();
            if (getSize() == 1) {
                setHead(null);
                setTail(null);
            } else {
                Node pointer2 = pointer.getNext();
                pointer.setNext(null);
                pointer2.setPrevious(null);
                setHead(pointer2);
            }
            size--;
            return pointer;
        }
        return null;
    }

    public Node deleteInIndex(int index) {
        if (isEmpty()) {
            System.out.println("No hay elementos en la lista");
        } else if (index >= getSize()) {
            System.out.println("Error en indice");
        } else {
            if (index < getSize() / 2) {
                Node pointer = getHead();
                if (index == 0) {
                    deleteBegin();
                } else {
                    Node pointer2;
                    int cont = 0;
                    while (cont < index - 1 && pointer != null) {
                        pointer = (Node) pointer.getNext();
                        cont++;
                    }
                    pointer2 = pointer.getNext();
                    pointer.setNext(pointer2.getNext());
                    pointer2.getNext().setPrevious(pointer);
                    pointer2.setNext(null);
                    pointer2.setPrevious(null);
                    return pointer2;
                }
            } else {
                Node pointer = getTail();
                if (index == getSize() - 1) {
                    deleteFinal();
                } else {
                    Node pointer2;
                    int cont = 0;
                    while (cont < (getSize() - index) && pointer != null) {
                        pointer = (Node) pointer.getPrevious();
                        cont++;
                    }
                    //System.out.println(pointer.getElement());
                    pointer2 = pointer.getNext();
                    pointer.setNext(pointer2.getNext());
                    pointer2.getNext().setPrevious(pointer);
                    pointer2.setNext(null);
                    pointer2.setPrevious(null);
                    return null;
                }
            }
            size--;
        }
        return null;
    }

   
    public void print() {
        Node pointer = getHead();
        while (pointer != null) {
            System.out.print("[ " + pointer.getElement() + " ]");
            pointer = pointer.getNext();
        }
    }

    public boolean isEmpty() {
        return getHead() == null && getTail() == null;
    }

}

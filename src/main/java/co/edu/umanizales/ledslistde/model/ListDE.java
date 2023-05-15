package co.edu.umanizales.ledslistde.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.NodeChangeEvent;


@Data
public class ListDE {
    private NodeDE head;
    private int size;
    private List<Led> ledList = new ArrayList<>();


    public void add(Led led) {
        if (head == null) {
            head = new NodeDE(led);
        } else {
            NodeDE newNode = new NodeDE(led);
            NodeDE temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }

        size++;
    }

    public void turnOn(){
        if (head != null){
            NodeDE temp= head;
            while (temp!= null){
                temp.getData().setState(true);
                temp.getData().setDateon(LocalTime.from(LocalTime.now()));


                temp= temp.getNext();
            }
        }
    }

    public List<Led> print() {
        ledList.clear();
        if(head != null){
            NodeDE temp=head;
            while (temp != null){
                ledList.add(temp.getData());
                temp=temp.getNext();
            }
        }

        return ledList;
    }

    public void turnOff() {
        if (head != null) {
            NodeDE temp= head;
            while (temp != null) {

                temp.getData().setState(false);
                temp.getData().setDateoff(LocalTime.from(LocalDateTime.now()));



                temp = temp.getNext();

            }
        }


    }



    public void addToStart(Led led) {
        NodeDE newNode = new NodeDE(led);
        if (head != null) {
            head.setPrevious(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    public void restart() {
        if (head != null) {
            NodeDE temp = head;
            while (temp != null) {
                temp.getData().setState(false);
                temp.getData().setDateoff(null);
                temp.getData().setDateon(null);

                temp = temp.getNext();

            }
        }
    }

    public void delete() {
        NodeDE temp= head;
        if (temp != null) {
            head.getNext().setPrevious(null);
            head.setNext(null);
            head=null;

            size=0;


        }
    }
    public void turnOnAndOff() {
        if (head != null) {
            NodeDE temp1 = head;  // Primer nodo temporal para recorrer la lista de uno en uno
            NodeDE temp2 = head;  // Segundo nodo temporal para recorrer la lista de dos en dos
            int count1 = 0;  // Contador para el primer nodo temporal
            int count2 = 0;  // Contador para el segundo nodo temporal
            int midpoint = size / 2;  // Punto medio de la lista

            // Avanzar temp2 hasta la mitad de la lista
            while (count2 < midpoint) {
                temp2 = temp2.getNext();
                count2++;
            }

            // Encender las luces desde la mitad hasta el extremo final
            while (temp2 != null) {
                temp2.getData().setState(true);
                temp2.getData().setDateon(LocalTime.now());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                temp2.getData().setState(false);
                temp2.getData().setDateoff(LocalTime.now());

                temp2 = temp2.getNext();
            }

            // Retroceder temp1 hasta el extremo inicial y encender las luces en el camino
            while (temp1 != null) {
                temp1.getData().setState(true);
                temp1.getData().setDateon(LocalTime.now());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                temp1.getData().setState(false);
                temp1.getData().setDateoff(LocalTime.now());

                temp1 = temp1.getPrevious();
            }
        }
    }

    public void starttofinal() {
        if (head != null) {
            NodeDE temp = head;  // Nodo temporal para recorrer la lista
            int count = 0;  // Contador de nodos recorridos

            // Encender las luces desde el principio hasta el final
            while (temp != null) {
                temp.getData().setState(true);
                temp.getData().setDateon(LocalTime.now());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                temp.getData().setState(false);
                temp.getData().setDateoff(LocalTime.now());

                temp = temp.getNext();
                count++;
            }
        }
    }




}



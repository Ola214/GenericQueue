/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.queue;

import com.mycompany.queue.exception.EmptyQueueException;
import com.mycompany.queue.model.QueueFIFO;
import java.util.Scanner;

/**
 *
 * @author Olaa
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyQueueException {

        Integer number;

        QueueFIFO<Integer> queue = null;
        boolean status;

        queue = new QueueFIFO<>();

        int answer;
        do {
            System.out.println();
            System.out.println("0 - Push number");
            System.out.println("1 - Pop number");
            System.out.println("2 - Read first number in queue");
            System.out.println("3 - Exit");
            System.out.println("4 - Read last number in queue");
            System.out.println();

            answer = Integer.parseInt(getInput());

            switch (answer) {
                case 0:
                    System.out.println("Type number");
                    number = null;
                    number = Integer.parseInt(getInput());
                    queue.push(number);
                    break;
                case 1:
                    try {
                        queue.pop();
                    } catch (EmptyQueueException eqe) {
                        eqe.printStackTrace();
                    }
                    break;
                case 2:
                    number = null;
                    try {
                        number = queue.getFirst();
                    } catch (EmptyQueueException eqe) {
                        eqe.printStackTrace();
                    }
                    if (number != null) {
                        System.out.println("First number in queue: " + number);
                    }
                    break;
                case 3:
                    queue = null;
                    System.gc();
                    System.exit(0);
                    break;
                case 4:
                    number = null;
                    try {
                        number = queue.getLast();
                    } catch (EmptyQueueException eqe) {
                        eqe.printStackTrace();
                    }
                    if (number != null) {
                        System.out.println("Last number in queue: " + number);
                    }
                    break;

                default:
                    queue = null;
                    System.gc();
                    System.exit(0);

            }
        } while (answer != 3);
    }

    public static String getInput() {
        return scanner.nextLine();
    }

}

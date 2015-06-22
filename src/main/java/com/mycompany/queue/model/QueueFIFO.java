/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.queue.model;

import com.mycompany.queue.exception.EmptyQueueException;

/**
 *
 * @author Olaa
 */
public class QueueFIFO<E> {

    private Elem last = null;

    private class Elem {

        E data;
        Elem predecessor;

        Elem(E e, Elem n) {
            data = e;
            predecessor = n;
        }
    }

    public QueueFIFO() {

    }

    public void push(E object) {
        last = new Elem(object, last);
    }

    public void pop() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        Elem lastTmp = last;
        if (lastTmp.predecessor != null) {
            while (lastTmp.predecessor.predecessor != null) {
                lastTmp = lastTmp.predecessor;
            }

            lastTmp.predecessor = null;
        } else {
            last = null;
        }
    }

    public E getFirst() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        Elem lastTmp = last;

        while (lastTmp.predecessor != null) {
            lastTmp = lastTmp.predecessor;
        }

        return lastTmp.data;
    }

    public E getLast() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return last.data;
    }

    public boolean isEmpty() {

        return last == null;
    }

    @Override
    public void finalize() throws Throwable {
        //ilePolozono = 0; //tu jest this wiec chyba za drugim razem sie wywola;/
        super.finalize();
    }

}

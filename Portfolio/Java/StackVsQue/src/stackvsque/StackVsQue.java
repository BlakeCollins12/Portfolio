/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvsque;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static junit.framework.Assert.assertEquals;


/**
 *
 * @author blakecollins
 */
public class StackVsQue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        queueInsertion();
        stackInsertion();
    }
    
    @Test
    static public void queueInsertion() {
        final Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
       
        //Order FIFO
        //First in first out
        assertEquals("first", queue.remove());
        assertEquals("second", queue.remove());
        assertEquals("third", queue.peek());
        assertEquals("third", queue.remove());
    }
    
    @Test
    static public void stackInsertion() {
        final Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
       
        // Order is LIFO
        // Last in first out
        assertEquals("third", stack.pop());
        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
    }


    
    
}

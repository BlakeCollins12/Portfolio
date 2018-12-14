/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blakecollins
 */
public class MemoryLeakStack<E> {

    private final List<E> stackValues;
    private int stackPointer;

    public MemoryLeakStack() {
        this.stackValues = new ArrayList<>();
        stackPointer = 0;
    }

    public void push(E element) {
        stackValues.add(stackPointer, element);
        stackPointer++;
    }

    public E pop() {
        stackPointer--;
        return stackValues.get(stackPointer);
    }
    
    public int size(){
        return stackValues.size();
    }
    
}

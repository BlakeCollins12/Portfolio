

/**
 *
 * @author blakecollins
 */
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import memoryleak.MemoryLeakStack;


public class MemoryLeakStackTest {
    
    public static void main(String[] args){
        test();
    }

    @Test
    static public void test() {
        final MemoryLeakStack<String> stack = new MemoryLeakStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(String.format("Element %d", i));
        }
        
        System.out.println("Stack size: " + stack.size());
        assertEquals(10, stack.size());
        
        
        System.out.println("Stack pop");
        stack.pop();
        
        //This shows the memory leak.  It should be 9
        System.out.println("Stack size: " + stack.size() + " This is a memory leak.");
        assertEquals(10, stack.size());
        
        stack.push(String.format("Element %d", 9));
        
        for (int i = 9; i >= 0; i--) {
            assertEquals(String.format("Element %d", i), stack.pop());
        }

        for (int i = 0; i < 10; i++) {
            stack.push(String.format("Element %d", i));
        }

        for (int i = 9; i >= 0; i--) {
            assertEquals(String.format("Element %d", i), stack.pop());
        }
    }
}
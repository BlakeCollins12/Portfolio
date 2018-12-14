/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author blakecollins
 */
public class Sets {

    @Test
    public static void main(String[] args) {
        final Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("welcome");
        set.add("goodbye");
        set.add("bye");
        set.add("hello");

        System.out.println("Set Size " + set.size());
        assertEquals(4, set.size());
        

        final Set<String> set2 = new HashSet<>();
        set2.add("hi");
        set2.add("welcome");
        set2.add("hi");

        System.out.println("set1: " + set);
        System.out.println("set2: " + set2);

        set.retainAll(set2);

        System.out.println("intersection:  " + set);
        
        
        assertEquals(1, set.size());
    }

}

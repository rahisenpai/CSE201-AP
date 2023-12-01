package ques2;

import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SearchTest {
    @Test
    public void Test1(){
        int[] arr = {1, 2, 3, 4, 1323, 4433};
        Search s = new Search(arr);
        boolean response = s.binarySearch(0,5,3);
        assertTrue(response);
    }

    @Test
    public void Test2(){
        int[] arr = {1, 2, 3, 4, 1323, 4433};
        Search s = new Search(arr);
        boolean response = s.binarySearch(0,5,7);
        assertTrue(response);
    }

    @Test
    public void Test3(){
        int[] arr = {1, 2, 3, 4, 1323, 4433};
        Search s = new Search(arr);
        boolean response = s.binarySearch(0,5,4444);
        assertFalse(response);
    }
}
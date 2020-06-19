package org.parctice.app.helpers;

import org.junit.Test;

public class Print2DArrayTest {

    @Test
    public void print2x2() {
        String[][] array = {{"a", "b"}, {"x", "y"}};
        new Print2DArray(System.out).print(array);
    }

}

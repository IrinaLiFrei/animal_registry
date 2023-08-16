package petsreg;

import java.io.IOException;

public class Counter {

    private int count = 0;

    public void add() throws IOException {
      count++;
    }

    public int getCount(){
        return count;
    }

}

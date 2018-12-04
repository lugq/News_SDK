package com.botbrain.demo;

import org.junit.Test;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/31.
 */
public class AppTest {

    @Test
    public void main() {
        int c = 5;
        for (int i = 1;i<= 100;i++) {
            if (String.valueOf(i).contains("9"))
                continue;
            else {
                c ++;
                System.out.print(i + "\t");
                if (c%5 == 0)
                    System.out.print("\n");
            }
        }
    }
}
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        String ans;
        int max = 100;
        int min = 0;
        int steps = 0;
        int middle;

        while(max - min != 0) {
            ++steps;
            middle = (max + min) / 2;
            System.out.printf("Your number more than %d?\n", middle);
            ans = in.nextLine();
            if (ans.equals("Yes")) {
                min = middle + 1;
            }
            else {
                max = middle;
            }
        }
        System.out.printf("This is your number %d?\n", min);
        ans = in.nextLine();
        if (ans.equals("Yes")) {
            System.out.printf("Computer win for %d steps!\n", steps);
        }
        else {
            System.out.printf("You wrong!\n");
        }
    }
}

package com.company;

import Managment.FileManager;
import PersonClasses.*;

import java.util.ArrayList;
import java.util.Scanner;
import UserPack.*;

public class Main {
    public static void main(String[] args) {
    	RootUser root = new RootUser();
	    Demonstration d = new Demonstration();
	    Scanner in = new Scanner(System.in);
	    String choose;
	    d.Setup();
	    while(true) {
	    	d.SecondMainMenu(root);
	    	choose = in.nextLine();
	    	d.Processing(root, choose);
		}
	    //d.PrintPerson();
	    //d.addPerson();
	    //d.ExitProgram();
    }
}

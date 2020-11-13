package com.company;

import Managment.FileManager;
import PersonClasses.*;

import java.util.ArrayList;
import java.util.Scanner;
import UserPack.*;

public class Main {
    public static void main(String[] args) {
	    Demonstration d = new Demonstration();
	    User user = null;
	    boolean user_initial = false;
	    Scanner in = new Scanner(System.in);
	    String choose;
	    d.Setup();
	    d.PrintUsersCount();
	    while(true) {
	    	if (user_initial) {
				d.SecondMainMenu(user);
				choose = in.nextLine();
				d.Processing(user, choose);
			}
	    	else {
	    		d.FirstMainMenuDisplay();
				choose = in.nextLine();
				user = d.ProccessingFirst(choose);
				if (!user.equals(null)) {
					user_initial = true;
				}
			}

		}
    }
}

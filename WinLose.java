package com.cognizant.outreach.microservices.gateway.playground;

import java.util.Arrays;
import java.util.Scanner;

public class WinLose {

	public static void main(String[] args) {

		Scanner scannerIP = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(scannerIP.next());

		for (int casee = 0; casee < numberOfCases; casee++) {
			boolean win = true;
			int numberOfPlayers = Integer.parseInt(scannerIP.next());
			scannerIP.nextLine();
			String villainStrengths = scannerIP.nextLine();
			String[] villainInputs = villainStrengths.split("\\s+");
			int[] villainIntegers = Arrays.stream(villainInputs).mapToInt(Integer::parseInt).toArray();
			String heroStrengths = scannerIP.nextLine();
			String[] heroInputs = heroStrengths.split("\\s+");
			int[] heroIntegers = Arrays.stream(heroInputs).mapToInt(Integer::parseInt).toArray();
			if (villainInputs.length != numberOfPlayers || heroInputs.length != numberOfPlayers) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
			Arrays.sort(villainIntegers);
			Arrays.sort(heroIntegers);
			for(int player=0;player<numberOfPlayers;player++ ) {
				if(villainIntegers[player]>heroIntegers[player]) {
					win = false;
					break;
				}
			}
			if(win) {
				System.out.println("WIN");
			}else {
				System.out.println("LOSE");
			}
		}
		scannerIP.close();

	}

}

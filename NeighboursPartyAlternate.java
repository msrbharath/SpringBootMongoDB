package com.cognizant.outreach.microservices.gateway.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NeighboursPartyAlternate {

	public static void main(String[] args) {
		Scanner scannerIP = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(scannerIP.next());
		List<Integer> ticketIntegerList = new ArrayList<Integer>();
		List<String> outputList = new ArrayList<String>();
		for (int casee = 0; casee < numberOfCases; casee++) {
			int numberOfHouse = Integer.parseInt(scannerIP.next());
			scannerIP.nextLine();
			String tickets = scannerIP.nextLine();
			String[] ticketInputs = tickets.split("\\s+");
			int[] ticketIntegers = Arrays.stream(ticketInputs).mapToInt(Integer::parseInt).toArray();
			int secondMax;
			String op = null;
			for (int temp : ticketIntegers) {
				ticketIntegerList.add(temp);
			}
			if (ticketInputs.length != numberOfHouse) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
			Arrays.sort(ticketIntegers);
			int max = Collections.max(ticketIntegerList);
			int maxIndex = ticketIntegerList.indexOf(max);

			ticketIntegerList.clear();
			outputList.add(op);
		}
		for(String output:outputList) {
			System.out.println(output);
		}
		scannerIP.close();
	}

	/*
	 * 5
	 * 5 
	 * -1 7 8 -5 4 
	 * 4 
	 * 3 2 1 -1
	 * 4
	 * 11 12 -2 -1 
	 * 4 
	 * 4 5 4 3 
	 * 4 
	 * 5 10 4 -1 
	 * ========== 
	 * 48
	 * 13 
	 * 12 
	 * 44 
	 * 10
	 */
}

package com.cognizant.outreach.microservices.gateway.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NeighboursParty {

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
			int beforeIndex, afterIndex;
			boolean checkSecondMax = false;
			if(ticketIntegerList.size()==1 || ticketIntegerList.size()==2) {
				op = String.valueOf(max);
			}
			else if(ticketIntegerList.size()==3) {
				if(ticketIntegerList.get(0)> ticketIntegerList.get(1) && ticketIntegerList.get(0)> ticketIntegerList.get(2)) {
					if(ticketIntegerList.get(0)> ticketIntegerList.get(1)+ticketIntegerList.get(2)) {
						op = String.valueOf(ticketIntegerList.get(0));
					}else {
						op = String.valueOf(ticketIntegerList.get(1))+String.valueOf(ticketIntegerList.get(2));
					}
				}else if(ticketIntegerList.get(1)> ticketIntegerList.get(0) && ticketIntegerList.get(1)> ticketIntegerList.get(2)) {
					if(ticketIntegerList.get(1)> ticketIntegerList.get(0)+ticketIntegerList.get(2)) {
						op = String.valueOf(ticketIntegerList.get(1));
					}else {
						op = String.valueOf(ticketIntegerList.get(0))+String.valueOf(ticketIntegerList.get(2));
					}
				}else if(ticketIntegerList.get(2)> ticketIntegerList.get(1) && ticketIntegerList.get(2)> ticketIntegerList.get(2)) {
					if(ticketIntegerList.get(2)> ticketIntegerList.get(1)+ticketIntegerList.get(0)) {
						op = String.valueOf(ticketIntegerList.get(2));
					}else {
						op = String.valueOf(ticketIntegerList.get(1))+String.valueOf(ticketIntegerList.get(0));
					}
				}
			} else if(ticketIntegerList.size()>3) {
				if (maxIndex != 0 && maxIndex != ticketIntegerList.size() - 1) {
					beforeIndex = maxIndex - 1;
					afterIndex = maxIndex + 1;
					if (ticketIntegers[numberOfHouse - 2] != ticketIntegers[numberOfHouse - 3]) {
						if (ticketIntegerList.get(beforeIndex) == ticketIntegers[numberOfHouse - 2]
								|| ticketIntegerList.get(afterIndex) == ticketIntegers[numberOfHouse - 2]) {
							if(ticketIntegerList.get(beforeIndex) == ticketIntegers[numberOfHouse - 3]
								|| ticketIntegerList.get(afterIndex) == ticketIntegers[numberOfHouse - 3]) {
								secondMax = ticketIntegers[numberOfHouse - 4];
								checkSecondMax = true;
							}else {
								secondMax = ticketIntegers[numberOfHouse - 3];
							}
							
						} else {
							secondMax = ticketIntegers[numberOfHouse - 2];
						}
						if(secondMax+max < max) {
							op = String.valueOf(max);
						}else if (checkSecondMax && (secondMax<ticketIntegers[numberOfHouse - 3]) &&(secondMax+max)<= (ticketIntegers[numberOfHouse - 3]+ ticketIntegers[numberOfHouse - 2])){
							op = String.valueOf(ticketIntegers[numberOfHouse - 3])+ String.valueOf(ticketIntegers[numberOfHouse - 2]);
						}else {
							op = String.valueOf(secondMax) + String.valueOf(max);	
						}
						
					} else {
						if(ticketIntegerList.get(beforeIndex) == ticketIntegers[numberOfHouse - 3]
								|| ticketIntegerList.get(afterIndex) == ticketIntegers[numberOfHouse - 3]) {
								secondMax = ticketIntegers[numberOfHouse - 4];	
								checkSecondMax = true;
							}else {
								secondMax = ticketIntegers[numberOfHouse - 3];
							}
						if(secondMax+max < max) {
							op = String.valueOf(max);
						}else if (checkSecondMax && (secondMax<ticketIntegers[numberOfHouse - 3]) &&(secondMax+max)<= (ticketIntegers[numberOfHouse - 3]+ ticketIntegers[numberOfHouse - 2])){
							op = String.valueOf(ticketIntegers[numberOfHouse - 3])+ String.valueOf(ticketIntegers[numberOfHouse - 2]);
						}else {
							op = String.valueOf(secondMax) + String.valueOf(max);	
						}
					}
				} else if (maxIndex == 0) {
					afterIndex = maxIndex + 1;
					if (ticketIntegers[numberOfHouse - 2] != ticketIntegers[numberOfHouse - 3]) {
						if (ticketIntegerList.get(afterIndex) == ticketIntegers[numberOfHouse - 2]) {
							if(ticketIntegerList.get(afterIndex) == ticketIntegers[numberOfHouse - 3]) {
									secondMax = ticketIntegers[numberOfHouse - 4];	
									checkSecondMax = true;
								}else {
									secondMax = ticketIntegers[numberOfHouse - 3];
								}
						} else {
							secondMax = ticketIntegers[numberOfHouse - 2];
						}
						if(secondMax+max < max) {
							op = String.valueOf(max);
						}else if (checkSecondMax && (secondMax<ticketIntegers[numberOfHouse - 3]) &&(secondMax+max)<= (ticketIntegers[numberOfHouse - 3]+ ticketIntegers[numberOfHouse - 2])){
							op = String.valueOf(ticketIntegers[numberOfHouse - 3])+ String.valueOf(ticketIntegers[numberOfHouse - 2]);
						}else {
							op = String.valueOf(secondMax) + String.valueOf(max);	
						}
					} else {
						secondMax = ticketIntegers[numberOfHouse - 3];
						if(secondMax+max < max) {
							op = String.valueOf(max);
						}else {
							op = String.valueOf(secondMax) + String.valueOf(max);	
						}
					}
				} else if (maxIndex == ticketIntegerList.size() - 1) {
					beforeIndex = maxIndex - 1;
					if (ticketIntegers[numberOfHouse - 2] != ticketIntegers[numberOfHouse - 3]) {
						if (ticketIntegerList.get(beforeIndex) == ticketIntegers[numberOfHouse - 2]) {
							if(ticketIntegerList.get(beforeIndex) == ticketIntegers[numberOfHouse - 3]) {
									secondMax = ticketIntegers[numberOfHouse - 4];	
									checkSecondMax = true;
								}else {
									secondMax = ticketIntegers[numberOfHouse - 3];
								}
						} else {
							secondMax = ticketIntegers[numberOfHouse - 2];
						}
						if(secondMax+max < max) {
							op = String.valueOf(max);
						}else if (checkSecondMax && (secondMax<ticketIntegers[numberOfHouse - 3]) &&(secondMax+max)<= (ticketIntegers[numberOfHouse - 3]+ ticketIntegers[numberOfHouse - 2])){
							op = String.valueOf(ticketIntegers[numberOfHouse - 3])+ String.valueOf(ticketIntegers[numberOfHouse - 2]);
						}else {
							op = String.valueOf(secondMax) + String.valueOf(max);	
						}
					} else {
						secondMax = ticketIntegers[numberOfHouse - 3];
						if(secondMax+max < max) {
							op = String.valueOf(max);
						}else {
							op = String.valueOf(secondMax) + String.valueOf(max);	
						}
					}
				} 
			}
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

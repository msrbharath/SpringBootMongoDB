package com.cognizant.outreach.microservices.gateway.playground;

package com.cognizant.outreach.microservices.gateway.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NeighboursPartyAlternate {

       public static void main(String[] args) {
              Scanner scannerIP = new Scanner(System.in);
              int numberOfCases = Integer.parseInt(scannerIP.next());
              List<String> outputList = new ArrayList<String>();
              StringBuilder sb1 = new StringBuilder();
              StringBuilder sb2 = new StringBuilder();
              for (int casee = 0; casee < numberOfCases; casee++) {
                     long numberOfHouse = Long.parseLong(scannerIP.next());
                     scannerIP.nextLine();
                     String tickets = scannerIP.nextLine();
                     String[] ticketInputs = tickets.split("\\s+");
                     long[] ticketIntegers = Arrays.stream(ticketInputs).mapToLong(Long::parseLong).toArray();
                     if (ticketInputs.length != numberOfHouse) {
                           System.out.println("Invalid Input");
                           System.exit(0);
                     }
                     boolean flipNeighbour = false;
                     long sum1 = 0L;
                     long sum2 = 0L;
                     long minVal1 = Long.MAX_VALUE;
                     long minVal2 = Long.MAX_VALUE ;
                     long negativeMax1 = Long.MIN_VALUE;
                     long negativeMax2 = Long.MIN_VALUE;

                     for (long temp : ticketIntegers) {
                           if(flipNeighbour) {
                                  if(temp<=0 && negativeMax1<temp) {
                                         negativeMax1=temp;
                                  }else {
                                         sum1+=temp;
                                         sb1.insert(0, temp);
                                         if(temp<minVal1){
                                             minVal1=temp;
                                         }
                                  }
                                  flipNeighbour=!flipNeighbour;
                           }else {
                                  if(temp<=0 && negativeMax2<temp) {
                                         negativeMax2=temp;
                                  }else {
                                         sum2+=temp;
                                         sb2.insert(0, temp);
                                         if(temp<minVal2){
                                             minVal2=temp;
                                         }
                                  }
                                  flipNeighbour=!flipNeighbour;
                           }
                     }

                     if(sum1>sum2) {
                           outputList.add(sb1.toString());
                     }else if(sum2>sum1) {
                           outputList.add(sb2.toString());
                     }else if(sum1>0L && sum2>0L && sum1==sum2) {
                    	 if(minVal1>minVal2) {
                    		 outputList.add(sb1.toString());
                    	 }else {
                    		 outputList.add(sb2.toString());
                    	 }
                     }else if(sum1==0L && sum2==0L 
                    		 && (negativeMax1!=Long.MIN_VALUE || negativeMax2!=Long.MIN_VALUE) ) {
                    	 if(negativeMax1>negativeMax2) {
                    		 sb1.append(negativeMax1);
                    		 outputList.add(sb1.toString());
                    	 }else {
                    		 sb2.append(negativeMax2);
                    		 outputList.add(sb2.toString());
                    	 }
                    	 
                     }
                     sb1.delete(0, sb1.length());
                     sb2.delete(0, sb2.length());
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

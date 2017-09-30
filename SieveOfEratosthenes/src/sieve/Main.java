/* 
 * This file is part of an Sieve of Eratosthenes
 * Brian Denlinger
 * brian.denlinger1@gmail.com
 * 
 * This is free software: you can redistribute it and/or modify  
 * it under the terms of the GNU Lesser General Public License as   
 * published by the Free Software Foundation, version 2.1.
 *
 * This is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package sieve;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		System.out.println("Max number to search to?");
		Scanner keyboard = new Scanner(System.in);
		int max = keyboard.nextInt();

		
		Sieve sieve = new Sieve(max);
		List<Integer> v = new Vector<Integer>();
		
		long startTime = System.nanoTime();
		v.addAll(sieve.sieveOfEratosthenes(max));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		System.out.println(v.size() + " prime numbers between 2 and " + max);
		System.out.println("Execution took " + duration/1000000 + " milliseconds.");
		System.out.println("Print list? [y/N]");
		boolean yn = true;
		while(yn) {
			String response = keyboard.next();
			if(response.substring(0, 1).equalsIgnoreCase("y")) {
				yn = false;
				printList(v);
			} else if(response.substring(0, 1).equalsIgnoreCase("n")) {
				yn = false;
			} else if(response.substring(0, 1).equalsIgnoreCase("\n")) {
				yn = false;
			} else {
				System.out.println("Print list? [y/N]");
			}
		}
		
		keyboard.close();
	}
	
	private static <T> void printList(List<T> ltp) {
		ltp.forEach((k)->System.out.println(k));
	}
}
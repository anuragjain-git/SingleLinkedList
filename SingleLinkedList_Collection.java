package SingleLinkedList;

	import java.util.LinkedList;
	import java.util.Scanner;
	public class SingleLinkedList_Collection {
		
		// REVERSE | T(n) = O(n)
		public static void reverse(LinkedList<Integer> al) {
			for(int i = al.size()-1; i >= 0; i--) {
				al.add(al.get(i));
				al.remove(i);
			}
			System.out.println("Reverse linkedlist is "+al);
		}
		
		// INSERT | T(n) = O(1)
		public static void insert(LinkedList<Integer> al) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter index to insert : ");
			int ind = sc.nextInt();
			System.out.print("Enter elements to insert : ");
			int inp = sc.nextInt();		
			al.add(ind,inp);
		}
		
		// SORTING USING BUBBLE SORT | T(n) = O(n^2)
		public static LinkedList<Integer> sort(LinkedList<Integer> al, int size) {
			for (int i = 0; i < size - 1; i++) {
				for (int j = 0; j < size - i - 1; j++) {
	            	if (al.get(j) > al.get(j+1)) {
	                    int temp = al.get(j);
	                    al.add(j,al.get(j+1));
	                    al.add(j+1,temp);
	                    al.remove(j+1);
	                	al.remove(j+2);
	                }
	            	
	            		//below code is to see sorting after each iteration
	            		//System.out.println("Sorted linkedlist is "+al);
	            }
			}       
			//System.out.println("Sorted linkedlist is "+al);
			return al;
			
		}
		
		// REMOVE AT AN INDEX | T(n) = O(1)
		public static void removeIndex(LinkedList<Integer> al) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter index to remove : ");
			al.remove(sc.nextInt());
			System.out.println("New linked list is "+al);
		}
		
		// REMOVE FIRST OCCURANCE OF AN ELEMENT | T(n) = O(n)
		public static void removeElement(LinkedList<Integer> al) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter element to remove : ");
			al.removeFirstOccurrence(sc.nextInt());
			System.out.println("New linked list is "+al);
		}
		
		// REMOVE ALL OCCURANCE OF AN ELEMENT| T(n) = O(n)
		public static void removeAllElement(LinkedList<Integer> al, int num) {
			while(al.contains(num)) {
				al.remove(al.indexOf(num));
			}
			System.out.println("After removing "+al);
		}
		
		// ARRANGING IN decreasingEvenPosition AND increasingOddPosition | T(n) = O(n^2) + O(n/2)
		public static void decreasingEvenPosition(LinkedList<Integer> al, boolean sorted) {
			// after sorting odd position will be in inc order	
			if(!sorted) {
				sort(al,al.size());   // T(n) = O(n^2);
			}
			int size = al.size();
			int i = 1;
			int j;
			if(size % 2 == 0) {
				// j, if last element is at even position 
				j = size - 1;
			}
			else {
				j = size - 2;
			}
			while(i < j) // T(n) = O(n/2)
			{
				int temp = al.get(j);
				al.add(j,al.get(i));
				al.remove(j+1);
				al.add(i,temp);
				al.remove(i+1);
				i+=2;
				j-=2;
			}
			System.out.println("Odd inc, Even dec position"+al);
		}
		
		public static void main(String[] args) {
			
			//TAKE INPUTS IN LINKED LIST 
			LinkedList<Integer> al = new LinkedList<Integer>();
			Scanner sc = new Scanner(System.in);
			System.out.print("Total number of input : ");
			int n = sc.nextInt();
			System.out.print("Enter "+n+" elements : ");
			while(n != 0) {
				al.add(sc.nextInt());
				n--;
			}
			System.out.println("User Inputs are "+al);	
			
			// REVERSE METHOD
			System.out.print("Do you want to reverse ? Y/N : ");
			char response = sc.next().charAt(0);
			while(response == 'y' || response == 'Y') {
				reverse(al);
				System.out.print("Do you want to reverse ? Y/N : ");
				response = sc.next().charAt(0);
			}
			
			//INSERT METHOD
			System.out.print("Do you want to insert ? Y/N : ");
			response = sc.next().charAt(0);
			while(response == 'y' || response == 'Y') {
				insert(al);
				System.out.print("Do you want to insert ? Y/N : ");
				response = sc.next().charAt(0);
			}
			
			//PRINT LINKED LIST
			System.out.print("Do you want to Print LinkedList ? Y/N : ");
			response = sc.next().charAt(0);
			if(response == 'y' || response == 'Y') {
				System.out.println("linked list : "+ al);
			}
			
			//SORT LINKED LIST USING BUBBLE SORT
			boolean sorted = false ;
			System.out.print("Do you want to sort ? Y/N : ");
			response = sc.next().charAt(0);
			if(response == 'y' || response == 'Y') {
				sorted = true;
				System.out.println("Sorted linked list is "+ sort(al,al.size()));
			}
			
			//REMOVE ELEMENTS AT AN INDEX
			System.out.print("Do you want to remove at any index ? Y/N : ");
			response = sc.next().charAt(0);
			while(response == 'y' || response == 'Y') {
				removeIndex(al);
				System.out.print("Do you want to remove at any index ? Y/N : ");
				response = sc.next().charAt(0);
			}
			
			//REMOVE FIRST OCCURANCE OF AN ELEMENTS
			System.out.print("Do you want to remove first occurance of an element ? Y/N : ");
			response = sc.next().charAt(0);
			while(response == 'y' || response == 'Y') {
				removeElement(al);
				System.out.print("Do you want to remove first occurance of an element ? Y/N : ");
				response = sc.next().charAt(0);
			}
			
			//REMOVE ALL OCCURANCE OF AN ELEMENTS
			System.out.print("Do you want to an remove all occurance of an element? Y/N : ");
			response = sc.next().charAt(0);
			while(response == 'y' || response == 'Y') {
				System.out.print("Enter element to remove: ");
				removeAllElement(al,sc.nextInt());
				System.out.print("Do you want to an remove all occurance of an element? Y/N : ");
				response = sc.next().charAt(0);
			}
			
			//PRINT LINKEDLIST
			System.out.print("Do you want to Print LinkedList ? Y/N : ");
			response = sc.next().charAt(0);
			if(response == 'y' || response == 'Y') {
				System.out.println("linked list : "+ al);
			}
			
			//ARRANGING LINKED LIST IN increasingOddPosition AND decreasingEvenPosition
			System.out.print("Do you arrange elements in decreasingEvenPosition and increasingOddPosition? Y/N : ");
			if(sc.next().charAt(0)=='y' || sc.next().charAt(0)=='Y' ) {
				decreasingEvenPosition(al, sorted);
			}
		}
	}
import java.util.Random;
import java.util.Scanner;


/**
 * Play the game of Nim against the computer.
 * @author jeremytimothybrown
 *
 */
public class GameOfNim {

	/** 
	 * Returns true if the input parameter is a power of 2.
	 * @param n An integer.
	 * @return True if n is a power of 2.  False, otherwise.  
	 */
	public static boolean isPowerOfTwo(int n) {
		
		return ((n & (n-1)) == 0);  // clever as all heck, isn't it?
									// The & is a bit-wise AND
									// Suppose n = 4 (100).
									// Then (n-1) = 3 (011).
									// If you AND those two, you get 000
									// You will only get 0 if n is
									// a power of 2.
	}
	
	//for some reason, my bot can choose 0 when playing hard mode :(
	
	/**
	 * Asks the user whether they want to play against
	 * an easy computer player or a hard one.
	 * Then it plays the game.  
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		
		boolean win=true;
		boolean boolHard=false;
		int yourChoice = 0, hard = 0;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Would you like to play against an easy bot or a hard bot? ");
		String answer = scan.next();
		
		Random marbles = new Random();
		int numMarbles = marbles.nextInt(100) + 10;
		
		Random bot = new Random();
		
		Random whoGoes = new Random();
		int a = whoGoes.nextInt(2);  //0 -> user goes first, 1 -> bot goes first
		
		@SuppressWarnings("resource")
		Scanner scan2 = new Scanner(System.in);
		
		if(answer.equals("easy")){
			System.out.println("\nThis game is against an easy player.");
			System.out.println("The game starts with "+numMarbles+" marbles.");
			if(a==0){
				System.out.println("You go first.");
				while(win){
					while(yourChoice < 1 || yourChoice > numMarbles/2){
						System.out.print("Enter the number of marbles you wish to take: ");
						yourChoice = scan2.nextInt();
						if (yourChoice < 1 || yourChoice > numMarbles/2){
							System.out.println("You must enter a choice between 1 and "+numMarbles/2+".");
						}
					}
					numMarbles -= yourChoice;
					if(numMarbles==1){System.out.println("You Win!"); break;}
					int easy = bot.nextInt(numMarbles/2) + 1;
					System.out.println("Bot takes "+easy+" marbles.");
					numMarbles -= easy;
					if(numMarbles==1){System.out.println("Bot wins..."); break;}
					System.out.println("There are "+numMarbles+" left.");
					yourChoice = 0;
				}	
			}
			else if(a==1){
				System.out.println("Bot goes first.");
				while(win){
					int easy = bot.nextInt(numMarbles/2) + 1;
					System.out.println("Bot takes "+easy+" marbles.");
					numMarbles -= easy;
					if(numMarbles==1){System.out.println("Bot wins..."); break;}
					System.out.println("There are "+numMarbles+" left.");
					while(yourChoice < 1 || yourChoice > numMarbles/2){
						System.out.print("Enter the number of marbles you wish to take: ");
						yourChoice = scan2.nextInt();
						if (yourChoice < 1 || yourChoice > numMarbles/2){
							System.out.println("You must enter a choice between 1 and "+numMarbles/2+".");
						}
					}
					numMarbles -= yourChoice;
					if(numMarbles==1){System.out.println("You Win!"); break;}
					yourChoice = 0;
				}
			}
		}
		
		else if (answer.equals("hard")){
			System.out.println("This game is against an hard player.");
			System.out.println("The game starts with "+numMarbles+" marbles.");
			
			if(a==0){
				System.out.println("You go first.");
				while(win){
					while(yourChoice < 1 || yourChoice > numMarbles/2){
						System.out.print("Enter the number of marbles you wish to take: ");
						yourChoice = scan2.nextInt();
						if (yourChoice < 1 || yourChoice > numMarbles/2){
							System.out.println("You must enter a choice between 1 and "+numMarbles/2+".");
						}
					}
					numMarbles -= yourChoice;
					if(numMarbles==1){System.out.println("You Win!"); break;}
					while(!boolHard){
						hard = bot.nextInt(numMarbles/2) + 2;
						boolHard = isPowerOfTwo(hard);
					}
					boolHard = false;
					System.out.println("Bot takes "+(hard-1)+" marbles.");
					numMarbles -= (hard-1);
					if(numMarbles==1){System.out.println("Bot wins..."); break;}
					System.out.println("There are "+numMarbles+" left.");
					yourChoice = 0;
				}
				
			}
			else if(a==1){
				System.out.println("Bot goes first.");
				while(win){
					while(!boolHard){
						hard = bot.nextInt(numMarbles/2) + 2;
						boolHard = isPowerOfTwo(hard);
					}
					boolHard = false;
					System.out.println("Bot takes "+(hard-1)+" marbles.");
					numMarbles -= (hard-1);
					if(numMarbles==1){System.out.println("Bot wins..."); break;}
					System.out.println("There are "+numMarbles+" left.");
					while(yourChoice < 1 || yourChoice > numMarbles/2){
						System.out.print("Enter the number of marbles you wish to take: ");
						yourChoice = scan2.nextInt();
						if (yourChoice < 1 || yourChoice > numMarbles/2){
							System.out.println("You must enter a choice between 1 and "+numMarbles/2+".");
						}
					}
					numMarbles -= yourChoice;
					if(numMarbles==1){System.out.println("You Win!"); break;}
					yourChoice = 0;
			}
		}
		
		else{
			System.out.println("You did not input a correct bot choice.\n");
			main(args);
		}
	}
}
}

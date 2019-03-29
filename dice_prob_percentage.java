import java.util.*;

class Dice
{
	private int die1;
	private int die2;
	public Dice()
	{
		this.die1 = 0;
		this.die2 = 0;
	}
	private int getDiceRoll()
	{
		Random random = new Random();
		return (1 + random.nextInt(6));
	}
	public int byDiv()
	{
		Random r = new Random();
		int low=95;
		int high=150;
		return (r.nextInt(high-low) + low);
	}
	public int getDiceSum()
	{
		this.die1 = getDiceRoll();
		this.die2 = getDiceRoll();
		return this.die1 + this.die2;
	}
}
class DiceApplication
{
	public static void main(String args[])
	{
		int r_no=1;
		char c;
		int freq[] = new int[11];
		Dice myDice = new Dice();
		Scanner ob = new Scanner(System.in);
		System.out.println("*******************************************************");
		System.out.println("*******************Dice Staticstics********************");
		System.out.println("*******************************************************\n\n");
		System.out.println("This Program will simulate dice rolls and calculate the percentages\nof each possible outcome. You input how many dice throws you'd like in\neach round.You can repeat and do another round, or quit when done. ");
		do
		{
			System.out.print("\nHow many dice throws do you want to do for Round#"+r_no+":");
			int total=ob.nextInt();
			System.out.print("Statistics for Round#"+r_no+":\n");
			for (int i = 0; i < freq.length; i++)
			{
				freq[i] = 0;
			}
			for (int i = 0; i < total; i++)
			{
				++freq[ myDice.getDiceSum()-2];
			}
			System.out.printf("%3s%11s%10s\n","Roll", "Count", "Pct" );
			System.out.printf("%3s%11s%10s\n","----", "-----", "---" );		
			for (int dietotal = 0; dietotal  < freq.length;  dietotal++)
			{
				double percent = (double)freq[ dietotal ] / ( total/myDice.byDiv());
				System.out.printf("%3d%12d%11.2f\n", dietotal+2, freq[dietotal], percent);
			}
			System.out.print("Would you like to another simulation? Y|N:");
			c= ob.next().charAt(0);
			if(c == 'Y')
			{
				r_no++;
			}
			else if(c =='N')
			{
				System.out.println("Program Ending.Have a fantastic day.");
			}
			else
			{
				System.out.println("Enter valid choice (Y|N)");
			}
		}while(c == 'Y');
		
	}
}


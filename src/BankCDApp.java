import java.text.NumberFormat;

/**
 * Class representing command-line interface to compute yearly and daily compounded certificate of deposit.
 * Allows the user to input the principal value, interest rate and time to maturity
 *  
 * @author Tahmid Kazi
 *
 */
public class BankCDApp {
	
	private BankCD bank;
	private InteractiveCLI cli;
	
	/**
	 * Constructs BankCD object and initializes the InteravtiveCLI object
	 */
	public BankCDApp() {
		
		cli = new InteractiveCLI();

	}
	
	/**
	 * Runs the CLI
	 * Prompts the user for the principal amount, interest rate and number of years to maturity as doubles
	 * Takes the user inputs and uses BankCD to calculate the value and outputs that value to the user
	 * Numbers are formatted according to each input listed
	 */
	public void run() {
		
		System.out.println("************************ OUTPUT ********************");
		System.out.println("Compare daily and annual compounding for a Bank CD.");
		
		this.cli.prompt(" Input CD initial principal, e.g. 1000.55 > ");
		double principal = this.cli.getKeyboardDouble();
		
		this.cli.prompt(" Input CD interest rate, e.g. 6.5 > ");
		double rate = this.cli.getKeyboardDouble();
		
		this.cli.prompt(" Input the number of years to maturity, e.g. 10.5 > ");
		double years= this.cli.getKeyboardDouble();
		
		bank = new BankCD(principal, rate, years);
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		NumberFormat yearFormat = NumberFormat.getNumberInstance();
		yearFormat.setMinimumFractionDigits(1);
		
		NumberFormat rateFormat = NumberFormat.getPercentInstance();
		rateFormat.setMinimumFractionDigits(1);
		
		System.out.println("For Principal = " + currencyFormat.format(principal) + " Rate = " + rateFormat.format(rate / 100) + 
				" Years = " + yearFormat.format(years));
		
		this.cli.display(" The maturity value compounded yearly is: " + currencyFormat.format(bank.calcYearly()));
		this.cli.display(" The maturity value compounded daily is: " + currencyFormat.format(bank.calcDaily()));
		
		System.out.println("************************ OUTPUT ********************");
		
	}

	public static void main(String[] args) {
		
		BankCDApp app = new BankCDApp();
		app.run();
		

	}

}

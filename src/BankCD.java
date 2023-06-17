/**
 * Class representing a certificate of deposit.
 * Calculated the maturity value of the CD with yearly and daily compounding with paramters being:
 * Principal in dollars
 * Interest rate as a percent
 * Number of years to maturity
 * 
 * @author Tahmid Kazi
 *
 */
public class BankCD {
	
	double principal = 0;
	double rate = 0;
	double years = 0;
	
	/**
	 * Constructs BankCD object with the below parameters:
	 * @param p initial principal amount.
	 * @param r the annual interest rate.
	 * @param y the number of years to maturity.
	 */
	BankCD(double p, double r, double y) {
		this.principal = p;
		this.rate = r;
		this.years = y;
		
	}
	
	/**
	 * Calculates the maturity value of the CD with yearly compounding.
	 * @return returns a double of the maturity value
	 */
	public double calcYearly() {
		return this.principal * Math.pow(1 + (this.rate / 100), this.years);
	}
	
	/**
	 * Calculates the maturity value of the CD with daily compounding.
	 * @return returns a double of the maturity value
	 */
	public double calcDaily() {
		return this.principal * Math.pow(1 + ((this.rate / 100) / 365), (365 * this.years));
	}
	
	
}

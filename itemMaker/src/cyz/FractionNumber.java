package cyz;

//分数
public class FractionNumber implements Caculatable {

	private Integer numerator;//分子
	private Integer denominator;//分母
	private static Boolean hasBrackets; //是否包含括号
	
	static public Boolean getHasBrackets() {
		return hasBrackets;
	}

	static public void setHasBrackets(Boolean hasBrackets) {
		FractionNumber.hasBrackets = hasBrackets;
	}

	public FractionNumber(Integer numerator, Integer denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Integer getNumerator() {
		return numerator;
	}

	public void setNumerator(Integer numerator) {
		this.numerator = numerator;
	}

	public Integer getDenominator() {
		return denominator;
	}

	public void setDenominator(Integer denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		simplify();
		if(FractionNumber.hasBrackets){
			return "("+numerator+"/"+denominator+")";
		}else{
			return numerator+"/"+denominator;
		}
	}
	private void simplify(){//化简
		int maxCommand = getMaxCommand();
		numerator/=maxCommand;
		denominator/=maxCommand;
	}
	 int getMaxCommand(){//获得最大公因子
	        int temp;
	        int a = numerator;
	        int b = denominator;
	        if(a < b){
	            temp = a;
	            a = b;
	            b = temp;
	        }
	        while(b != 0){
	            temp = a % b;
	            a = b;
	            b = temp;
	        }
	        return a;
	}
	@Override
	public Double getValue() {
		Double numer=numerator.doubleValue();
		Double denomin=denominator.doubleValue();
		Double result=numer/denomin;
		return result;
	}

	@Override
	public Caculatable add(Caculatable nextNumber) {
		if(nextNumber instanceof FractionNumber){
			FractionNumber toFractionNumber=(FractionNumber) nextNumber;
			Integer newNumberator=numerator*toFractionNumber.getDenominator()+denominator*toFractionNumber.getNumerator();
			Integer newDenominator=denominator*toFractionNumber.getDenominator();
			FractionNumber number=new FractionNumber(newNumberator,newDenominator);
			return number;
		}
		return null;
	}

	@Override
	public Caculatable sub(Caculatable nextNumber) {
		if(nextNumber instanceof FractionNumber){
			FractionNumber toFractionNumber=(FractionNumber) nextNumber;
			Integer newNumberator=numerator*toFractionNumber.getDenominator()-denominator*toFractionNumber.getNumerator();
			Integer newDenominator=denominator*toFractionNumber.getDenominator();
			FractionNumber number=new FractionNumber(newNumberator,newDenominator);
			return number;
		}
		return null;
	}

	@Override
	public Caculatable mul(Caculatable nextNumber) {
		if(nextNumber instanceof FractionNumber){
			FractionNumber toFractionNumber=(FractionNumber) nextNumber;
			Integer newNumberator=numerator*toFractionNumber.getNumerator();
			Integer newDenominator=denominator*toFractionNumber.getDenominator();
			FractionNumber number=new FractionNumber(newNumberator,newDenominator);
			return number;
		}
		return null;
	}

	@Override
	public Caculatable div(Caculatable nextNumber) {
		if(nextNumber instanceof FractionNumber){
			FractionNumber toFractionNumber=(FractionNumber) nextNumber;
			Integer newNumberator=numerator*toFractionNumber.getDenominator();
			Integer newDenominator=denominator*toFractionNumber.getNumerator();
			FractionNumber number=new FractionNumber(newNumberator,newDenominator);
			return number;
		}
		return null;
	}

}

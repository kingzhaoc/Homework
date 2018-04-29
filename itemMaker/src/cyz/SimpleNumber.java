package cyz;

//简单整数
public class SimpleNumber implements Caculatable{

	private Integer number;
	
	public void setValue(Integer number) {
		this.number = number;
	}

	public SimpleNumber(Integer number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return number.toString();
	}

	@Override
	public Double getValue() {
		return number.doubleValue();
	}

	@Override
	public Caculatable add(Caculatable nextNumber) {
		Integer number2=nextNumber.getValue().intValue();
		SimpleNumber result=new SimpleNumber(number+number2);
		return result;
	}

	@Override
	public Caculatable sub(Caculatable nextNumber) {
		Integer number2=nextNumber.getValue().intValue();
		SimpleNumber result=new SimpleNumber(number-number2);
		return result;
	}

	@Override
	public Caculatable mul(Caculatable nextNumber) {
		Integer number2=nextNumber.getValue().intValue();
		SimpleNumber result=new SimpleNumber(number*number2);
		return result;
	}

	@Override
	public Caculatable div(Caculatable nextNumber) {
		Integer number2=nextNumber.getValue().intValue();
		SimpleNumber result=new SimpleNumber(number/number2);
		return result;
	}

	
}

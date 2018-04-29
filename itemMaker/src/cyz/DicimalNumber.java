package cyz;

/**
 * 这是小数的类
 */
import java.text.DecimalFormat;

//小数
public class DicimalNumber implements Caculatable {

	private Double number;
	private static Integer dicimalDigits=2;//保留多少位小数
	
	public DicimalNumber(Double number) {
		super();
		this.number = number;
	}
	public Double getNumber() {
		return number;
	}
	public void setNumber(Double number) {
		this.number = number;
	}
	@Override
	public String toString() {
		//保留n位小数
		StringBuffer buffer=new StringBuffer("");
		for(int i=0;i<dicimalDigits;i++){
			buffer.append("0");
		}
		DecimalFormat formater=new DecimalFormat("#."+buffer);
		String result=formater.format(number);
		return result;
	}
	@Override
	public Double getValue() {
		return number;
	}
	@Override
	public Caculatable add(Caculatable nextNumber) {
		Double value=nextNumber.getValue();
		DicimalNumber result=new DicimalNumber(value+number);
		return result;
	}
	@Override
	public Caculatable sub(Caculatable nextNumber) {
		Double value=nextNumber.getValue();
		DicimalNumber result=new DicimalNumber(number-value);
		return result;
	}
	@Override
	public Caculatable mul(Caculatable nextNumber) {
		Double value=nextNumber.getValue();
		DicimalNumber result=new DicimalNumber(value*number);
		return result;
	}
	@Override
	public Caculatable div(Caculatable nextNumber) {
		Double value=nextNumber.getValue();
		DicimalNumber result=new DicimalNumber(number/value);
		return result;
	}

}

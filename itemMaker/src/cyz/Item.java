package cyz;

//题目
public class Item {
	private Caculatable number1; 
	private Caculatable number2;
	private Operator operator; //运算方式
	private Caculatable result; //运算结果
	public String resultStr;
	public Item(Caculatable number1, Caculatable number2, Operator operator) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.operator = operator;
	}
	
	@Override
	public String toString() {
		String operatorStr;
		switch (operator.value()) {
		case 0:
			operatorStr="+";
			break;
		case 1:	
			operatorStr="-";
			break;
		case 2:
			operatorStr="*";
			break;
		default:
			operatorStr="/";
			break;
		}
		return number1+operatorStr+number2+"=";
	}

	/*计算结果*/
	public void caculate(){
		if(operator==Operator.ADD){
			result=number1.add(number2);
		}else if(operator==Operator.SUB){
			result=number1.sub(number2);
		}else if(operator==Operator.MULTIPART){
			result=number1.mul(number2);
		}else{
			result=number1.div(number2);
		}
	}
	/*验证回答是否正确*/
	public Boolean checkAnswer(String inputResult){
		caculate();
		if (number1 instanceof SimpleNumber) {
			SimpleNumber simpleNumber=(SimpleNumber) result;
			if (inputResult.equals(simpleNumber.toString())) {
				return true;
			}
			resultStr=simpleNumber.toString();
		}else if(number1 instanceof DicimalNumber){
			DicimalNumber dicimalNumber=(DicimalNumber) result;
			if (inputResult.equals(dicimalNumber.toString())) {
				return true;
			}
			resultStr=dicimalNumber.toString();
		}
		else{
			FractionNumber fractionNumber=(FractionNumber) result;
			if (inputResult.equals(fractionNumber.toString())) {
				return true;
			}
			resultStr=fractionNumber.toString();
		}
		return false;
	}
	public Caculatable getNumber1() {
		return number1;
	}
	public void setNumber1(Caculatable number1) {
		this.number1 = number1;
	}
	public Caculatable getNumber2() {
		return number2;
	}
	public void setNumber2(Caculatable number2) {
		this.number2 = number2;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}

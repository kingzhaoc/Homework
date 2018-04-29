package cyz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//题目生成器
public class ItemMaker {
	public List<Item> items;
	public Integer itemCount;
	public Integer maxNumber;
	public Boolean hasMultiplicationAndDivision=false;//是否含有乘除
	public Boolean hasBrackets=false; //是否含有括号
	public Boolean divisionHasRemainder=false; //除法是否能余数
	public Boolean addHasNegative=false; //加减是否能有负数
	public Boolean hasFraction=false;	//是否能有分数
	public Boolean hasDecimal =false;	//是否能有小数
	public ItemMaker(){
		items=new ArrayList<Item>();
	}
	public void start(){
		intputRequirement();
		createItem();
		doExercise();
	}
	/*
	 * 按照用户需求生成题目。
	 */
	public void createItem(){
		
		for (int i=0;i<itemCount;i++) {
			Operator operator=null;
			if(hasMultiplicationAndDivision){
				Float choose=new Random().nextFloat()*4;//包含乘除
				Integer intChoose=choose.intValue();
				operator=Operator.valueOf(intChoose);
			}else{
				Float choose=new Random().nextFloat()*2;//不包含乘除
				Integer intChoose=choose.intValue();
				operator=Operator.valueOf(intChoose);
			}
			FractionNumber.setHasBrackets(hasBrackets);
			Caculatable number1=null;
			Caculatable number2=null;
			Integer choose=1;
			if(hasFraction){
				choose++;
			}
			if(hasDecimal){
				choose++;
			}
			Float randType=new Random().nextFloat()*choose+1;
			Integer itemType=randType.intValue();
			if(itemType==1){//出普通数字题
				Float randNumber1=new Random().nextFloat()*maxNumber+1;
				Float randNumber2=new Random().nextFloat()*maxNumber+1;
				number1=new SimpleNumber(randNumber1.intValue());
				number2=new SimpleNumber(randNumber2.intValue());
			}else if(itemType==2){//出小数运算题。
				Double randNumber1;
				Double randNumber2;
				Float num1=new Random().nextFloat()*maxNumber+1;
				Float num2=new Random().nextFloat()*maxNumber+1;
				if(addHasNegative){
					Float hasNegative=new Random().nextFloat()*2;
					if(hasNegative>1){
						randNumber1=num1.doubleValue();
						randNumber2=num2.doubleValue();
					}else{
						randNumber1=-num1.doubleValue();
						randNumber2=-num2.doubleValue();
					}
				}else{
					randNumber1=num1.doubleValue();
					randNumber2=num2.doubleValue();
				}
				number1=new DicimalNumber(randNumber1);
				number2=new DicimalNumber(randNumber2);
			}else{//出分数计算题。
				Float numerator1=new Random().nextFloat()*maxNumber+1;
				Float denominator1=new Random().nextFloat()*maxNumber+1;
				Float numerator2=new Random().nextFloat()*maxNumber+1;
				Float denominator2=new Random().nextFloat()*maxNumber+1;
				number1=new FractionNumber(numerator1.intValue(),denominator1.intValue());
				number2=new FractionNumber(numerator2.intValue(),denominator2.intValue());
			}
			Item item=new Item(number1,number2,operator);
			items.add(item);
		}
	}
	public void doExercise(){//将题目给用户做
		Scanner input=new Scanner(System.in);
		int i=1;
		for (Item item : items) {
			System.out.println("第"+i+"题: "+item);
			i++;
			String studentAnswer=input.nextLine();
			Boolean isRight=item.checkAnswer(studentAnswer);
			if(isRight){
				System.out.println("回答正确。");
			}else{
				System.out.println("回答错误。正确答案应为:"+item.resultStr);
			}
		}
		input.close();
	}
	public void intputRequirement(){
		Scanner input=new Scanner(System.in);
		System.out.println("需要的题目个数？(输入数字):");
		itemCount=inputNumber(input);
		System.out.println("要求多少以内的数字？(输入数字):");
		maxNumber=inputNumber(input);
		System.out.println("是否需要乘除运算？(y/n):");
		hasMultiplicationAndDivision=inputYesOrNo(input);
		System.out.println("算式中能否出现括号？(y/n):");
		hasBrackets=inputYesOrNo(input);
		System.out.println("除法是否要有余数?(y/n)");
		divisionHasRemainder=inputYesOrNo(input);
		System.out.println("加减能否出现负数?(y/n)");
		addHasNegative=inputYesOrNo(input);
		System.out.println("是否需要分数运算?(y/n)");
		hasFraction=inputYesOrNo(input);
		System.out.println("是否需要小数运算?(y/n)");
		hasDecimal=inputYesOrNo(input);
	}
	public Integer inputNumber(Scanner input){
		String number=input.nextLine();
		return Integer.valueOf(number);
	}
	public Boolean inputYesOrNo(Scanner input){
		String yesOrNo=input.nextLine();
		if (yesOrNo.equals("y")) {
			return true;
		}else{
			return false;
		}
	}

}

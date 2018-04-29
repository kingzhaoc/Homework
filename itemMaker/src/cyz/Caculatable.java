package cyz;

//数字接口,可实现计算功能。
public interface Caculatable {
	public Double getValue();	
	Caculatable add(Caculatable nextNumber);
	Caculatable sub(Caculatable nextNumber);
	Caculatable mul(Caculatable nextNumber);
	Caculatable div(Caculatable nextNumber);
}

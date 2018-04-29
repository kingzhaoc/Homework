package cyz;

/*操作符*/
public enum Operator{
	ADD(0),SUB(1),MULTIPART(2),DEVISION(3);

    private int value = 0;

    private Operator(int value) {   
        this.value = value;
    }

    public static Operator valueOf(int value) {    
        switch (value) {
        case 0:
            return ADD;
        case 1:
            return SUB;
        case 2:
            return MULTIPART;
        default:
            return DEVISION;
        }
    }
    public int value() {
        return this.value;
    }
}

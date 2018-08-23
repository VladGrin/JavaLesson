package javalesson.mockitotest.numbertest;

public class AddNum {
    MyMath myMath;

    public AddNum(MyMath myMath) {
        this.myMath = myMath;
    }

    public int getSum(int a, int b) {
        return myMath.count(a, b);
    }
}

package javalesson.mockitotest.numbertest;

import org.junit.Before;
import org.junit.Test;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MockitoTestSetup {
    private MyMath myMath;
    private AddNum addNum;

    @Before
    public void init(){
        myMath = mock(MyMath.class);
        addNum = new AddNum(myMath);
    }

    @Test
    public void test(){
        int result = addNum.getSum(4, 5);
        verify(myMath).count(4, 5);
//        assertEquals(9, result);
    }

    // Был ли вызов метода?
    @Test
    public void simpleMocking(){
        MyMath myMath = mock(MyMath.class);    // given
        AddNum addNum = new AddNum(myMath);
        int result = addNum.getSum(2, 3);      // when
        verify(myMath).count(2, 3); // then
    }

    // Игнорим входной параметр
    @Test
    public void ignoreParametr() {
        MyMath myMath = mock(MyMath.class);    // given
        AddNum addNum = new AddNum(myMath);
        addNum.getSum(2, 3);
        verify(myMath).count(anyInt(), anyInt());
    }

    // Как застабить? Заставить мок в ответ на вызов метода вернуть то что мы хотим.
    @Test
    public void stubParametr(){
        MyMath myMath = mock(MyMath.class);    // given
        AddNum addNum = new AddNum(myMath);
        when(myMath.count(2, 3)).thenReturn(5);             // так
        stub(myMath.count(2,3)).toReturn(5);               // или так
        doReturn(5).when(myMath).count(2, 3);   // или так
        int result = addNum.getSum(2, 3);
        assertEquals(5, result);
    }

    // Обобщаем в сценарии если не важно какой параметр
    @Test
    public void ignoreString(){
        MyMath myMath = mock(MyMath.class);             // given
        AddNum addNum = new AddNum(myMath);
        when(myMath.count(anyInt(), anyInt())).thenReturn(7);
        assertEquals(7 , addNum.getSum(3, 5));  // when, then
        assertEquals(7, addNum.getSum(5,6));  // when2, then2
    }
}

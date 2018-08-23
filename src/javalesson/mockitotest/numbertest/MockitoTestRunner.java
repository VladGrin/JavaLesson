package javalesson.mockitotest.numbertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTestRunner {
    @Mock
    private MyMath myMath;

    @InjectMocks
    AddNum addNum = new AddNum(null);

    @Test
    public void test(){
        int result = addNum.getSum(2, 3);
        verify(myMath).count(2, 3);
    }
}

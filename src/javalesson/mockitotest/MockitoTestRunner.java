package javalesson.mockitotest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTestRunner {
    @Mock
    private Foo foo;

    @InjectMocks
    private Bar bar = new Bar(null);

    @Test
    public void test(){
        bar.bar("qwe");
        verify(foo).foo("qwe");
    }
}

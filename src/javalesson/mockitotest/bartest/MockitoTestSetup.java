package javalesson.mockitotest.bartest;

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
    private Foo foo;
    private Bar bar;

    @Before
    public void init(){                // import static org.mockito.Mockito.*;
        foo = Mockito.mock(Foo.class); //  foo = mock(Foo.class);
        bar = new Bar(foo);
    }

    @Test
    public void test(){
        bar.bar("qwe");
        verify(foo).foo("qwe");
    }

    // Был ли вызов метода?
    @Test
    public void simpleMocking(){
       Foo foo = mock(Foo.class);    // given
       Bar bar = new Bar(foo);
       bar.bar("qwe");      // when
       verify(foo).foo("qwe"); // then
    }

    // Игнорим входной параметр
    @Test
    public void ignoreParametr(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        bar.bar("someRandomString()");
        verify(foo).foo(anyString());
    }

    // Как застабить? Заставить мок в ответ на вызов метода вернуть то что мы хотим.
    @Test
    public void stubParametr(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo("qwe")).thenReturn("asd");             // так
        stub(foo.foo("qwe")).toReturn("asd");               // или так
        doReturn("asd").when(foo).foo("qwe");   // или так
        assertEquals("asd", bar.bar("qwe"));
//        assertNull(bar.bar("zxc"));
    }

    // Обобщаем в сценарии если не важно какой параметр
    @Test
    public void ignoreString(){
        Foo foo = mock(Foo.class);              // given
        Bar bar = new Bar(foo);
        when(foo.foo(anyString())).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));  // when, then
        assertEquals("asd", bar.bar("zxc"));  // when2, then2
    }

    // Проверка по регулярке
    @Test
    public void parametrMathes(){
        Foo foo = mock(Foo.class);                  // given
        Bar bar = new Bar(foo);
        bar.bar("qwe");                     // when
        verify(foo).foo(matches("[a-z]+"));        // then
    }

    // Сценарий по регулярке
    @Test
    public void scenarioMatches(){
        Foo foo = mock(Foo.class);                  // given
        Bar bar = new Bar(foo);
        when(foo.foo(matches("[a-z]+"))).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));  // when, then
//        assertNull(bar.bar("qwer"));                     // when2, then2
    }

    // проверки строк по проще
    @Test
    public void basicMatchers(){
        Foo foo = mock(Foo.class);                 // given
        Bar bar = new Bar(foo);
//        when(foo.foo(endsWith("we"))).thenReturn("asd");
        when(foo.foo(contains("w"))).thenReturn("asd");
        when(foo.foo(startsWith("qw"))).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));           // when, then
    }

    // Проверка строк в verify
    @Test
    public void basicMatchersVerify(){
        Foo foo = mock(Foo.class);                 // given
        Bar bar = new Bar(foo);
        bar.bar("qwe");                 //when
        verify(foo).foo(endsWith("we"));           // then
        verify(foo).foo(contains("w"));
        verify(foo).foo(startsWith("qw"));
    }

    // свой matcher
    @Test
    public void matchers(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo(argThat(isQwe()))).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));
        assertNull(bar.bar("asd"));
    }
    private Matcher<String> isQwe(){
        return new ArgumentMatcher(){
            @Override
            public boolean matches(Object argument) {
                return argument.equals("qwe");
            }
        };
    }
}

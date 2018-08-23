package javalesson.mockitotest.bartest;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MockitoTestSetup {
    private Foo foo;
    private Bar bar;

    @Before
    public void init() {                // import static org.mockito.Mockito.*;
        foo = Mockito.mock(Foo.class); //  foo = mock(Foo.class);
        bar = new Bar(foo);
    }

    @Test
    public void test() {
        bar.bar("qwe");
        verify(foo).foo("qwe");
    }

    // Был ли вызов метода?
    @Test
    public void simpleMocking() {
        Foo foo = mock(Foo.class);    // given
        Bar bar = new Bar(foo);
        bar.bar("qwe");      // when
        verify(foo).foo("qwe"); // then
    }

    // Игнорим входной параметр
    @Test
    public void ignoreParametr() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        bar.bar("someRandomString()");
        verify(foo).foo(anyString());
    }

    // Как застабить? Заставить мок в ответ на вызов метода вернуть то что мы хотим.
    @Test
    public void stubParametr() {
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
    public void ignoreString() {
        Foo foo = mock(Foo.class);              // given
        Bar bar = new Bar(foo);
        when(foo.foo(anyString())).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));  // when, then
        assertEquals("asd", bar.bar("zxc"));  // when2, then2
    }

    // Проверка по регулярке
    @Test
    public void parametrMathes() {
        Foo foo = mock(Foo.class);                  // given
        Bar bar = new Bar(foo);
        bar.bar("qwe");                     // when
        verify(foo).foo(matches("[a-z]+"));        // then
    }

    // Сценарий по регулярке
    @Test
    public void scenarioMatches() {
        Foo foo = mock(Foo.class);                  // given
        Bar bar = new Bar(foo);
        when(foo.foo(matches("[a-z]+"))).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));  // when, then
//        assertNull(bar.bar("qwer"));                     // when2, then2
    }

    // проверки строк по проще
    @Test
    public void basicMatchers() {
        Foo foo = mock(Foo.class);                 // given
        Bar bar = new Bar(foo);
//        when(foo.foo(endsWith("we"))).thenReturn("asd");
        when(foo.foo(contains("w"))).thenReturn("asd");
        when(foo.foo(startsWith("qw"))).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));           // when, then
    }

    // Проверка строк в verify
    @Test
    public void basicMatchersVerify() {
        Foo foo = mock(Foo.class);                 // given
        Bar bar = new Bar(foo);
        bar.bar("qwe");                 //when
        verify(foo).foo(endsWith("we"));           // then
        verify(foo).foo(contains("w"));
        verify(foo).foo(startsWith("qw"));
    }

    // свой matcher
    @Test
    public void matchers() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo(argThat(isQwe()))).thenReturn("asd");
        assertEquals("asd", bar.bar("qwe"));
        assertNull(bar.bar("asd"));
    }

    private Matcher<String> isQwe() {
        return new ArgumentMatcher() {
            @Override
            public boolean matches(Object argument) {
                return argument.equals("qwe");
            }
        };
    }

    // VOID   Как застабить VOID
//    @Test(expected = IllegalAccessException.class)
    @Test
    public void simpleVoidMocking() {
        FooVoid fooVoid = mock(FooVoid.class);
        BarVoid barVoid = new BarVoid(fooVoid);
        doNothing().when(fooVoid).foo("qwe");
        barVoid.bar("qwe");
        verify(fooVoid).foo("qwe"); // безсмысленная операция, наверное для галочки
//        barVoid.bar("sss");
    }

    // Если хотим выкинуть Exception
    @Test(expected = Exception.class)
    public void throwException() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo(anyString())).thenThrow(new Exception());
        bar.bar("qwe");
    }

    // Если хотим выкинуть Exception для VOID метода
    @Test(expected = Exception.class)
    public void voidThrows() {
        FooVoid fooVoid = mock(FooVoid.class);
        BarVoid barVoid = new BarVoid(fooVoid);
        doThrow(new Exception()).when(fooVoid).foo("qwe");
        barVoid.bar("qwe");
    }

    // Количество вызовов, Если нужно провалидировать сколько раз вызывался метод мока
    @Test
    public void checkTimes() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        bar.bar("qwe");
        bar.bar("qwe");
        bar.bar("qwe");
        bar.bar("asd");
        verify(foo, times(3)).foo("qwe");
        verify(foo, atLeastOnce()).foo("qwe");
        verify(foo, never()).foo("zxc");
        verify(foo, atMost(5)).foo(anyString());
    }

    // Шпионим SPY работает с реальными обьектами
    @Test
    public void spyParametr() {
        Foo foo = spy(new FooImpl());
        Bar bar = new Bar(foo);
        assertEquals("qwe", bar.bar("qwe"));  // так было
        when(foo.foo("qwe")).thenReturn("asd");         // подмена
        // или так
//        doReturn("asd").when(foo.foo("qwe"));
        //  если не хотим делать лишнего вызова
        // foo.foo("qwe")
        assertEquals("asd", bar.bar("qwe"));  // так стало
    }

    // в чём разница  ???????
    // Мок класса без сценария (return NULL и примитивные значения)
    // Spy - возвращает реальные методы
    // Spy - работает с обьектами
    @Test
    public void mockWithoutScenario() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        assertNull(bar.bar("qwe"));                          //так было
        doReturn("asd").when(foo).foo("qwe");       // сценарий
        assertEquals("asd", bar.bar("qwe"));            // так стало
    }

    //  Что возвращает Мок???????
    //  Для всех Collection пустіе коллекции
    //  Для примитивов их Default значения
    //  Все остальные обьекты NULL
    @Test
    public void byDefaultReturns() {
        List list = mock(List.class);
        assertEquals(0, list.size());
        assertFalse(list.isEmpty());
        assertNull(list.iterator());
        assertEquals("[]", list.subList(1, 2).toString());
    }

    //  Вызов реального метода (последняя команда повторяется)
    @Test
    public void stubThenCall() {
        Foo foo = mock(FooImpl.class);
        Bar bar = new Bar(foo);
        when(foo.foo("qwe")).thenReturn("asd").thenCallRealMethod();
        assertEquals("asd", bar.bar("qwe"));
        assertEquals("qwe", bar.bar("qwe"));
        assertEquals("qwe", bar.bar("qwe"));
        assertEquals("qwe", bar.bar("qwe"));
    }

    //  Вызов реального VOID метода (последняя команда повторяется)
    @Test
    public void voidCallRealMrthod() {
        FooVoid fooVoid = mock(FooVoidImpl.class);
        BarVoid barVoid = new BarVoid(fooVoid);
        doCallRealMethod().when(fooVoid).foo("qwe");
        barVoid.bar("qwe");
        verify(fooVoid).foo("qwe");
    }

    //  Программируем flow (колбаса)
    @Test
    public void someStrongFlow() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo("qwe")).thenReturn("asd").thenReturn("sdf");
        //  или так
        when(foo.foo("qwe")).thenReturn("asd", "sdf");
        assertEquals("asd", bar.bar("qwe"));
        assertEquals("sdf", bar.bar("qwe"));
        assertEquals("sdf", bar.bar("qwe"));
    }

    //  Программируем flow (последовательно)
    @Test
    public void someFlow() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo("qwe")).thenReturn("asd");
        when(foo.foo("wer")).thenReturn("sdf");
        assertEquals("asd", bar.bar("qwe")); // порядок не играет роли
        assertEquals("sdf", bar.bar("wer"));
    }

    // Сценарии сумируются
    //  только если их условия разные
    //  порядок учтен в пределах одного условия
    @Test
    public void cumulativeFlow() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo("qwe1")).thenReturn("asd").thenReturn("sdf");
        when(foo.foo("qwe2")).thenReturn("asd", "sdf");
        assertEquals("asd", bar.bar("qwe2"));
        assertEquals("asd", bar.bar("qwe1"));
        assertEquals("sdf", bar.bar("qwe1"));
        assertEquals("sdf", bar.bar("qwe2"));
    }

    //  2 МОКА  - ДВА МОКА. Порядок вызовов у двох моков
    @Test
    public void twoMocksFlow() {
        Foo foo1 = mock(Foo.class);
        Foo foo2 = mock(Foo.class);
        Bar2 bar2 = new Bar2(foo1, foo2);
        InOrder inOrder = inOrder(foo1, foo2);
        bar2.bar("qwe");
        inOrder.verify(foo1).foo("qwe");
        inOrder.verify(foo2).foo("qwe");
    }

    //  Если стабом не обойтись можно написать свой ответ на вызов метода
    @Test
    public void thenAnswer() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo(anyString())).thenAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                if (arguments[0].equals("qwe")){
                    return "asd";
                } else {
                    return "qwe";
                }       //  у invocation ещё доступны
            }           //  Object mock = invocation.getMock();
        });             //  Object value = invocation.callRealMethod();
        assertEquals("asd", bar.bar("qwe"));
        assertEquals("qwe", bar.bar("asd"));
    }
    //  VOID  Если стабом не обойтись можно написать свой ответ на вызов VOID  метода
    @Test(expected = RuntimeException.class)
    public void thenAnswerOnVoid(){
        FooVoid fooVoid = mock(FooVoid.class);
        BarVoid barVoid = new BarVoid(fooVoid);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                throw new RuntimeException();
            }
        }).when(foo).foo(anyString());
        bar.bar("asd");
    }

    //  Проверка что мок не трогали вообще
    @Test
    public void neverCallMock(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
//        bar.bar("qwe");   // а мок не трогали
        verifyZeroInteractions(foo);
    }

    //  Проверка что после конкретной проверкимок не трогали
    @Test
    public void neverCallMockMethod(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        bar.bar("qwe");
        verify(foo).foo("qwe");
        verifyNoMoreInteractions(foo);
        // аналог по проще
        verify(foo, only()).foo("qwe");
    }

    //  КАПЧИМ ПАРАМЕТРЫ
    //  Есть возможность записать что передавалось
    @Test
    public void captures(){
         Foo foo = mock(Foo.class);
         Bar bar = new Bar(foo);
         bar.bar("qwe");
         bar.bar("asd");
         bar.bar("zxc");
         ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
         verify(foo, times(3)).foo(argument.capture());
         assertEquals("[qwe, asd, zxc]", argument.getAllValues().toString());
    }

    //   Как reset_ить мок
    @Test
    public void resetMock(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        when(foo.foo("qwe")).thenReturn("asd");
        bar.bar("qwe");
        bar.bar("qwe");
        verify(foo, times(2)).foo("qwe");
        reset(foo);
        bar.bar("qwe");
        bar.bar("qwe");
        bar.bar("qwe");
        verify(foo, times(3)).foo("qwe");
    }

    // Behavior-driven development
    @Test
    public void shouldSmthWhenSmth(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        given(foo.foo("asd")).willReturn("qwe");
        //  или для методов VOID
        willReturn("qwe").given(foo).foo("asd");
        String result = bar.bar("asd");
        assertThat(result, isQwe());
    }

    //  Диагностика неисправностей
    @Test
    public void chrchUssage(){
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
        // тут ошибкаю не хватает willReturn
        given(foo.foo("asd")); //.willReturn("qwe");
        String result = bar.bar("asd");
        assertThat(result, isQwe());

        validateMockitoUsage(); // метод диагностики
    }
}

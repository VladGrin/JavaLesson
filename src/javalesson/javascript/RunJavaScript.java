package javalesson.javascript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RunJavaScript {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        engine.put("k", 4);
        String code = "print('hello');" +
                "function f(a){return a + 6;}" +
                "var n = 1 + 2;" +
                "n + 3 + k";

        Object o = engine.eval(code);
        System.out.println(o);
        Object o2 = ((Invocable)engine).invokeFunction("f",1);
        System.out.println(o2);
        Object o3 = ((Invocable)engine).invokeFunction("f","1");
        System.out.println(o3 );
    }
}

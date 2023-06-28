
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest {

  private static int tid = 99;
  private String tstr = "This is confidential! ";
    
    public static void main(String[] args) throws Exception {
      ReflectTest tc = new ReflectTest();
      Class c1 = tc.getClass(); //
      Field[] fields=c1.getDeclaredFields();
      for(Field f:fields)
            System.out.println(f.getName()+"  "+Modifier.toString(f.getModifiers()));
   
    // getting private data
    Field str=c1.getDeclaredField("tstr");
    str.setAccessible(true);
    String whatsintstr=(String)str.get(tc);
    System.out.println("Information hiding in private tstr is:"+whatsintstr);

    }  
}

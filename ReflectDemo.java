
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
   public static void main(String[] args) {
          WildCardDemo d = new WildCardDemo();
          Class c = d.getClass(); // java.lang.Thread
          System.out.println(c.getName());
          
           Method[] strMethods=c.getDeclaredMethods(); // ALL THE METHODS OF STRING
            int mc = 0;
            for(Method m:strMethods) {
            System.out.println(m.getName());
            mc++;
          } 
            System.out.println("No of methods in "+ c.getName()+" class are: "+mc);
            int fc = 0;
            Field[] fields = c.getDeclaredFields();
            for(Field f:fields){
                System.out.println(f.getName());
                fc++;
            }
            System.out.println("No of fields in "+ c.getName()+" class are: "+fc);
}
}

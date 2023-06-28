
public class GenMethodDemo {
    // Generic Method
    public static <E> void printArray(E[] arr){
        for(E ele: arr){
            System.out.print(ele+" ");
        }      
    }
    
    public static void main(String[] args) {
        
        String[] cities = {"Hyd","Nagpur","Pune","Blr","Del"};
        Integer[] nums = {23, 56, 45, 89,67,78};
        printArray(cities); // String
        System.out.println();
        printArray(nums); // Integer
}
}

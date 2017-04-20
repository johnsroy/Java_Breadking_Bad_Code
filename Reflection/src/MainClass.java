public class MainClass {

  public static void main(String[] args){

    ClassLoader classLoader = MainClass.class.getClassLoader();

    try {
        Class aClass = classLoader.loadClass("test.ReflectionTest");
        //In place of test.ReflectionTest you can put in any class name you
        //want. 
        System.out.println("aClass.getName() = " + aClass.getName());
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

}
}
public class OOPS {
    public static  void main(String args[]){
        OOPS oops = new OOPS();
      Dog d = oops.new Dog();
      
      Bikes b= oops.new Bikes();
    
    
        
    }
   class Animal{
    Animal(){
        System.out.println("eat anything");
    }
   
  }
   class Dog extends Animal{
   
   Dog(){
     super();
    System.out.print("dog");
   }
   
  }
   class Bikes extends Dog{
    Bikes(){
         super();
    System.out.print("bikes");
  }
    
  }
    
}

class Car {

    int modelYear;

    public Car(int year) {

        modelYear = year;

    }

    //Our new method to help us get "started"
    public void startEngine() {

        System.out.println("Vroom!");

    }

    public static void main(String[] args){

        Car myFastCar = new Car(2007);
        myFastCar.startEngine();

    }
}
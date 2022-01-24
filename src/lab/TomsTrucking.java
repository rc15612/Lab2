package lab;
import java.util.Scanner;
public class TomsTrucking {

//Input data
private static int numTrucks;
private static int[] maxCapOfEachTruck;
private static double [] loadOfEachTruck;

//PROCESSING
//Algorithm 1 Ask Tom how many trucks for the day
public static void setNumOfTrucksForTheDay() {
       Scanner scan = new Scanner(System.in);
       boolean done = false;
       while(done==false) {
           System.out.println("Please enter the number of trucks you have today:");
           int num = scan.nextInt();
           if(num >= 2) {
               numTrucks = num;
               loadOfEachTruck = new double[numTrucks];
               done = true;
           }else {
               System.out.println("The number must be two or greater than two. Please try again.");
         }
    }
}
       
   
//Algorithm 2: Get Size of each truck
public static void setTheMaxCapacityOfEachTruck() {
    maxCapOfEachTruck = new int[numTrucks];
    Scanner scan = new Scanner(System.in);
    for(int index = 0; index < maxCapOfEachTruck.length; index++) {
        System.out.println("Please enter the size of truck "+(index+1)+". Size is small or large");
        String size = scan.next();
        if(size.equalsIgnoreCase("small")) {
            maxCapOfEachTruck[index]=10;
        }else if(size.equalsIgnoreCase("large")) {
            maxCapOfEachTruck[index]=100;
        }
    }
}
//Algorithm 3: Get Actual load of each truck
public static void setTheLoadOfEachTruck() {
	Scanner scan = new Scanner(System.in);
	for(int index = 0; index < numTrucks; index++) {
		System.out.println("Please enter the actual load of each truck "+(index+1)+".");
		double size = scan.nextDouble();
		loadOfEachTruck[index] = size;
	}
}
//Algorithm 4: Calculate the % of load capacity of each truck
public static double[] calcPercentageOfLoad() {
    double[] percOfLoad = new double[numTrucks];
    for(int index = 0; index < maxCapOfEachTruck.length; index++) {
        percOfLoad[index] = loadOfEachTruck[index]  / (maxCapOfEachTruck[index]* 1.0);
    }
    return percOfLoad;
}

//Algorithm 5: Show information collected from user about truck 
public static String displayTruckInfo(double[] percOfLoad) {
    String out = "";
    for(int index = 0; index < maxCapOfEachTruck.length; index++) {
        out+="Truck "+(index+1)+"- Max capacity: "+maxCapOfEachTruck[index]+", Actual load: "+loadOfEachTruck[index]+", %: "+percOfLoad[index];
        out+="\n";
    }
    return out;
}




//OUTPUT
//main method for calling methods
public static void main(String[] args) {
	TomsTrucking.setNumOfTrucksForTheDay();
	TomsTrucking.setTheMaxCapacityOfEachTruck();
	TomsTrucking.setTheLoadOfEachTruck();
	double[] perol = TomsTrucking.calcPercentageOfLoad();
	System.out.println(TomsTrucking.displayTruckInfo(perol));
	}
}
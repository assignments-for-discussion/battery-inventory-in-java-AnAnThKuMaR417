package bunchbysoh;

public class Main {
  
  //define a class to hold the number of healthy,exchange and failed batteries
  
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };
  
//function to count batteries by health classification
  
  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    //intialize counts object
    CountsBySoH counts = new CountsBySoH();
    //define the rated capacities of batteries
    int ratedCapacity = 120;
    //itearte through each battery's present capacity
    for( int i = 0; i < presentCapacities.length; i++ )
    {
          // Calculate State-of-health percentage
          int sohPercentage = ( 100 * presentCapacities[i] ) / ratedCapacity;
          //classify based on soh percenytage
          if( sohPercentage > 80 && sohPercentage <= 100 )
          {
            counts.healthy = counts.healthy + 1;
          }
          else if( sohPercentage >= 62 && sohPercentage <= 80 )
          {
            counts.exchange = counts.exchange + 1;
          }
          else if( sohPercentage >= 0 && sohPercentage < 62 )
          {
            counts.failed = counts.failed + 1;
          }
          else
          {
            //Handle invalid present capacity input(can be customized)
            System.out.println( "Bad present capacity input" ); 
          }
    }
    //return counts objecs
    return counts;
  }

  static void testBucketingByHealth() {
    //test1
    System.out.println("Counting batteries by SoH...\n");
    //test data with present capacities
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    //count batteries by health classification
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    //assertions to validate the results
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
    //test2
    System.out.println("Counting batteries by SoH...\n");
    //test data with present capacities
    int[] presentCapacitiesTest = {114, 111, 180, 89, -92, 0};
    //count batteries by health classification
    CountsBySoH countsTest = countBatteriesByHealth(presentCapacitiesTest);
    //assertions to validate the results
    assert(countsTest.healthy == 2);
    assert(countsTest.exchange == 1);
    assert(countsTest.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}

package algorithm;

/**
 * Created by swu on 08/02/2017.
 */
public class Sort {
  public static int[] bubbleSort(int[] arr) {
    Boolean swapped = true;
    while(swapped) {
      swapped = false;
      for(int i = 1; i < arr.length; i++) {
        if(arr[i-1] > arr[i]) {
          int tmp = arr[i-1];
          arr[i-1] = arr[i];
          arr[i] = tmp;
          swapped = true;
        }
      }
    }
    return arr;
  }

  public static int[] insertSort(int[] arr) {
    for(int i = 1; i < arr.length; i ++) {
      int j = 0;
      Boolean found = false;
      while(j < i && !found) {
        if (arr[i] < arr[j]) {
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
          found = true;
        }
        j++;
      }
    }
    return arr;
  }

  public static void main(String [] args) {
    int[] arr = new int[] {0, 8, 6, 4, 1, 15, 9};
    arr = insertSort(arr);
    for (int elm : arr) {
      System.out.println(elm);
    }
  }
}

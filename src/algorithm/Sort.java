package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
      while(j < i) {
        if (arr[i] < arr[j]) {
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
        }
        j++;
      }
    }
    return arr;
  }

  private static int[] merge(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int i = 0, j = 0, index = 0;
    while(i < arr1.length || j < arr2.length) {
      if (j == arr2.length) {
        result[index] = arr1[i];
        i++;
      } else if (i == arr1.length) {
        result[index] = arr2[j];
        j++;
      } else if (arr1[i] <= arr2[j]) {
        result[index] = arr1[i];
        i++;
      } else {
        result[index] = arr2[j];
        j++;
      }
      index++;
    }
    return result;
  }

  private static int[] copyArray(int[] arr, int start, int end) {
    int[] newArray = new int[end - start];
    for (int i = 0; i < newArray.length; i ++) {
      newArray[i] = arr[start + i];
    }
    return newArray;
  }

  private static int[] mergeSortR(int[] arr) {
    if (arr.length > 1) {
      int middle = arr.length/2;
      int[] arr1 = mergeSortR(copyArray(arr, 0, middle));
      int[] arr2 = mergeSortR(copyArray(arr, middle, arr.length));
      return merge(arr1, arr2);
    } else {
      return arr;
    }
  }

  public static int[] mergeSort(int[] arr) {
    return mergeSortR(arr);
  }

  private static ArrayList[] partition(List<Integer> arr, int pivot) {
    ArrayList[] result = new ArrayList[2];
    ArrayList<Integer> left = new ArrayList<Integer>(arr.size());
    ArrayList<Integer> right = new ArrayList<Integer>(arr.size());
    result[0] = left;
    result[1] = right;
    for(Integer i : arr) {
      if (i < pivot) {
        left.add(i);
      } else {
        right.add(i);
      }
    }
    return result;
  }

  private static ArrayList<Integer> quickSortR(ArrayList<Integer> arr) {
    if (arr.size() < 2) {
      return arr;
    } else {
      Integer pivot = arr.get(0);
      ArrayList[] result = partition(arr.subList(1, arr.size()), pivot);
      result[0] = quickSortR(result[0]);
      result[1] = quickSortR(result[1]);
      result[0].add(pivot);
      result[0].addAll(result[1]);
      return result[0];
    }
  }

  public static int[] quickSort(int[] arr) {
    ArrayList newList = new ArrayList<Integer>(arr.length);
    for (int i = 0; i < arr.length; i ++) {
      newList.add(new Integer(arr[i]));
    }
    ArrayList<Integer> resultList = quickSortR(newList);
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i ++) {
      result[i] = resultList.get(i).intValue();
    }
    return result;
  }

  private static ArrayList<Integer> toArrayList(int[] arr) {
    ArrayList newList = new ArrayList<Integer>(arr.length);
    for (int i = 0; i < arr.length; i ++) {
      newList.add(new Integer(arr[i]));
    }
    return newList;
  }

  private static int[] toTable(ArrayList<Integer> list) {
    int[] result = new int[list.size()];
    for (int i = 0; i < result.length; i ++) {
      result[i] = list.get(i).intValue();
    }
    return result;
  }

  public static int[] radixSort(int[] arr) {
    ArrayList<Integer> list = toArrayList(arr);
    // End if all digital is 0;
    Boolean notEnd = true;
    int level = 1;
    while(notEnd) {
      notEnd = false;
      // 10 is the supposed max number of digital
      HashMap<Integer, ArrayList> result = new HashMap(10);
      for (int i = 0; i < list.size(); i++) {
        Integer value = list.get(i);
        Integer digital = (value % (int) Math.pow(10, level)) / (int) Math.pow(10, level-1);
        notEnd = notEnd || digital != 0;
        if (result.containsKey(digital)) {
          result.get(digital).add(value);
        } else {
          result.put(digital, new ArrayList<Integer>(100));
          result.get(digital).add(value);
        }
      }
      list = new ArrayList<Integer>(arr.length);
      for(int i = 9; i >= 0; i--) {
        if(result.containsKey(i)) {
          list.addAll(result.get(i));
        }
      }
      level++;
    }
    return toTable(list);
  }

  /**
   * For given index in arr, the parent node's index is the return value
   * @param index
   * @return
   */
  private static int parent_index(int index) {
    if (index == 0) return -1;
    return (index - 1) / 2;
  }

  private static int lest_index(int index) {
    return index * 2 + 1;
  }

  private static int right_index(int index) {
    return index * 2 + 2;
  }

  private static void swap(int[] arr, int index_1, int index_2) {
    int v1 = arr[index_1];
    arr[index_1] = arr[index_2];
    arr[index_2] = v1;
  }

  /**
   * Create a heap till the size = count
   * @param arr
   * @param count
   */
  public static void create_max_heap(int[] arr, int count) {
    for(int i = 0; i < count; i++) {
      int parent_index = parent_index(i);
      // We need to do this for every parent index
      int current = i;
      while (parent_index >= 0) {
        if (arr[current] > arr[parent_index]) {
          swap(arr, current, parent_index);
          current = parent_index;
          parent_index = parent_index(parent_index);
        } else {
          // If not swapped, do not
          parent_index = -1;
        }
      }
    }
  }

  public static void heap_sort(int[] arr, int count) {
    while(count > 0) {
      create_max_heap(arr, count);
      swap(arr, 0, --count);
    }
  }

  public static void main(String [] args) {
    int[] arr = new int[] {8, 0, 3, 2 , 1, 14, 12, 24 , 13, 12};
    //arr = radixSort(arr);
    heap_sort(arr, arr.length);
    for (int elm : arr) {
      System.out.print(elm + " ");
    }
  }
}

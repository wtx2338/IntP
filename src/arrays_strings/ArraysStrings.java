package arrays_strings;

import java.util.HashMap;

/**
 * Created by swu on 17/02/17.
 *
 * https://inspirit.net.in/books/placements/Cracking%20the%20Coding%20Interview.pdf
 *
 * ArraysStrings solution
 */
public class ArraysStrings {
  /**
   * Implement an algorithm to determine if a string has all unique characters.
   * What if you can not use additional data structures?
   *
   * The complexity of this solution depend on the complexity of the put and get of HashMap
   * In the best of the case it's O(1) BUT it's not always the case
   * In JAVA 7, it could be O(n) and JAVA 8 O (log n)
   *
   * Even the best case the complexity is O(n) :(
   *
   * @param str input String
   * @return return true if all the characters in the string are unique
   */
  public static boolean unique_char(String str) {
    boolean result = true;
    char[] charArray = str.toCharArray();
    HashMap<Character, Boolean> map = new HashMap(charArray.length);
    for (char c : charArray) {
      Character character = new Character(c);
      if (map.containsKey(character)) {
        map.put(character, false);
        result = false;
      } else {
        map.put(character, true);
      }
    }
    return result;
  }

  /**
   * Response 1 in the book
   *
   * think about the total possible of character :)
   * O(n) Space usage is O(256)
   * @param str
   * @return
   */
  public static boolean isUniqueChars2(String str) {
     boolean[] char_set = new boolean[256];
     for (int i = 0; i < str.length(); i++) {
       int val = str.charAt(i);
       if (char_set[val]) return false;
       char_set[val] = true;
       }
     return true;
  }

  public static boolean isUniqueChars(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); ++i) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
      }
    return true;
  }

  /**
   * Implement an algorithm to determine if a string has all unique characters.
   * What if you can not use additional data structures?
   * The solution comme from after read java doc of String
   *
   * @param str input String
   * @return return true if all the characters in the string are unique
   */
  public static boolean unique_char_no_new_data_structure(String str) {
    boolean result = true;
    char[] charArray = str.toCharArray();
    for (char c : charArray) {
      result &= str.indexOf(c) == str.lastIndexOf(c);
    }
    return result;
  }

  /**
   * This question is not really valid for JAVA :)
   * @param str
   * @return
   */
  public static char[] reverse(char[] str) {
    char[] str_reversed = new char[str.length];
    // For the NULL object in the end
    str_reversed[str.length-1] = str[str.length - 1];
    // 0 -> str.length - 2
    // 1 -> str.length - 3
    for (int i = 0; i < str.length -1; i ++) {
      str_reversed[i] = str[str.length - 2 - i];
    }
    return str_reversed;
  }

  /**
   * In this case it could be O(nˆ2)
   *
   * With a table of char[255], it give O(n)
   * @param str
   * @return
   */
  public static String remove_duplicate(String str) {
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      // If it's first occurrence
      if (str.indexOf(c) == i) {
        builder.append(c);
      }
    }
    return builder.toString();
  }

  /**
   * return true if str1 and str2 are anagrams
   */

  private static int[] get_occurence_array(String str) {
    int[] occurence_str = new int[256];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int index_of_c = Character.getNumericValue(c);
      occurence_str[index_of_c]++;
    }
    return occurence_str;
  }

  public static boolean isAnagrams(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    if (str1 == null || str2 == null) return false;
    int[] occurence_str1 = get_occurence_array(str1);
    int[] occurence_str2 = get_occurence_array(str2);
    for (int i = 0; i < occurence_str1.length; i ++) {
      if (occurence_str1[i] != occurence_str2[i]) return false;
    }
    return true;
  }

  /**
   * Design an algorithm and write code to remove the duplicate characters in a string
   * without using any additional buffer. NOTE: One or two additional variables are fine.
   * An extra copy of the array is not.
   * FOLLOW UP
   * Write the test cases for this method.
   * @param arg
   */

  public static void main(String[] arg) {
    System.out.println(isAnagrams("abc", "cbz"));
  }
}

package code_jam_2017;

import java.util.*;
import java.io.*;

/**
 * Created by swu on 24/02/17.
 */
public class CountryLeader {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int testcase = 1; testcase <= T; testcase ++) {
      int N = in.nextInt();
      int longest = -1;
      String biggest = null;
      in.nextLine();
      for (int i = 0; i < N; i++) {
        HashSet<Character> charSet = new HashSet(26);
        String name = in.nextLine();
        for (char c : name.toCharArray()) {
          charSet.add(c);
        }
        if (charSet.size() > longest) {
          longest = charSet.size();
          biggest = name;
        }
      }
      System.out.println("Case #" + testcase + ": " + biggest);
    }
  }
}

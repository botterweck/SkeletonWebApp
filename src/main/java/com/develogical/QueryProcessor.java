package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if (query.toLowerCase().contains("what is your name?")) {
      return "Goetz Botterweck";
    }

    Pattern pattern1 = Pattern.compile("Which of the following numbers is the largest:(.*?)\\?");
    Matcher matcher1 = pattern1.matcher(query);

    Pattern pattern2 = Pattern.compile("What is (\\d+) plus (\\d+)\\?");
    Matcher matcher2 = pattern2.matcher(query);

    if (matcher1.find()) {
      String[] numbersStr = matcher1.group(1).trim().split(", ");
      int maxNum = Integer.MIN_VALUE;
      for (String number : numbersStr) {
        int num = Integer.parseInt(number);
        if (num > maxNum) {
          maxNum = num;
        }
      }
      return String.valueOf(maxNum);
    } else if (matcher2.find()) {
      int num1 = Integer.parseInt(matcher2.group(1));
      int num2 = Integer.parseInt(matcher2.group(2));
      int sum = num1 + num2;
      return String.valueOf(sum);
    }

    return ""; // Query not recognized
  }
}

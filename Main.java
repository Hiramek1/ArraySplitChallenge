
/*
Array Challenge
Have the function ArrayChallenge(strArr) read the array of strings stored in strArr, which will contain 2 elements: the first element will be a sequence of characters, and the second element will be a long string of comma-separated words, in alphabetical order, that represents a dictionary of some arbitrary length. For example: strArr can be: ["hellocat", "apple,bat,cat,goodbye,hello,yellow,why"]. Your goal is to determine if the first element in the input can be split into two words, where both words exist in the dictionary that is provided in the second input. In this example, the first element can be split into two words: hello and cat because both of those words are in the dictionary.

Your program should return the two words that exist in the dictionary separated by a comma. So for the example above, your program should return hello,cat. There will only be one correct way to split the first element of characters into two words. If there is no way to split string into two words that exist in the dictionary, return the string not possible. The first element itself will never exist in the dictionary as a real word.
Once your function is working, take the final output string and concatenate it with your ChallengeToken, and then replace every third character with an X.

Your ChallengeToken: jr34qso521
Examples
Input: new String[] {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"}
Output: base,ball
Final Output: baXe,XalXjrX4qXo5X1
Input: new String[] {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"}
Output: abcg,efd
Final Output: abXg,XfdXr3XqsX52X
*/
import java.util.*;
import java.io.*;

class Main {

  public static String ArrayChallenge(String[] strArr) {
    // code goes here
    String challengeToken = "jr34qso521";
    String wordToSplit = strArr[0];
    List<String> dictionaryWords = Arrays.asList(strArr[1].trim().split("\\s*,\\s*"));
    
    for (int i = wordToSplit.length() - 1; i > 0; i--) {
      String firstWord = wordToSplit.substring(0, i);
      String lastWord = wordToSplit.substring(i);
    
      if (dictionaryWords.contains(firstWord) && dictionaryWords.contains(lastWord)) {
        String output = firstWord + "," + lastWord + challengeToken;
        return finalOutput(output);
      }
    }
    return "not possible";
  }
  
  public static String finalOutput(String output) {
    char [] outputToChar = output.toCharArray();
    String newOutput = "";
    //base,balljr34qso521
    for(int i = 0; i < outputToChar.length; i++){
        if(i % 3 == 0 && i != 0) {
          outputToChar[i] = 'X';
        }
      newOutput = newOutput + outputToChar[i];
    }
    return newOutput;
  }

  public static void main(String[] args) {
    // Keep this funcion call here
    Scanner s = new Scanner(System.in);
    // System.out.print(ArrayChallenge(s.nextLine()));
    String strArr[] = { "baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z" };
    System.out.print(ArrayChallenge(strArr));

    s.close();
  }
  
}
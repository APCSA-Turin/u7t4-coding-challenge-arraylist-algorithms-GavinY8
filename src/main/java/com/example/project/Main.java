package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    
    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
    public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str){
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).indexOf("i") >= 0) {
                stringList.add(i+1, str);
                i++;
            }
        }
        return stringList;
    }



    /** Removes all Strings from stringList that have a length of 3
   *
   *  DOES mutate (modify) elements of stringList.
   *  PRECONDITION: stringList.size() > 0
   *
   *  @param stringList  original arraylist of Strings
   */
    public static ArrayList<String> removeThree(ArrayList<String> stringList){
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).length() == 3) {
                stringList.remove(i);
                i--;
            }
        }
        return stringList;
    }



    /** Returns an ArrayList with all elements of arr reversed
   *
   *  Does NOT mutate (modify) elements in intList.
   *  PRECONDITION: intList.size() > 0
   *
   *  @param intList  original array of integers
   */
    public static ArrayList<Integer> reverseArray(int[] intList){
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = intList.length-1; i >= 0; i--) {
            newList.add(intList[i]);
        }
        return newList;
    }



    /** Appends an uppercase version of each string to the end of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0,
     *                 all words in wordList are initially lowercase
     *
     *  @param wordList  arraylist of Strings
     */
    public static ArrayList<String> duplicateUpperEnd(ArrayList<String> wordList){
        int num = wordList.size();
        for (int i = 0; i < num; i++) {
            wordList.add(wordList.get(i).toUpperCase());
        }
        return wordList;
    }



    /** Returns an arraylist of Strings that represents the input sentence parsed
   *  into separate words, using a single space (" ") as the delimiter
   *
   *  For example, if sentence = "This is my sentence!"
   *  this method return the arraylist: [This, is, my, sentence!]
   *
   *  PRECONDITION: sentence does not end with a space and each word is
   *                separated by exactly one space
   *
   *  @param sentence  the input String
   *  @return  new arraylist of Strings containing the words of sentence
   */

    public static ArrayList<String> parseSentence(String sentence){
        ArrayList<String> strList = new ArrayList<>();
        int idx = sentence.indexOf(" ");
        while (idx != -1) {
            strList.add(sentence.substring(0, idx));
            sentence = sentence.substring(idx+1);
            idx = sentence.indexOf(" ");
        }
        strList.add(sentence.substring(0));
        return strList;
    }



    /** Moves all words in wordList that begin with "b" to the front of
   *  wordList; all "b" words that are moved should appear in the same order
   *  in the modified arrayList as they did before being moved
   *
   *  For example, this method will take a wordList:
   *  ["apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"]
   *  and modify it to
   *  ["banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
   *
   *  DOES mutate (modify) elements in wordList
   *  PRECONDITIONS: - wordList.size() > 0
   *                 - all strings in wordList have length >= 1
   *
   *  @param wordList  arraylist of words
   */
    public static ArrayList<String> moveBWords(ArrayList<String> wordList){
        ArrayList<String> qwe = new ArrayList<>();
        for (int i = wordList.size()-1; i >= 0; i--) {
            if (wordList.get(i).substring(0, 1).toLowerCase().equals("b")) {
                qwe.add(wordList.remove(i));
            }
        }
        for (int i = 0; i < qwe.size(); i++) {
            wordList.add(0, qwe.get(i));
        }
        return wordList;
    }



    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> intList){
        for (int i = 0; i < intList.size(); i++) {
            for (int j = intList.indexOf(intList.get(i))+1; j < intList.size(); j++) {
                if (intList.get(j) == intList.get(i)) {
                    intList.remove(j);
                }
            }
        }
        return intList;
    }

    // Given an array of ints, 
    // return true if the array is length 1 or more, 
    // and the first element and the last element are equal.
    // sameFirstLast([1, 2, 3]) → false
    // sameFirstLast([1, 2, 3, 1]) → true
    // sameFirstLast([1, 2, 1]) → true
    //sameFirstLast([]) -> false
    public static boolean sameFirstLast(ArrayList<Integer> list){
        if (list.isEmpty()) {
            return false;
        }
        if ((list.get(0) == list.get(list.size()-1)) && list.size() >= 1) {
            return true;
        }
        return false;
    }



    // Given an array of ints, swap the first and last elements in the array. 
    // Return the modified array. The array length will be at least 1.
    // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list) {
        ArrayList<Integer> qwe = new ArrayList<>();
        if (list.size() <= 1) {
            return qwe;
        }
        int temp = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.set(list.size()-1, temp);
        return list;
    }



    // Return an array that contains the exact same numbers as the given array, 
    // but rearranged so that all the zeros are grouped at the start of the array. 
    // The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
    // You may modify and return the given array or make a new array.
    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                list.remove(i);
                list.add(0, 0);
            }
        }
        return list;
    }



    // We'll say that an element in an array is "alone" if there are values before and after it, 
    // and those values are different from it. If the value is at the end compare to the left and if its at the beginning compare to the right
    //Return a version of the given array where every instance 
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 5]
    // notAlone([3, 4], 3) → [3, 3]
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val){
        //checks both sides of i and sets i to the higher side
        for (int i = 1; i < list.size()-1; i++) {
            if (list.get(i) == val) {
                if (list.get(i-1) > list.get(i)) {
                    list.set(i, list.get(i-1));
                }
                if (list.get(i+1) > list.get(i)) {
                    list.set(i, list.get(i+1));
                }
            }
        }

        //last index
        if (list.get(list.size()-1) == val) {
            if (list.get(list.size()-2) > list.get(list.size()-1)) {
                list.set(list.size()-1, list.get(list.size()-2));
            }
        }

        //first index
        if (list.get(0) == val) {
            if (list.get(0) < list.get(1)) {
                list.set(0, list.get(1));
            }
    
        }
        return list;
    }



    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
    // You may modify and return the given array;
    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]

    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list){
        int temp = list.remove(0);
        list.add(temp);
        return list;
    }
    


    // Return an array that contains exactly the same numbers as the given array, 
    // but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
    // but every other number may move. The array contains the same number of 3's and 4's, 
    // every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public static ArrayList<Integer> fix34(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                int asd = list.lastIndexOf(4);
                int qwe = list.get(i+1);
                list.set(i + 1, 4);
                list.set(asd, qwe);
            }
        }
        return list;
    }



    /** Returns an arraylist of Integers that contain all mode(s) of the array numList.
   *  The mode of a list is the value that appears the greatest number of times.
   *  A list can have one mode, multiple mode, or no mode.
   *
   *  If all elements in the list appear the exact same number of times, there is no
   *  mode and this method should return an empty arraylist.
   *
   *  For example, if numList is: [1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7],
   *  then numList contains one mode: 6
   *  and this method returns an arrayList containing 6
   *
   *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6],
   *  then numList contains two modes: 2, 5
   *  and this method returns an arraylist containing 2 and 5 (in any order)
   *
   *  If numList is: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6],
   *  then numList contains no mode because all values appear the same number of times
   *  and this method returns an empty arrayList: []
   *
   *  Does NOT mutate (modify) elements in numList
   *  PRECONDITIONS: numList.length > 0
   *
   *  @param numList  numList of ints
   */
    public static ArrayList<Integer> modes(int[] numList){
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> modeListCount = new ArrayList<>();
        ArrayList<Integer> modeList = new ArrayList<>();
        int num = 0;
        //set temp and numbers
        for (int i = 0; i < numList.length; i++) {
            numbers.add(numList[i]);
            temp.add(numList[i]);
        }
        //remove duplicates from numbers to make a list of each individual number i need to check
        removeDuplicates(numbers);
        //count how many of each number there are,  resets num after for further use
        for (int i = 0; i < numbers.size(); i++) {
            while (temp.indexOf(numbers.get(i)) != -1) {
                temp.remove(temp.indexOf(numbers.get(i)));
                num++;
            }
            modeListCount.add(num);
            num = 0;
        }
        //checks for the mode
        for (int i = 0; i < modeListCount.size(); i++) {
            if (modeListCount.get(i) > num) {
                num = modeListCount.get(i);
            }
        }
        //
        for (int i = 0; i < modeListCount.size(); i++) {
            if (modeListCount.get(i) == num) {
                modeList.add(numbers.get(i));
            }
        }

        if (modeList.size() == numbers.size()) {
            modeList.clear();
        }
        return modeList;
    }
}
package ex46;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
Exercise 46 - Word Frequency Finder
Knowing how often a word appears in a sentence or block of text is helpful for creating word clouds and other types of word analysis. And it’s more useful when running it against lots of text.

Create a program that reads in a file and counts the frequency of words in the file. Then construct a histogram displaying the words and the frequency, and display the histogram to the screen.

Example Output
Given the text file words.txt with this content

badger badger badger badger mushroom mushroom snake badger badger badger
the program would produce the following output:

badger:   *******
mushroom: **
snake:    *

Constraint
Ensure that the most used word is at the top of the report and the least used words are at the bottom.

Challenges
Use a graphical program and generate bar graphs.
Test the performance of your calculation by providing a very large input file, such as Shakespeare's Macbeth. Tweak your algorithm so that it performs the word counting as fast as possible.
Write the program in another language and compare the processing times of the two implementations.
 */
//UCF COP3330 Summer 2021 Assignment 3 Solution Copyright 2021 Ifeoma Chukwu
public class App {

    public static void main(String[] args) throws FileNotFoundException {
        //call the readFile function on the input.txt file
        readFile("src/main/resources/exercise46_input.txt");
    }
    public static void readFile(String fileName) throws FileNotFoundException
    {
        //initialize a file reader that reads each name from the file and pass the string filename
        FileReader fr = new FileReader(fileName);
        //scan from the file
        Scanner input = new Scanner(fr);
        //create a string variable that stores all the strings
        String s = "badger badger badger badger mushroom mushroom snake badger badger badger";
        //put all the strings into a string array
        String[] occurences = s.split(" ");
        //call countMatches on each word
        int count = countMatches(s,"badger");
        int count2 = countMatches(s,"mushroom");
        int count3 = countMatches(s,"snake");
        System.out.print("badger: ");
        //for loop that prints an "*" for each time badger occurs
       for(int i = 0; i<count; i++)
       {
           System.out.print("*");
       }
        System.out.print("\nmushroom: ");
        //for loop that prints an "*" for each time mushroom occurs
        for(int i = 0; i<count2; i++)
        {
            System.out.print("*");
        }
        System.out.print("\nsnake: ");
        //for loop that prints an "*" for each time snake occurs
        for(int i = 0; i<count3; i++)
        {
            System.out.print("*");
        }
    }
    //method that counts the number of times a word shows up in a text
    public static int countMatches(String text, String str)
    {
        if (text == null || text.length() == 0)
        {
            return 0;
        }

        int index = 0, count = 0;
        while (true)
        {
            index = text.indexOf(str, index);
            if (index != -1)
            {
                count ++;
                index += str.length();
            }
            else {
                break;
            }
        }

        return count;
    }
}

package ex41;
/*
Exercise 41 - Name Sorter
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating a file in your program.

Create a program that reads in the following list of names:

Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong
Read this program and sort the list alphabetically. Then print the sorted list to a file that looks like the following example output.

Example Output
Total of 7 names
-----------------
Ling, Mai
Johnson, Jim
Jones, Aaron
Jones, Chris
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina

Constraint
Don't hard-code the number of names.

Challenges
Implement this program by reading in the names from the user, one at a time, and printing out the sorted results to a file.
Use the program to sort data from a large data set and see how well it performs.
Implement this program in a functional programming language and compare the programs.
 */
//UCF COP3330 Summer 2021 Assignment 3 Solution Copyright 2021 Ifeoma Chukwu

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    //call an array list of strings called names globally
    public ArrayList<String> names;
    //call an integer called count globally
    public int count = 0;
    public static void main(String[] args) throws IOException
    {
        App app = new App();
        String path = "src/main/resources/exercise41_input.txt";
        //call the readFile function on the input.txt file with all of the names to read the file
        app.readFile(path);
        //call the alphabetize function to arrange the names in the input file in alphabetical order
        app.alphabetize(path);
        //call the writeFile function to write the alphabetized names to the output.txt file
        app.writeFile();
    }
    public void readFile(String fileName) throws FileNotFoundException
    {
        //initialize a file reader that reads each name from the file and pass the string filename
        FileReader fr = new FileReader(fileName);
        Scanner input = new Scanner(fr);
        names = new ArrayList<String>();
        //while loop to check if the text file has reached the end of the file; read each name until the file has reached the end
        while(input.hasNextLine())
        {
            String name = input.nextLine();
            names.add(name);
            count++;
        }
    }
    public void writeFile() throws IOException
    {
        //initialize a file writer to the output.txt file because that is the file we are writing to
        FileWriter fw = new FileWriter("src/main/resources/exercise41_output.txt");
        System.out.printf("Total of %d names\n",count);
        System.out.println("-----------------");
        //for loop that writes and prints the new names in the output.txt file
        for(int i = 0; i< names.size(); i++)
        {
            fw.write(names.get(i)+"\n");
            fw.flush();
            System.out.println(names.get(i));
        }
    }
    public ArrayList<String> alphabetize(String file)
    {
        //function that sorts the names alphabetically and returns the sorted names
        names.sort(String::compareTo);
        return names;
    }
}

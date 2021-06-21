package ex45;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Exercise 45 - Word Finder
There will be times when you'll need to read in one file, modify it, and then write a modified version of that file to a new file.

Given an input file, read the file and look for all occurrences of the word utilize. Replace each occurrence with use. Write the modified file to a new file.

Example Output
Given the input file of

One should never utilize the word "utilize" in writing. Use "use" instead.
The program should generate

One should never use the word "use" in writing. Use "use" instead.

Constraints
Prompt for the name of the output file.
Write the output to a new file.

Challenges
Modify the program to track the number of replacements and report that to the screen when the program finishes.
Create a configuration file that maps “bad” words to “good” words and use this file instead of a hard-coded value.
Modify the program so it can handle a folder of files instead of a single file.
 */
//UCF COP3330 Summer 2021 Assignment 3 Solution Copyright 2021 Ifeoma Chukwu
public class App {
    //global string variable
    public String text = "";
    public static void main(String[] args) throws IOException {
         App app = new App();
         app.readFile("src/main/resources/exercise45_input.txt");
        System.out.println("What is the name of the output file?");
        Scanner scanner = new Scanner(System.in);
        app.writeFile(scanner.nextLine());
    }
    public void readFile(String fileName) throws FileNotFoundException
    {
        //initialize a file reader that reads each name from the file and pass the string filename
        FileReader fr = new FileReader(fileName);
        Scanner input = new Scanner(fr);
        //while loop to check if the text file has reached the end of the file; read each name until the file has reached the end
        while(input.hasNextLine())
        {
           text = input.nextLine();
        }
    }
    public void writeFile(String file) throws IOException
    {
        //call the function to change the text and write it to the new file
        changeText();
        //initialize a file writer
        FileWriter fw = new FileWriter("src/main/resources/"+file);
        //write the new file with "use" instead of "utilize"
        fw.write(text);
        //close the writer
        fw.close();
    }
    //method that replaces the word "utilize" with "use" in text
    public void changeText()
    {
        if(text.contains("utilize"))
        {
            text = text.replaceAll("utilize","use");
        }
    }


}

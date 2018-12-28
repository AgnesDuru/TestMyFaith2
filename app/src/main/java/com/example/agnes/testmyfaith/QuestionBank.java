package com.example.agnes.testmyfaith;

// This class contains a list of questions

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.example.agnes.testmyfaith.MyDataBaseHelper.TABLE_BIBLE_TIMES;
import static com.example.agnes.testmyfaith.MyDataBaseHelper.TABLE_CHILDRENS_SONG;
import static com.example.agnes.testmyfaith.MyDataBaseHelper.TABLE_DOCUMENTARY;
import static com.example.agnes.testmyfaith.MyDataBaseHelper.TABLE_MODERN_DAY;
import static com.example.agnes.testmyfaith.MyDataBaseHelper.TABLE_ORIGINAL_SONGS;
import static com.example.agnes.testmyfaith.MyDataBaseHelper.TABLE_SING_OUT_JOYFULLY;


public class QuestionBank {

    //declare list of song questions
    public static volatile List<Question> singOutJoyfullyList = new ArrayList<>();
    public static volatile List<Question> originalSongsList = new ArrayList<>();
    public static volatile List<Question> childrensSongList = new ArrayList<>();


    //declare list of movie questions
    public static volatile List<Question> documentaryMoviesList = new ArrayList<>();
    public static volatile List<Question> modernDayMoviesList = new ArrayList<>();
    public static volatile List<Question> bibleTimesMoviesList = new ArrayList<>();


    com.example.agnes.testmyfaith.MyDataBaseHelper myDataBaseHelper;
    com.example.agnes.testmyfaith.MyDataBaseHelper myDataBaseHelperTwo;


    // method returns number of questions in list

    public int getLength(List<Question> list) {

        return list.size();

    }


    // method returns question from list based on list index

    public String getQuestion(int a, List<Question> list) {

        return list.get(a).getQuestion();

    }


    // method return a single multiple choice item for question based on list index,

    // based on number of multiple choice item in the list - 1, 2, 3 or 4

    // as an argument

    public String getChoice(int index, int num, List<Question> list) {

        return list.get(index).getChoice(num - 1);

    }


    //  method returns correct answer for the question based on list index

    public String getCorrectAnswer(int a, List<Question> list) {

        return list.get(a).getAnswer();

    }


    //Saves the questions onto the songOutJoyfully table
    public void SingOutJoyfullyQuestions(Context context) {

        myDataBaseHelper = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);
//     singOutJoyfullyList = myDataBaseHelper.SingOutJoyfullyGetAllQuestionsList();//get list from database again

        //list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

      //  if (singOutJoyfullyList.isEmpty()) {//if list is empty, populate database with default questions/choices/answers

            myDataBaseHelper.SingOutJoyfullySongAddInitialQuestion(new Question("Finish this phrase from 'This is The Way': No higher way to peace, no finer way to...",

                    new String[]{"Joy", "Love", "Happiness", "Truth"}, "Love"));

            myDataBaseHelper.SingOutJoyfullySongAddInitialQuestion(new Question("'Our faith we must defend. His love is from our assurance' is from...",

                    new String[]{"Give us more faith", "Ever loyal", "Enduring to the end", "We will keep enduring"}, "We will keep enduring"));

            myDataBaseHelper.SingOutJoyfullySongAddInitialQuestion(new Question("Our song book is called",

                    new String[]{"Sing out with joy", "Sing out joyfully", "Sing to Jehovah", "Chant to God"}, "Sing out joyfully"));

            myDataBaseHelper.SingOutJoyfullySongAddInitialQuestion(new Question("Finish this phrase from 'This is The Way': No higher way to peace, no finer way to...",

                    new String[]{"Joy", "Love", "Happiness", "Truth"}, "Love"));

            myDataBaseHelper.SingOutJoyfullySongAddInitialQuestion(new Question("'Our faith we must defend. His love is from our assurance' is from...",

                    new String[]{"Give us more faith", "Ever loyal", "Enduring to the end", "We will keep enduring"}, "We will keep enduring"));

            myDataBaseHelper.SingOutJoyfullySongAddInitialQuestion(new Question("Our song book is called",

                    new String[]{"Sing out with joy", "Sing out joyfully", "Sing to Jehovah", "Chant to God"}, "Sing out joyfully") );

          singOutJoyfullyList = myDataBaseHelper.SingOutJoyfullyGetAllQuestionsList();//get list from database again
        Log.d("songList", "The song list:"+String.valueOf(singOutJoyfullyList));

       //}

    }
/**

    public void OriginalSongsQuestions(Context context) {

        myDataBaseHelper = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);
   originalSongsList = myDataBaseHelper.SingOutJoyfullyGetAllQuestionsList();//get list from database again
    }

    /**
    public void ChildrensSongQuestions(Context context, List<Question> list) {

        myDataBaseHelper = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);
        childrensSongList= myDataBaseHelper.getAllQuestionsList(TABLE_CHILDRENS_SONG);//get list from database again

    }

**/
    //methods that handel the questions for the movies

    public void ModernDayQuestions(Context context) {

        myDataBaseHelperTwo = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);
       // modernDayMoviesList = myDataBaseHelperTwo.ModernDayMovieGetAllQuestionsList();//get list from database again

       // myDataBaseHelperTwo = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);


        if (modernDayMoviesList.isEmpty()) {//if list is empty, populate database with default questions/choices/answers

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was the Coach's name?",

                    new String[]{"Bill", "Clark", "Ethan", "Mason"}, "Clark"));

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was the name of Andre's young male friend?",

                    new String[]{"Oliver", "Lucas", "Roberto", "James"}, "Roberto"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA:: What will I do with my life:  One reason that they wanted to continue to run was for college scholarships and......:",

                    new String[]{"TV commmericals", "nice house and car", "to get girls", "pictures on the cereal box"}, "pictures on the cereal box"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What did Andre's mom cook for him in the first scene when he just finished practice?",

                    new String[]{"Pork", "shrimp and grits", "chicken", "steak and white rice"}, "chicken"));

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What is Andre's dad's name",

                    new String[]{"David", "Will", "John", "Anthony"}, "Will"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What is the name of the older brother that Andre befriends Brother.....?",

                    new String[]{"Nicholas", "Abel", "Fleissig", "Frederick"}, "Fleissig"));

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What accent did Brother Fleissig have? ",

                    new String[]{"Australian", "Russian", "Ukrain", "German"}, "German"));

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What sport did Brother Fleissig play ?",

                    new String[]{"tennis", "swimming", "volleball", "baseball"}, "swimming"));

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What project did Andre help Brother Fleissig with arounf the house? ",

                    new String[]{"painting his room", "Setting up a facebook", "painting his fence", "cleaning his home"}, "painting his fence"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: Brother Fleissig was an.....",

                    new String[]{"elder", "special pioneer", "commuting betholite", "ministerial servant"}, "elder"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was Brother Fleissig's daughter's name?",

                    new String[]{"Emma", "Sophia", "Joy", "Lily"}, "Joy"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was Brother Fleissig's son-in-law's name?",

                    new String[]{"Jordan", "Austin", "Jack", "Ian"}, "Jack"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What injury does the Coach have",

                    new String[]{"foot", "knee", "elbow", "ankle"}, "knee"));

            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What happened to many of Brother Fleissig's former teammates?",

                    new String[]{"They died in a bus crash", "They joined the American Army", "They won the Olympics", "They joined Hitler's army"}, "They joined Hitler's army"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: what was Brother Fleissig content with at the concentration camps?",

                    new String[]{"metal plate and fork", "pictures of his wife", "a watch from his dad", "metal bowl and spoon"}, "metal bowl and spoon"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was Brother Fleissig's wife name?",

                    new String[]{"Rhonda", "Gisella", "Mary", "Bertha"}, "Gisella"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life:What was the name of Andre's track team? ",

                    new String[]{"Red Wildcats", "Blue Wildcats", "Green lions", "Blue Sloths"}, "Blue Wildcats"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: Andre was a........",

                    new String[]{"soccer player", "runner", "swimmer", "basketball player"}, "Sing out joyfully"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: Who told Andre that Brother Fleissig had died: his...?",

                    new String[]{"dad", "grandma", "Joy", "mom"}, "mom"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was the main character's name?",

                    new String[]{"Will", "Andre", "Jaxson", "Evan"}, "Andre"));
            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was the name of the Brother that was interviewing Andre at the end: Brother?",

                    new String[]{"Bryson", "Jaxson", "Taylor", "Wiggan"}, "Taylor"));


            myDataBaseHelperTwo.ModernDayMovieAddInitialQuestion(new Question("From the movie YPA: What will I do with my life: What was Andre's last name: Brother",

                    new String[]{"Benson", "Dempster", "Denson", "Carson"}, "Dempster"));

         modernDayMoviesList = myDataBaseHelperTwo.ModernDayMovieGetAllQuestionsList();//get list from database again

        }
    }


    /**
    public void DocumentaryQuestions(Context context, List<Question> list) {

        myDataBaseHelper = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);
        documentaryMoviesList = myDataBaseHelper.getAllQuestionsList(TABLE_DOCUMENTARY);//get list from database again
    }

    public void BibleTimesQuestions(Context context, List<Question> list) {

        myDataBaseHelper = new com.example.agnes.testmyfaith.MyDataBaseHelper(context);
        bibleTimesMoviesList = myDataBaseHelper.getAllQuestionsList(TABLE_BIBLE_TIMES);//get list from database again

    }
**/



}
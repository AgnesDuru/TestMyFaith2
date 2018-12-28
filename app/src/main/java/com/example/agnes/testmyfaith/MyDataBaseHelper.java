package com.example.agnes.testmyfaith;

import android.content.ContentValues;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;



// class to provide operations with database



import android.content.ContentValues;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;



// class to provide operations with database



public class MyDataBaseHelper extends SQLiteOpenHelper {


    // Database name

    public static String DATABASE_QUESTION = "questionBankJ.db";

    // Current version of database

    private static final int DATABASE_VERSION = 1;

    // Database table name for Songs
    public static final String TABLE_ORIGINAL_SONGS = "QuestionBankA";
    public static final String TABLE_SING_OUT_JOYFULLY = "QuestionBankB";
    public static final String TABLE_CHILDRENS_SONG = "QuestionBankC";

    // Database table name for movies
    public static final String TABLE_DOCUMENTARY = "QuestionBankD";
    public static final String TABLE_MODERN_DAY = "QuestionBankE";
    public static final String TABLE_BIBLE_TIMES = "QuestionBankF";


    // private static final String TABLE_QUESTION = "QuestionBank";
    //private static final String TABLE_QUESTION = "QuestionBank";
    //private static final String TABLE_QUESTION = "QuestionBank";


    //Create different key fields for the different tables
    // All fields used in database table
    //For original songs
    private static final String KEY_ORIGINAL_SONG_ID = "id";

    private static final String ORIGINAL_SONG_QUESTION = "question";

    private static final String ORIGINAL_SONG_CHOICE1 = "choice1";

    private static final String ORIGINAL_SONG_CHOICE2 = "choice2";

    private static final String ORIGINAL_SONG_CHOICE3 = "choice3";

    private static final String ORIGINAL_SONG_CHOICE4 = "choice4";

    private static final String ORIGINAL_SONG_ANSWER = "answer";


    //For sing out joyfully
    private static final String KEY_SING_OUT_JOYFULLY_SONG_KEY_ID = "id";

    private static final String SING_OUT_JOYFULLY_SONG_QUESTION = "question";

    private static final String SING_OUT_JOYFULLY_SONG_CHOICE1 = "choice1";

    private static final String SING_OUT_JOYFULLY_SONG_CHOICE2 = "choice2";

    private static final String SING_OUT_JOYFULLY_SONG_CHOICE3 = "choice3";

    private static final String SING_OUT_JOYFULLY_SONG_CHOICE4 = "choice4";

    private static final String SING_OUT_JOYFULLY_SONG_ANSWER = "answer";


    //For children songs
    private static final String CHILDREN_SONG_KEY_ID = "id";

    private static final String CHILDREN_SONG_QUESTION = "question";

    private static final String CHILDREN_SONG_CHOICE1 = "choice1";

    private static final String CHILDREN_SONG_CHOICE2 = "choice2";

    private static final String CHILDREN_SONG_CHOICE3 = "choice3";

    private static final String CHILDREN_SONG_CHOICE4 = "choice4";

    private static final String CHILDREN_SONG_ANSWER = "answer";


/////For movies

    //modern Day
    private static final String MODERN_DAY_MOVIE_KEY_ID = "id";

    private static final String MODERN_DAY_MOVIE_QUESTION = "question";

    private static final String MODERN_DAY_MOVIE_CHOICE1 = "choice1";

    private static final String MODERN_DAY_MOVIE_CHOICE2 = "choice2";

    private static final String MODERN_DAY_MOVIE_CHOICE3 = "choice3";

    private static final String MODERN_DAY_MOVIE_CHOICE4 = "choice4";

    private static final String MODERN_DAY_MOVIE_ANSWER = "answer";


    //Documentaries
    private static final String DOCUMENTARY_MOVIE_KEY_ID = "id";

    private static final String DOCUMENTARY_MOVIE_QUESTION = "question";

    private static final String DOCUMENTARY_MOVIE_CHOICE1 = "choice1";

    private static final String DOCUMENTARY_MOVIE_CHOICE2 = "choice2";

    private static final String DOCUMENTARY_MOVIE_CHOICE3 = "choice3";

    private static final String DOCUMENTARY_MOVIE_CHOICE4 = "choice4";

    private static final String DOCUMENTARY_MOVIE_ANSWER = "answer";

//Bible Times

    private static final String BIBLE_TIMES_MOVIE_KEY_ID = "id";

    private static final String BIBLE_TIMES_MOVIE_QUESTION = "question";

    private static final String BIBLE_TIMES_MOVIE_CHOICE1 = "choice1";

    private static final String BIBLE_TIMES_MOVIE_CHOICE2 = "choice2";

    private static final String BIBLE_TIMES_MOVIE_CHOICE3 = "choice3";

    private static final String BIBLE_TIMES_MOVIE_CHOICE4 = "choice4";

    private static final String BIBLE_TIMES_MOVIE_ANSWER = "answer";


    // Question Table Create Query in this string for songs category

    private static final String CREATE_ORIGINAL_SONGS_TABLE_QUESTION = "CREATE TABLE "

            + TABLE_ORIGINAL_SONGS + " ( " + KEY_ORIGINAL_SONG_ID

            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ORIGINAL_SONG_QUESTION + " TEXT, "

            + ORIGINAL_SONG_CHOICE1 + " TEXT, " + ORIGINAL_SONG_CHOICE2 + " TEXT, " + ORIGINAL_SONG_CHOICE3 + " TEXT, "

            + ORIGINAL_SONG_CHOICE4 + " TEXT, " + ORIGINAL_SONG_ANSWER + " TEXT" + ")";


    private static final String CREATE_SING_OUT_JOYFULLY_TABLE_QUESTION = "CREATE TABLE "

            + TABLE_SING_OUT_JOYFULLY + " ( " + KEY_SING_OUT_JOYFULLY_SONG_KEY_ID

            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SING_OUT_JOYFULLY_SONG_QUESTION + " TEXT, "

            + SING_OUT_JOYFULLY_SONG_CHOICE1 + " TEXT, " + SING_OUT_JOYFULLY_SONG_CHOICE2 + " TEXT, " + SING_OUT_JOYFULLY_SONG_CHOICE3 + " TEXT, "

            + SING_OUT_JOYFULLY_SONG_CHOICE4 + " TEXT, " + SING_OUT_JOYFULLY_SONG_ANSWER + " TEXT" + ")";



    private static final String CREATE_CHILDREN_TABLE_QUESTION = "CREATE TABLE "

            + TABLE_CHILDRENS_SONG + " ( " + CHILDREN_SONG_KEY_ID

            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CHILDREN_SONG_QUESTION + " TEXT, "

            + CHILDREN_SONG_CHOICE1 + " TEXT, " + CHILDREN_SONG_CHOICE2 + " TEXT, " + CHILDREN_SONG_CHOICE3 + " TEXT, "

            + CHILDREN_SONG_CHOICE4 + " TEXT, " + CHILDREN_SONG_ANSWER +  " TEXT" + ")";


    // Question Table Create Query in this string for movies categories

    private static final String CREATE_TABLE_DOCUMENTARY_QUESTION = "CREATE TABLE "

            + TABLE_MODERN_DAY + " ( " + MODERN_DAY_MOVIE_KEY_ID

            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MODERN_DAY_MOVIE_QUESTION + " TEXT, "

            + MODERN_DAY_MOVIE_CHOICE1 + " TEXT, " + MODERN_DAY_MOVIE_CHOICE2 + " TEXT, " + MODERN_DAY_MOVIE_CHOICE3 + " TEXT, "

            + MODERN_DAY_MOVIE_CHOICE4 + " TEXT, " + MODERN_DAY_MOVIE_ANSWER + " TEXT" + ")";


    private static final String CREATE_TABLE_MODERN_DAY_TABLE_QUESTION = "CREATE TABLE "

            + TABLE_DOCUMENTARY + " ( " + DOCUMENTARY_MOVIE_KEY_ID

            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DOCUMENTARY_MOVIE_QUESTION + " TEXT, "

            + DOCUMENTARY_MOVIE_CHOICE1 + " TEXT, " + DOCUMENTARY_MOVIE_CHOICE2 + " TEXT, " + DOCUMENTARY_MOVIE_CHOICE3 + " TEXT, "

            + DOCUMENTARY_MOVIE_CHOICE4 + " TEXT, " + DOCUMENTARY_MOVIE_ANSWER +  " TEXT" + ")";

    private static final String CREATE_TABLE_BIBLE_TIMES_QUESTION = "CREATE TABLE "

            + TABLE_BIBLE_TIMES + " ( " + BIBLE_TIMES_MOVIE_KEY_ID

            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BIBLE_TIMES_MOVIE_QUESTION + " TEXT, "

            + BIBLE_TIMES_MOVIE_CHOICE1 + " TEXT, " + BIBLE_TIMES_MOVIE_CHOICE2 + " TEXT, " + BIBLE_TIMES_MOVIE_CHOICE3 + " TEXT, "

            + BIBLE_TIMES_MOVIE_CHOICE4 + " TEXT, " + BIBLE_TIMES_MOVIE_ANSWER +  " TEXT" + ")";

    public MyDataBaseHelper(Context context) {

        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);

    }








            /**
             * This method is called by system if the database is accessed but not yet
             * <p>
             * created.
             */

    @Override

    //NEED TO CHANGE IT SO THAT IT HAS CREATE_ NOT THE VALUE OF THE STRING***********************************************
    public void onCreate(SQLiteDatabase db) {
        //For the song category
        db.execSQL(CREATE_ORIGINAL_SONGS_TABLE_QUESTION); // create question table for the original songs
        db.execSQL(CREATE_SING_OUT_JOYFULLY_TABLE_QUESTION); // create question table for the songbook songs
        db.execSQL(CREATE_CHILDREN_TABLE_QUESTION); // create question table for the children songs

        //For the movie category
        db.execSQL(CREATE_TABLE_DOCUMENTARY_QUESTION); // create question table for the documentary movies
        db.execSQL(CREATE_TABLE_MODERN_DAY_TABLE_QUESTION); // create question table for the modern day movies
        db.execSQL(CREATE_TABLE_BIBLE_TIMES_QUESTION); // create question table for the bible times movie
    }


    /**
     * This method is called when any modifications in database are done like
     * <p>
     * version is updated or database schema is changed
     */

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drops the Songs tables
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_ORIGINAL_SONGS)); // drop table if exists
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_SING_OUT_JOYFULLY)); // drop table if exists
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_CHILDRENS_SONG)); // drop table if exists

        //Drops the Movie tables
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_DOCUMENTARY)); // drop table if exists
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_MODERN_DAY)); // drop table if exists
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_BIBLE_TIMES)); // drop table if exists

        onCreate(db);

    }

    //For Sing Out Joyfully
    public long SingOutJoyfullySongAddInitialQuestion(Question question) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values

        ContentValues values = new ContentValues();
        values.put(SING_OUT_JOYFULLY_SONG_QUESTION, question.getQuestion());

        values.put(SING_OUT_JOYFULLY_SONG_CHOICE1, question.getChoice(0));

        values.put(SING_OUT_JOYFULLY_SONG_CHOICE2, question.getChoice(1));

        values.put(SING_OUT_JOYFULLY_SONG_CHOICE3, question.getChoice(2));

        values.put(SING_OUT_JOYFULLY_SONG_CHOICE4, question.getChoice(3));

        values.put(SING_OUT_JOYFULLY_SONG_ANSWER, question.getAnswer());
        long insertS = db.insert(TABLE_SING_OUT_JOYFULLY, null, values);
        //db.close();
        return insertS;

    }









    //For modern Day

    public long ModernDayMovieAddInitialQuestion(Question question) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values

        ContentValues values = new ContentValues();
        values.put(MODERN_DAY_MOVIE_QUESTION, question.getQuestion());

        values.put(MODERN_DAY_MOVIE_CHOICE1, question.getChoice(0));

        values.put(MODERN_DAY_MOVIE_CHOICE2, question.getChoice(1));

        values.put(MODERN_DAY_MOVIE_CHOICE3, question.getChoice(2));

        values.put(MODERN_DAY_MOVIE_CHOICE4, question.getChoice(3));

        values.put(MODERN_DAY_MOVIE_ANSWER, question.getAnswer());

        long insert = db.insert(TABLE_MODERN_DAY, null, values);
       // db.close();
        return insert;

    }




    public List<Question> SingOutJoyfullyGetAllQuestionsList() {
        List<Question> theArrayList = new ArrayList<>();



        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_SING_OUT_JOYFULLY;

        Cursor c = db.rawQuery(selectQuery, null);


        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                Question singOutJoyfullySongQuestion = new Question();

                String questText = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_QUESTION));

                singOutJoyfullySongQuestion.setQuestion(questText);


                String choice1Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE1));

                singOutJoyfullySongQuestion.setChoice(0, choice1Text);


                String choice2Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE2));

                singOutJoyfullySongQuestion.setChoice(1, choice2Text);


                String choice3Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE3));

                singOutJoyfullySongQuestion.setChoice(2, choice3Text);


                String choice4Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE4));

                singOutJoyfullySongQuestion.setChoice(3, choice4Text);


                String answerText = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_ANSWER));

                singOutJoyfullySongQuestion.setAnswer(answerText);
                theArrayList.add(singOutJoyfullySongQuestion);
                // adding to Questions list

               // theArrayList.add(singOutJoyfullySongQuestion);
            } while (c.moveToNext());

            Collections.shuffle(theArrayList);
            //theArrayList.clear();
        }
        return theArrayList;
    }


    public List<Question> ModernDayMovieGetAllQuestionsList() {
        List<Question> theArrayListM = new ArrayList<>();



        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuerys = "SELECT  * FROM " + TABLE_MODERN_DAY;

        Cursor c = db.rawQuery(selectQuerys, null);


        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                Question question = new Question();

                String questText = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_QUESTION));

                question.setQuestion(questText);


                String choice1Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE1));

                question.setChoice(0, choice1Text);


                String choice2Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE2));

                question.setChoice(1, choice2Text);


                String choice3Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE3));

                question.setChoice(2, choice3Text);


                String choice4Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE4));

                question.setChoice(3, choice4Text);


                String answerText = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_ANSWER));

                question.setAnswer(answerText);
                theArrayListM.add(question);
                // adding to Questions list

                theArrayListM.add(question);
            } while (c.moveToNext());

            Collections.shuffle(theArrayListM);
            //theArrayList.clear();
        }
        return theArrayListM;
    }
    }
      //  public List<Question> getAllQuestionsList(String THE_TABLE_NAME) {


    /**

    ///
     //This method is used to add question detail in question Table
     //
    //Not adding it to a specifuc table
    public long addInitialQuestion(Question question, String THE_TABLE_NAME) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values

        ContentValues values = new ContentValues();
        if (THE_TABLE_NAME.equals("TABLE_ORIGINAL_SONGS")) {
            values.put(ORIGINAL_SONG_QUESTION, question.getQuestion());

            values.put(ORIGINAL_SONG_CHOICE1, question.getChoice(0));

            values.put(ORIGINAL_SONG_CHOICE2, question.getChoice(1));

            values.put(ORIGINAL_SONG_CHOICE3, question.getChoice(2));

            values.put(ORIGINAL_SONG_CHOICE4, question.getChoice(3));

            values.put(ORIGINAL_SONG_ANSWER, question.getAnswer());

        } else if (THE_TABLE_NAME.equals("TABLE_SING_OUT_JOYFULLY")) {
            values.put(SING_OUT_JOYFULLY_SONG_QUESTION, question.getQuestion());

            values.put(SING_OUT_JOYFULLY_SONG_CHOICE1, question.getChoice(0));

            values.put(SING_OUT_JOYFULLY_SONG_CHOICE2, question.getChoice(1));

            values.put(SING_OUT_JOYFULLY_SONG_CHOICE3, question.getChoice(2));

            values.put(SING_OUT_JOYFULLY_SONG_CHOICE4, question.getChoice(3));

            values.put(SING_OUT_JOYFULLY_SONG_ANSWER, question.getAnswer());

        } else if (THE_TABLE_NAME.equals("TABLE_CHILDRENS_SONG")) {
            values.put(CHILDREN_SONG_QUESTION, question.getQuestion());

            values.put(CHILDREN_SONG_CHOICE1, question.getChoice(0));

            values.put(CHILDREN_SONG_CHOICE2, question.getChoice(1));

            values.put(CHILDREN_SONG_CHOICE3, question.getChoice(2));

            values.put(CHILDREN_SONG_CHOICE4, question.getChoice(3));

            values.put(CHILDREN_SONG_ANSWER, question.getAnswer());

        }


//The movies table
        else if (THE_TABLE_NAME.equals("TABLE_MODERN_DAY")) {
            values.put(MODERN_DAY_MOVIE_QUESTION, question.getQuestion());

            values.put(MODERN_DAY_MOVIE_CHOICE1, question.getChoice(0));

            values.put(MODERN_DAY_MOVIE_CHOICE2, question.getChoice(1));

            values.put(MODERN_DAY_MOVIE_CHOICE3, question.getChoice(2));

            values.put(MODERN_DAY_MOVIE_CHOICE4, question.getChoice(3));

            values.put(MODERN_DAY_MOVIE_ANSWER, question.getAnswer());

        } else if (THE_TABLE_NAME.equals("TABLE_DOCUMENTARY")) {
            values.put(DOCUMENTARY_MOVIE_QUESTION, question.getQuestion());

            values.put(DOCUMENTARY_MOVIE_CHOICE1, question.getChoice(0));

            values.put(DOCUMENTARY_MOVIE_CHOICE2, question.getChoice(1));

            values.put(DOCUMENTARY_MOVIE_CHOICE3, question.getChoice(2));

            values.put(DOCUMENTARY_MOVIE_CHOICE4, question.getChoice(3));

            values.put(DOCUMENTARY_MOVIE_ANSWER, question.getAnswer());

        } else if (THE_TABLE_NAME.equals("TABLE_BIBLE_TIMES")) {

            values.put(BIBLE_TIMES_MOVIE_QUESTION, question.getQuestion());

            values.put(BIBLE_TIMES_MOVIE_CHOICE1, question.getChoice(0));

            values.put(BIBLE_TIMES_MOVIE_CHOICE2, question.getChoice(1));

            values.put(BIBLE_TIMES_MOVIE_CHOICE3, question.getChoice(2));

            values.put(BIBLE_TIMES_MOVIE_CHOICE4, question.getChoice(3));

            values.put(BIBLE_TIMES_MOVIE_ANSWER, question.getAnswer());

        }
        // insert row in question table

        long insert = db.insert(THE_TABLE_NAME, null, values);
db.close();
        return insert;

    }



   /**

    ///
     // To extract data from database and save it Arraylist of data type
     //<p>
     // Question
     //

    ///
    public List<Question> getAllQuestionsList(String THE_TABLE_NAME) {

        List<Question> originalSongArrayList = new ArrayList<>();
        List<Question> singOutJoyfullySongArrayList = new ArrayList<>();
        List<Question> childrenSongArrayList = new ArrayList<>();

        //Movies
        List<Question> modernDayMovieArrayList = new ArrayList<>();
        List<Question> documentaryMovieArrayList = new ArrayList<>();
        List<Question> bibleTimesArrayList = new ArrayList<>();

        List<Question> theArrayList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + THE_TABLE_NAME;


        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);


        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            theArrayList.clear();
            if (THE_TABLE_NAME.equals(TABLE_ORIGINAL_SONGS)) {

                do {
                    Question originalSongQuestion = new Question();
                    String questText = c.getString(c.getColumnIndex(ORIGINAL_SONG_QUESTION));

                    originalSongQuestion.setQuestion(questText);


                    String choice1Text = c.getString(c.getColumnIndex(ORIGINAL_SONG_CHOICE1));

                    originalSongQuestion.setChoice(0, choice1Text);


                    String choice2Text = c.getString(c.getColumnIndex(ORIGINAL_SONG_CHOICE2));

                    originalSongQuestion.setChoice(1, choice2Text);


                    String choice3Text = c.getString(c.getColumnIndex(ORIGINAL_SONG_CHOICE3));

                    originalSongQuestion.setChoice(2, choice3Text);


                    String choice4Text = c.getString(c.getColumnIndex(ORIGINAL_SONG_CHOICE4));

                    originalSongQuestion.setChoice(3, choice4Text);


                    String answerText = c.getString(c.getColumnIndex(ORIGINAL_SONG_ANSWER));

                    originalSongQuestion.setAnswer(answerText);
                    originalSongArrayList.add(originalSongQuestion);
                    // adding to Questions list

                  //  originalSongArrayList.add(originalSongQuestion);
                }


                while (c.moveToNext());
                Collections.shuffle(originalSongArrayList);
                // theArrayList.clear();
                theArrayList.addAll(originalSongArrayList);

            } else if (THE_TABLE_NAME.equals(TABLE_SING_OUT_JOYFULLY)) {
                do {
                    Question singOutJoyfullySongQuestion = new Question();

                    String questText = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_QUESTION));

                    singOutJoyfullySongQuestion.setQuestion(questText);


                    String choice1Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE1));

                    singOutJoyfullySongQuestion.setChoice(0, choice1Text);


                    String choice2Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE2));

                    singOutJoyfullySongQuestion.setChoice(1, choice2Text);


                    String choice3Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE3));

                    singOutJoyfullySongQuestion.setChoice(2, choice3Text);


                    String choice4Text = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_CHOICE4));

                    singOutJoyfullySongQuestion.setChoice(3, choice4Text);


                    String answerText = c.getString(c.getColumnIndex(SING_OUT_JOYFULLY_SONG_ANSWER));

                    singOutJoyfullySongQuestion.setAnswer(answerText);
                    singOutJoyfullySongArrayList.add(singOutJoyfullySongQuestion);
                    // adding to Questions list

                    singOutJoyfullySongArrayList.add(singOutJoyfullySongQuestion);
                }

                while (c.moveToNext());

                Collections.shuffle(singOutJoyfullySongArrayList);
                //theArrayList.clear();
                theArrayList.addAll(singOutJoyfullySongArrayList);

            } else if (THE_TABLE_NAME.equals(TABLE_CHILDRENS_SONG)) {
                do {

                    Question childrenSongQuestion = new Question();

                    String questText = c.getString(c.getColumnIndex(CHILDREN_SONG_QUESTION));

                    childrenSongQuestion.setQuestion(questText);


                    String choice1Text = c.getString(c.getColumnIndex(CHILDREN_SONG_CHOICE1));

                    childrenSongQuestion.setChoice(0, choice1Text);


                    String choice2Text = c.getString(c.getColumnIndex(CHILDREN_SONG_CHOICE2));

                    childrenSongQuestion.setChoice(1, choice2Text);


                    String choice3Text = c.getString(c.getColumnIndex(CHILDREN_SONG_CHOICE3));

                    childrenSongQuestion.setChoice(2, choice3Text);


                    String choice4Text = c.getString(c.getColumnIndex(CHILDREN_SONG_CHOICE4));

                    childrenSongQuestion.setChoice(3, choice4Text);


                    String answerText = c.getString(c.getColumnIndex(CHILDREN_SONG_ANSWER));

                    childrenSongQuestion.setAnswer(answerText);
                    childrenSongArrayList.add(childrenSongQuestion);
// adding to Questions list

                    childrenSongArrayList.add(childrenSongQuestion);
                }

                while (c.moveToNext());

                Collections.shuffle(childrenSongArrayList);
                // theArrayList.clear();

                theArrayList.addAll(childrenSongArrayList);


                //For the movies
            } else if (THE_TABLE_NAME.equals(TABLE_DOCUMENTARY)) {
                do {
                    Question docMovieQuestion = new Question();

                    String questText = c.getString(c.getColumnIndex(DOCUMENTARY_MOVIE_QUESTION));

                    docMovieQuestion.setQuestion(questText);


                    String choice1Text = c.getString(c.getColumnIndex(DOCUMENTARY_MOVIE_CHOICE1));

                    docMovieQuestion.setChoice(0, choice1Text);


                    String choice2Text = c.getString(c.getColumnIndex(DOCUMENTARY_MOVIE_CHOICE2));

                    docMovieQuestion.setChoice(1, choice2Text);


                    String choice3Text = c.getString(c.getColumnIndex(DOCUMENTARY_MOVIE_CHOICE3));

                    docMovieQuestion.setChoice(2, choice3Text);


                    String choice4Text = c.getString(c.getColumnIndex(DOCUMENTARY_MOVIE_CHOICE4));

                    docMovieQuestion.setChoice(3, choice4Text);


                    String answerText = c.getString(c.getColumnIndex(DOCUMENTARY_MOVIE_ANSWER));

                    docMovieQuestion.setAnswer(answerText);
                    documentaryMovieArrayList.add(docMovieQuestion);
                    // adding to Questions list

                    documentaryMovieArrayList.add(docMovieQuestion);
                }
                while (c.moveToNext());

                Collections.shuffle(documentaryMovieArrayList);
                // theArrayList.clear();
                theArrayList.addAll(documentaryMovieArrayList);


            } else if (THE_TABLE_NAME.equals(TABLE_MODERN_DAY)) {
                do {

                    Question modernDayMovieQuestion = new Question();

                    String questText = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_QUESTION));

                    modernDayMovieQuestion.setQuestion(questText);


                    String choice1Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE1));

                    modernDayMovieQuestion.setChoice(0, choice1Text);


                    String choice2Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE2));

                    modernDayMovieQuestion.setChoice(1, choice2Text);


                    String choice3Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE3));

                    modernDayMovieQuestion.setChoice(2, choice3Text);


                    String choice4Text = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_CHOICE4));

                    modernDayMovieQuestion.setChoice(3, choice4Text);


                    String answerText = c.getString(c.getColumnIndex(MODERN_DAY_MOVIE_ANSWER));
                    modernDayMovieQuestion.setAnswer(answerText);
                    modernDayMovieArrayList.add(modernDayMovieQuestion);
                    // adding to Questions list

                    modernDayMovieArrayList.add(modernDayMovieQuestion);
                }
                while (c.moveToNext());

                Collections.shuffle(modernDayMovieArrayList);
                //theArrayList.clear();
                theArrayList.addAll(modernDayMovieArrayList);

            } else if (THE_TABLE_NAME.equals(TABLE_BIBLE_TIMES)) {
                Question bibleTimesMovieQuestion = new Question();

                String questText = c.getString(c.getColumnIndex(BIBLE_TIMES_MOVIE_QUESTION));

                bibleTimesMovieQuestion.setQuestion(questText);


                String choice1Text = c.getString(c.getColumnIndex(BIBLE_TIMES_MOVIE_CHOICE1));

                bibleTimesMovieQuestion.setChoice(0, choice1Text);


                String choice2Text = c.getString(c.getColumnIndex(BIBLE_TIMES_MOVIE_CHOICE2));

                bibleTimesMovieQuestion.setChoice(1, choice2Text);


                String choice3Text = c.getString(c.getColumnIndex(BIBLE_TIMES_MOVIE_CHOICE3));

                bibleTimesMovieQuestion.setChoice(2, choice3Text);


                String choice4Text = c.getString(c.getColumnIndex(BIBLE_TIMES_MOVIE_CHOICE4));

                bibleTimesMovieQuestion.setChoice(3, choice4Text);


                String answerText = c.getString(c.getColumnIndex(BIBLE_TIMES_MOVIE_ANSWER));

                bibleTimesMovieQuestion.setAnswer(answerText);
                bibleTimesArrayList.add(bibleTimesMovieQuestion);
                // adding to Questions list

                bibleTimesArrayList.add(bibleTimesMovieQuestion);
            }

            while (c.moveToNext()) ;

            Collections.shuffle(bibleTimesArrayList);

            //  theArrayList.clear();
            theArrayList.addAll(bibleTimesArrayList);
        }
            return theArrayList;
    }
**/
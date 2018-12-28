package com.example.agnes.testmyfaith;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.view.Window;
import android.widget.Button;

import android.widget.RelativeLayout;
import android.widget.TextView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import android.widget.Toast;

import javax.xml.transform.Result;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.agnes.testmyfaith.MoviesSubTopics.EXTRA_MESSAGE_TWO;
import static com.example.agnes.testmyfaith.QuestionBank.bibleTimesMoviesList;
import static com.example.agnes.testmyfaith.QuestionBank.childrensSongList;
import static com.example.agnes.testmyfaith.QuestionBank.childrensSongList;
import static com.example.agnes.testmyfaith.QuestionBank.documentaryMoviesList;
import static com.example.agnes.testmyfaith.QuestionBank.modernDayMoviesList;
import static com.example.agnes.testmyfaith.QuestionBank.originalSongsList;
import static com.example.agnes.testmyfaith.QuestionBank.singOutJoyfullyList;


public class QuizActivity extends AppCompatActivity {


    private QuestionBank mQuestionLibrary = new QuestionBank();
    private QuestionBank QuestionLibrary = new QuestionBank();
    private Runnable mColorRunnable;
    public TextView numberOfQuestions;
    public  TextView score;

    //Check if it is actually getting reference to the quiz layout
    RelativeLayout theQuizLayout;
    ;
    //Handles delayed time to see that the button color changed to red or green(right or wrong)
    private Handler mHandler = new Handler();


    private TextView mScoreView;   // view for current total score

    private TextView mQuestionView;  //current question to answer

    private Button mButtonChoice1; // multiple choice 1 for mQuestionView

    private Button mButtonChoice2; // multiple choice 2 for mQuestionView

    private Button mButtonChoice3; // multiple choice 3 for mQuestionView

    private Button mButtonChoice4; // multiple choice 4 for mQuestionView


    private String mAnswer;  // correct answer for question in mQuestionView

    private int mScore = 0;  // current total score

    private int mQuestionNumber = 0; // current question number

    int songChosen; //The int returned from the song activity to shcw whether the user selected

    int movieChosen;
    ArrayList buttonList;
    boolean isSingOutJoyfullySong;
    boolean isModernMovie;
    String totalQuestions;
    int allQuestions;
    int currentQuestion;
    public static String myScore;
    int currentScore;
    int finishedQuestions;
   public static  int numCorrect;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //get the intent
        Intent intent = getIntent();


        //Intent movieIntent = getIntent();
        //get the name from the intent
        songChosen = intent.getIntExtra(EXTRA_MESSAGE, 0);
        movieChosen = intent.getIntExtra(EXTRA_MESSAGE_TWO, 0);

        setContentView(R.layout.activity_quiz);
        // setup screen for the first question with four alternative to answer

        // mScoreView = (TextView) findViewById(R.id.score);
        //Sets the question number to one
        mQuestionNumber = 1;
        isSingOutJoyfullySong = false;
        isModernMovie = false;
        mQuestionView = (TextView) findViewById(R.id.question);

        mButtonChoice1 = (Button) findViewById(R.id.choice1);

        mButtonChoice2 = (Button) findViewById(R.id.choice2);

        mButtonChoice3 = (Button) findViewById(R.id.choice3);

        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        numberOfQuestions = (TextView) findViewById(R.id.theAmountOfQuestions);
        //The total amount of questions
        allQuestions = 10;
        totalQuestions = "" + currentQuestion + "/" + allQuestions;
        numberOfQuestions.setText(totalQuestions);
        score = (TextView)findViewById(R.id.theScore);
        //The amount of questions that the person got right
        numCorrect = 0;

//The current question
        currentQuestion = 0;
        currentScore = 0;
        //The questions to compare as to wherther you have finished the game
        finishedQuestions = 0;
        //Reference to the song question library
        mQuestionLibrary.SingOutJoyfullyQuestions(getApplicationContext());
        //QuestionLibrary.OriginalSongsQuestions(getApplicationContext());
        //  mQuestionLibrary.ChildrensSongQuestions(getApplicationContext(), childrensSongList);

        //Reference to the movie question library
        mQuestionLibrary.ModernDayQuestions(getApplicationContext());
        //mQuestionLibrary.DocumentaryQuestions(getApplicationContext());
        // mQuestionLibrary.BibleTimesQuestions(getApplicationContext(), bibleTimesMoviesList);

        //References the content quiz layout
        theQuizLayout = (RelativeLayout) findViewById(R.id.content_quizz);
        //if statement to check what sub category of song that was chosen and respectivly updates question with its list........
        //Updates the background of the quiz Activity
        if (songChosen == 1) { //The first category of the Song sub category
            theQuizLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.purple_gradient));
            currentQuestion = 0;
            updateQuestion(originalSongsList);
            //  songChosen = 0;


        } else if (songChosen == 2) {//The seccond category of the Song sub category
            theQuizLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.purple_gradient));
            updateQuestion(singOutJoyfullyList);  // Sing out joyfully list contains both movie and song questions .Might be bc the table is equal to questionBank databse
            // songChosen = 0;
            currentQuestion = 0;



        } else if (songChosen == 3) {//The third category of the Song sub category
            theQuizLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.purple_gradient));
            updateQuestion(childrensSongList);
            //  songChosen = 0;
            currentQuestion = 0;

        }


        //if statement to check what sub category of movie that was chosen and respectivly updates question with its list........
        //Updates the background of the quiz Activity
        if (movieChosen == 1) {//The first category of the Movie sub category
            theQuizLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.light_blue_gradient));
            updateQuestion(modernDayMoviesList);//Updates question from the doc movie list
            isModernMovie = true;
            Log.d("movieChosen", String.valueOf(movieChosen));
            currentQuestion = 0;

            //  movieChosen = 0;
        } else if (movieChosen == 2) {//The seccond category of the Movie sub category
            theQuizLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.light_blue_gradient));
            updateQuestion(documentaryMoviesList);
            // movieChosen = 0;
            currentQuestion = 0;


        } else if (movieChosen == 3) {//The third category of the Movie sub category
            theQuizLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.light_blue_gradient));
            updateQuestion(bibleTimesMoviesList);
            //  movieChosen = 0;
            currentQuestion = 0;

        }
        // show current total score for the user

        // updateScore(mScore);

//The correct answer

    }


    private void updateQuestion(List<Question> questionList) {
        // check if we are not outside array bounds for questions
        if (mQuestionNumber < mQuestionLibrary.getLength(questionList)) {
            /// set the text for new question,

            // and new 4 alternative to answer on four buttons

            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber, questionList));

            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1, questionList));

            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2, questionList));

            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3, questionList));

            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4, questionList));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber, questionList);
            Log.d("The question", "The question is" + mAnswer);
            mQuestionNumber++;
        }
        //else {

        //  Toast.makeText(QuizActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
        ///NEED TO MAKE ANOTHER ACTIVITY -RESULTS ACTIVTY

//            Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);

//            intent.putExtra("score", mScore); // pass the current score to the second screen

//            startActivity(intent);

    }

    //    }

    /**
     * // show current total score for the user
     * <p>
     * private void updateScore(int point) {
     * <p>
     * //Handles the song category
     * if (songChosen == 1) {
     * mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength(originalSongsList));
     * } else {
     * if (songChosen == 2) {
     * mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength(singOutJoyfullyList));
     * <p>
     * } else {
     * if (songChosen == 3) {
     * mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength(childrensSongList));
     * }
     * }
     * }
     * <p>
     * //Handles the movie category
     * if (movieChosen == 1) {
     * mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength(documentaryMoviesList));
     * } else {
     * if (movieChosen == 2) {
     * mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength(modernDayMoviesList));
     * <p>
     * } else {
     * if (movieChosen == 3) {
     * mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength(bibleTimesMoviesList));
     * }
     * }
     * }
     * <p>
     * <p>
     * }
     **/



/**
    public static void delay(int secs, View view ){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, secs * 1000); // afterDelay will be executed after (secs*1000) milliseconds.
    }
}


 **/
public void setButtonToDefaultColor() {
 mButtonChoice1.setBackgroundResource(R.drawable.rounded_bttn);

    mButtonChoice2.setBackgroundResource(R.drawable.rounded_bttn);

    mButtonChoice3.setBackgroundResource(R.drawable.rounded_bttn);

    mButtonChoice4.setBackgroundResource(R.drawable.rounded_bttn);



}

public void setButtonsClickable(boolean canClick){
    mButtonChoice1.setClickable(canClick);
    mButtonChoice2.setClickable(canClick);
    mButtonChoice3.setClickable(canClick);
    mButtonChoice4.setClickable(canClick);

}


    public void onClick(final View view) {

        //Keeps count of the amount of times the person had clicked
        Button answer = (Button) view;
        //THE ANSWER IS RETURNING NULL
        Log.d("answer", "The answer" + mAnswer);
        //If it equals the correct answer change it to green


            if (answer.getText().equals(mAnswer)) {
                //Change the color to the button to red else change it to green
                answer.setBackgroundResource(R.drawable.correct_answer_button);
                currentScore = currentScore + 20;
                numCorrect++;
                myScore = "Score: " + currentScore;
                score.setText(myScore);
            } else {
                answer.setBackgroundResource(R.drawable.wrong_answer_button);
            }
            setButtonsClickable(false);
            //After update question set to true
            theCorrectAnswer();


            //Logic to extend time to update the question
            // mColorRunnable = new Runnable() {
            //  @Override
            //  public void run() {

            //if statement to check what sub category of song was chosen and respectively updates question with its list........


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (songChosen == 1) {
                        //Handles color delay
                        //   colorStay(view);
                        Log.d("in if", "in the if statement");
                        //Changes the button back to the original color

                        updateQuestion(originalSongsList);
                        setButtonsClickable(true);
                        setButtonToDefaultColor();
                        currentQuestion++;
                        totalQuestions = "" + currentQuestion + "/" + allQuestions;
                        numberOfQuestions.setText(totalQuestions);

                    } else if (songChosen == 2) {
                        //  mHandler.postDelayed(mColorRunnable,5000);
                        updateQuestion(singOutJoyfullyList);
                        setButtonToDefaultColor();

                        setButtonsClickable(true);
                        Log.d("in if", "in the if statement");
                        currentQuestion++;
                        totalQuestions = "" + currentQuestion + "/" + allQuestions;
                        numberOfQuestions.setText(totalQuestions);


                    } else if (songChosen == 3) {
                        updateQuestion(childrensSongList);
                        setButtonToDefaultColor();

                        setButtonsClickable(true);
                        currentQuestion++;
                        totalQuestions = "" + currentQuestion + "/" + allQuestions;
                        numberOfQuestions.setText(totalQuestions);

                    }
                    // }

                    //Handles the movie categories
                    if (movieChosen == 1) {
                        updateQuestion(modernDayMoviesList);
                        setButtonToDefaultColor();

                        setButtonsClickable(true);
                        currentQuestion++;
                        totalQuestions = "" + currentQuestion + "/" + allQuestions;
                        numberOfQuestions.setText(totalQuestions);


                    } else if (movieChosen == 2) {
                        updateQuestion(documentaryMoviesList);
                        setButtonsClickable(true);
                        currentQuestion++;
                        totalQuestions = "" + currentQuestion + "/" + allQuestions;
                        numberOfQuestions.setText(totalQuestions);

//
                    } else {
                        if (movieChosen == 3) {
                            updateQuestion(bibleTimesMoviesList);
                            setButtonToDefaultColor();

                            setButtonsClickable(true);
                            currentQuestion++;
                            totalQuestions = "" + currentQuestion + "/" + allQuestions;
                            numberOfQuestions.setText(totalQuestions);

                        }
                    }

                }

            }, 1000);
            //Updates the amount of questions played
            finishedQuestions++;
            if (finishedQuestions == 10) {

                //New activity  finished the game
                Intent intent = new Intent(this, com.example.agnes.testmyfaith.TheResult.class);
                startActivity(intent);
            }
        }




            // };
            // }


            public void theCorrectAnswer() {

                //looks for the button that is equal to the correct answer and changes it to green
                if (mButtonChoice1.getText().equals(mAnswer)) {
                    mButtonChoice1.setBackgroundResource(R.drawable.correct_answer_button);
                } else if (mButtonChoice2.getText().equals(mAnswer)) {
                    mButtonChoice2.setBackgroundResource(R.drawable.correct_answer_button);
                } else if (mButtonChoice3.getText().equals(mAnswer)) {
                    mButtonChoice3.setBackgroundResource(R.drawable.correct_answer_button);
                } else if (mButtonChoice4.getText().equals(mAnswer)) {
                    mButtonChoice4.setBackgroundResource(R.drawable.correct_answer_button);

                }
            }


}





//updateScore(mScore);


            // if the answer is correct, increase the score

            //   if (answer.getText().equals(mAnswer)) {
            // Sets the background color of the button to green if the answer is right
//answer.setBackgroundColor(Color.GREEN);
            //        }
            //    else{


            //Delays it for about 8 secconds
            //   public void startRepeating(View v){
//
//
//
//
// }
            // answer.setBackgroundColor(Color.RED);
            //Need to set the color of the correct answer to be green


            //  private final Runnable mColorRunnable = new Runnable( ) {


            // once user answers the question, we move on to the next one, if any


            //}

            //Delays the changing of the color
            ///public void delayTheColor(View v) {
            // mHandler.postDelayed(mColorRunnable, 7000);
            //}



package ranch.anjani.com.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestions;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true), new TrueFalse(R.string.question_asia, false),
            new TrueFalse(R.string.question_mideast, false), new TrueFalse(R.string.question_oceans, true)};
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNextButton = (Button) findViewById(R.id.next_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mQuestions = (TextView) findViewById(R.id.questions_textview);



        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex= (mCurrentIndex+1) %mQuestionBank.length;
                updateQuestion();
            }
        });
        mQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex= (mCurrentIndex+1) %mQuestionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void updateQuestion(){
        int question= mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestions.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrue();
        int message=0;
        if(userPressedTrue==answerIsTrue)
            message=R.string.correct_toast;
        else
            message=R.string.incorrect_toast;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

package ranch.anjani.com.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static ranch.anjani.com.geoquiz.MainActivity.EXTRA_ANSWER_IS_TRUE;

/**
 * Created by Pc on 6/2/2017.
 */

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_SHOWN ="com.bignerdranch.android.geoquiz.answer_shown";
    private static final String CHEATERORNOT="cheater or not";
    private static final String TAG="CheatActivity";
    private boolean mAnswerIsTrue;
    private TextView mTextAnswer;
    private Button mShowButton;
    private boolean clicked;
    String s;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(CHEATERORNOT,clicked);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat_layout);
        mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mTextAnswer=(TextView)findViewById(R.id.answer_textview);
        mShowButton=(Button)findViewById(R.id.show_answer_button);
        if (savedInstanceState!=null) {
            if (savedInstanceState.getBoolean(CHEATERORNOT))
                 s="true";
            else
                 s="false";
            Log.d(TAG,s);
            cheaterOrNot(savedInstanceState.getBoolean(CHEATERORNOT));
        }
        else
            cheaterOrNot(false);

        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue)
                    mTextAnswer.setText(R.string.true_button);
                else
                    mTextAnswer.setText(R.string.false_button);
                cheaterOrNot(true);
            }
        });
    }

    private void cheaterOrNot(boolean b){
        if(b){
            clicked=true;
            setAnswerShown(true);
        }else {
            clicked=false;
            setAnswerShown(false);
        }
    }

    private void setAnswerShown(boolean isAnswerShown){
        Intent data= new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
 //mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);    }
package ranch.anjani.com.geoquiz;

/**
 * Created by Pc on 6/1/2017.
 */

public class TrueFalse {

    private int mQuestion;
    private boolean mTrue;

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean ismTrue() {
        return mTrue;
    }

    public void setmTrue(boolean mTrue) {
        this.mTrue = mTrue;
    }

    public TrueFalse(int mQuestion, boolean mTrue) {

        this.mQuestion = mQuestion;
        this.mTrue = mTrue;
    }
}

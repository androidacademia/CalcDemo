package calcdemo.androidacademia.com.calcdemo;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private FloatingActionButton floatDel;
    private String readStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);
        floatDel = findViewById(R.id.fabDel);
        floatDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               readStr = textViewResult.getText().toString();
               if (!readStr.isEmpty()) {
                   readStr = removeLastChar(readStr);
                   textViewResult.setText(readStr);

               }
            }
        });

        floatDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                readStr = "";
                textViewResult.setText("");
                return true;
            }
        });
    }

    public void button7(View view) {
        appendText("7");
    }

    public void button8(View view) {
        appendText("8");
    }

    public void button9(View view) {
        appendText("9");
    }

    public void button4(View view) {
        appendText("4");
    }

    public void button5(View view) {
        appendText("5");
    }

    public void button6(View view) {
        appendText("6");
    }

    public void button1(View view) {
        appendText("1");
    }

    public void button2(View view) {
        appendText("2");
    }

    public void button3(View view) {
        appendText("3");
    }

    public void buttonDot(View view) {
        try {

            String temp = readStr.charAt(readStr.length()-1)+"";
            Integer i = Integer.parseInt(temp);
            appendText(".");
        }catch (Exception e){
            appendText("0.");
        }
    }

    public void button0(View view) {
        appendText("0");
    }

    public void buttonEq(View view) {

        try {
            Expression e = new Expression(readStr);
            Double v = e.calculate();
            readStr = v.toString();
            textViewResult.setText(readStr);
            //readStr = "";
        }catch (ArithmeticException e){
            readStr = e.getMessage();
            textViewResult.setText(readStr);
            readStr = "";
        }
    }

    public void buttonDiv(View view) {
        appendText("/");
    }

    public void buttonMul(View view) {
        appendText("*");
    }

    public void buttonAdd(View view) {
        appendText("+");
    }

    public void buttonSub(View view) {
        appendText("-");
    }

    public void appendText(final String c){
        readStr+=c;
        textViewResult.setText(readStr);
    }

    /////Remove the Last Character///////
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
}

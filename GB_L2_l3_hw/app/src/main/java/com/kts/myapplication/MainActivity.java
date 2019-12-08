package com.kts.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numberInput;
    TextView textView;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void count(View view) {
        numberInput = findViewById(R.id.editText);
        number = Integer.parseInt(numberInput.getText().toString());
        textView = findViewById(R.id.textView);

//        int result = (int) Math.log(1+ number);           //Раскомментировать для выполнения в главном потоке
//        for (int i = 1; i < number; i++){
//            result += 1000 * Math.getExponent(number) / Math.log1p(number * Math.log10(number));          //Раскомментировать для выполнения в главном потоке
//            try {
//                Thread.sleep(1000);                       //Раскомментировать для выполнения в главном потоке
//            } catch (InterruptedException e) {            //Раскомментировать для выполнения в главном потоке
//                e.printStackTrace();                      //Раскомментировать для выполнения в главном потоке
//            }
//        }
//        textView.setText(((Integer)result).toString());   //Раскомментировать для выполнения в главном потоке
        calculation();                                      //Закомментировать для выполнения в главном потоке
    }

    private void calculation() {
        AsyncTask<Integer, Integer, Integer> task = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected Integer doInBackground(Integer... integers) {
                int result = (int) Math.log(1+ number);
                for (int i = 1; i < number; i++){
                    result += 1000 * Math.getExponent(number) / Math.log1p(number * Math.log10(number));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                textView.setText(integer.toString());
            }
        };
        task.execute();
    }



}

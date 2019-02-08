package info.androidhive.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescActivity extends AppCompatActivity {
    public String eventname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        TextView t6 = (TextView) findViewById(R.id.textView6);
        ImageView i = (ImageView) findViewById(R.id.imageView2);
        TextView t7 = (TextView) findViewById(R.id.textView7);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            eventname =(String) b.get("eventname");
            //eventname = j;
            Toast.makeText(DescActivity.this, eventname,
                    Toast.LENGTH_LONG).show();
        }

        if( eventname.equals("QUIZ") ) {
          t6.setText(eventname);
          i.setImageResource(R.drawable.quiz);
          t7.setText("“Qriosity” The General Quiz Competition\n" +
                  "“The only source of knowledge is experience”-Albert Einstein\n" +
                  "\n" +
                  "Details below : \n" +
                  "\n" +
                  "Date: Wednesday,13 February 2019\n" +
                  "\n" +
                  "Timings :Registration begins at 10AM.Prelims of the quiz begins at 12AM,followed by finals.\n" +
                  "\n" +
                  "Prizes worth over Rs.3000/-\n" +
                  "\n" +
                  "Venue:Brahmaguptha Hall,NCERC \n" +
                  "\n" +
                  "\n" +
                  "\n" +
                  "\n" +
                  "Cordinators:\n" +
                  "\n" +
                  "Rafeek T S: 9946289298\n" +
                  "\n" +
                  "Rahul .R : 8111976193\n" +
                  "\n" +
                  "Expect questions from any topic under the sun!!!\n" +
                  "\n" +
                  "General Rules And Regulations:\n" +
                  "\n" +
                  "1.\tA team can consist of maximum 2 members .Lone wolves are permitted.\n" +
                  "\n" +
                  "2.\tThere will be a preliminary round followed by the finals.\n" +
                  "\n" +
                  "3.\tTop 6 teams from the prelims will qualify to the finals.\n" +
                  "\n" +
                  "4.\tAny numbers of teams from an institution are allowed.\n" +
                  "\n" +
                  "5.\tRegistration for event will be separate and the registration fee per team is Rs.50.\n" +
                  "\n" +
                  "6.\tParticipants must produce a valid ID card during registration.\n" +
                  "\n" +
                  "7.\tThe rules of the quiz and it’s format for each round will be explained by the quizmaster on the day of the event prior to the round.\n" +
                  "\n" +
                  "8.\tAll decisions of the quiz master shall be final and binding.\n" +
                  "\n" +
                  "\n" +
                  "Hope to see you all participate and win amazing prizes at Qriosity 2019.Till then ,happy quizzing!");
        }
    }
}

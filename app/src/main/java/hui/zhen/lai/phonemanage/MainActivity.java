package hui.zhen.lai.phonemanage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> peopleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiCon(); //初始化联系人
        RecyclerView contactView = (RecyclerView) findViewById(R.id.contactView);
        LinearLayoutManager layoutManger = new LinearLayoutManager(this);
        contactView.setLayoutManager(layoutManger);
        ContactAdapter adapter = new ContactAdapter(peopleList);
        contactView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {     //注册浮动按钮，按钮的功能为添加新的联系人，并绑定监听器
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, add_contact.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate thenu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.menu_settings) {
                Toast.makeText(this, "set", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if(id == R.id.menu_add) {
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    private void intiCon() {
        for (int i = 0; i <20 ; i++) {
            peopleList.add(new Contact());
        }
    }
}

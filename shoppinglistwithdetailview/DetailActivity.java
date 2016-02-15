package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private ListView mShoppingListView;
    private CursorAdapter mCursorAdapter;
    private ShoppingSQLiteOpenHelper mHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }
    Cursor cursor = ShoppingSQLiteOpenHelper.getShoppingList();
    CursorAdapter cursorAdapter = new CursorAdapter(DetailActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.activity_detail, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView itemNameTextView = (TextView)view.findViewById(R.id.item_name_text_view);
                TextView descriptionTextView = (TextView)view.findViewById(R.id.description_text_view);
                TextView priceTextView = (TextView)view.findViewById(R.id.price_text_view);
                TextView typeTextView = (TextView)view.findViewById(R.id.type_text_view);
                itemNameTextView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME)));
                descriptionTextView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION)));
                priceTextView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE)));
                typeTextView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE)));
            }
        };

    int position = getIntent().getIntExtra("_id", -1);
    ListView mListview = (ListView) findViewById(R.id.shopping_list_view);

}

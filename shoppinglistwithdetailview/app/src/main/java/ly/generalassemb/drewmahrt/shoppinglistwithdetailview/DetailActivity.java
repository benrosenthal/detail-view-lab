package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ShoppingSQLiteOpenHelper mHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mHelper = new ShoppingSQLiteOpenHelper(DetailActivity.this);

        TextView itemNameTextView = (TextView)findViewById(R.id.item_name_text_view);
        TextView descriptionTextView = (TextView)findViewById(R.id.description_text_view);
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        TextView typeTextView = (TextView)findViewById(R.id.type_text_view);

        int id = getIntent().getIntExtra("_id", -1);

        if(id > 0){
                itemNameTextView.setText("Item Name: " + mHelper.getItemName(id));
                descriptionTextView.setText("Item Description: "+ mHelper.getDescriptionId(id));
                priceTextView.setText("Item Price :" + mHelper.getPriceName(id));
                typeTextView.setText("Item Type: " + mHelper.getTypeName(id));
            }
    }

}

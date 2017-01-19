package titleBar.act;

import android.app.Activity;
import android.os.Bundle;

import com.custom.titlebar.R;

import titleBar.widget.LeftBackRightImageTitleBar;

/**
 * Created by IME on 2017/1/19.
 * <p>
 * 自定义更改系统的Title
 */

public class CustomTitleAct extends Activity {

    private LeftBackRightImageTitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitleBar = new LeftBackRightImageTitleBar(CustomTitleAct.this);
        mTitleBar.onRreActivityLayout();
        setContentView(R.layout.activity_custom_title);
        mTitleBar.onPostActivityLayout();
        mTitleBar.setTitle("标题栏");
        mTitleBar.setRightImage(R.mipmap.titleicon_light_search);
        mTitleBar.showImageButton();

        mTitleBar.setTilteBarShowing(true);
    }
}

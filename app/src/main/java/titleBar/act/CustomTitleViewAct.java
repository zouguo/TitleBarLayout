package titleBar.act;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.custom.titlebar.R;

/**
 * Created by IME on 2017/1/19.
 * <p>
 * 自定义添加到布局中的Title
 */

public class CustomTitleViewAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_custom_view);
    }

}

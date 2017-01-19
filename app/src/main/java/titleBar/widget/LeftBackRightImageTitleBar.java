package titleBar.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.custom.titlebar.R;


public class LeftBackRightImageTitleBar extends CoupletTitleBar {

    private Button btnTitle;
    private View viewBack, viewRight;
    private View.OnClickListener onBackClickListener, onRightTwoClickListener, onImageClickListener, onTitleClickListener;

    public LeftBackRightImageTitleBar(Activity activity) {
        super(activity);
    }

    @Override
    public void onPostActivityLayout() {
        super.onPostActivityLayout();
        // Back
        viewBack = setLeftView(R.layout.titlebar_back_view);
        // Title
        btnTitle = setMiddleView(R.layout.titlebar_title_btn);
        // Image
        viewRight = setRightView(R.layout.titlebar_right_image_btn);
    }

    @Override
    void onLeftViewClick(View view) {
        if (onBackClickListener != null) {
            onBackClickListener.onClick(view);
        } else {
            mActivity.finish();
        }
    }

    @Override
    void onMiddleViewClick(View view) {
        if (onTitleClickListener != null) {
            onTitleClickListener.onClick(view);
        }
    }

    @Override
    void onRightViewClick(View view) {
        if (onImageClickListener != null) {
            onImageClickListener.onClick(view);
        }
    }

    @Override
    void onRightTwoViewClick(View view) {
        if (null != onRightTwoClickListener) {
            onRightTwoClickListener.onClick(view);
        }
    }

    public void setBackImage(int resId) {
        if (viewBack == null) {
            throw new RuntimeException("Back Button View haven't been infalte yet!");
        } else {
            ((ImageView) viewBack.findViewById(R.id.back)).setImageResource(resId);
        }
    }

    public void setBackImage(Drawable drawable) {
        if (viewBack == null) {
            throw new RuntimeException("Back Button View haven't been infalte yet!");
        } else {
            ((ImageView) viewBack.findViewById(R.id.back)).setImageDrawable(drawable);
        }
    }

    public void hideBackButton() {
        if (viewBack == null) {
            throw new RuntimeException("Back Button View haven't been infalte yet!");
        } else if (viewBack.getVisibility() != View.INVISIBLE) {
            viewBack.setVisibility(View.INVISIBLE);
        }
    }

    public void showBackButton() {
        if (viewBack == null) {
            throw new RuntimeException("Back Button View haven't been infalte yet!");
        } else if (viewBack.getVisibility() != View.VISIBLE) {
            viewBack.setVisibility(View.VISIBLE);
        }
    }

    public void setTitle(int resId) {
        if (btnTitle == null) {
            throw new RuntimeException("Middle Title View haven't been infalte yet!");
        } else {
            btnTitle.setText(resId);
        }
    }

    public void setTitle(CharSequence title) {
        if (btnTitle == null) {
            throw new RuntimeException("Middle Title View haven't been infalte yet!");
        } else {
            btnTitle.setText(title);
        }
    }

    public void setTitleRightImage(int imageid) {
        if (btnTitle == null) {
            throw new RuntimeException("Middle Title View haven't been infalte yet!");
        } else {
            if (imageid > 0) {
                Resources res = mActivity.getResources();
                Drawable myImage = res.getDrawable(imageid);
                myImage.setBounds(0, 0, 15, 15);
                btnTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, myImage, null);
            } else {
                btnTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

        }
    }

    public void setRightImage(int resId) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            ((Button) viewRight.findViewById(R.id.right_btn)).setBackgroundResource(resId);
        }
    }

    public void setRightText(String name) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            ((Button) viewRight.findViewById(R.id.right_btn)).setText(name);
        }
    }

    public void setRightImage(Drawable drawable) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            ((Button) viewRight.findViewById(R.id.right_btn)).setBackgroundDrawable(drawable);
        }
    }

    public void hideImageButton() {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else if (viewRight.getVisibility() != View.INVISIBLE) {
            viewRight.setVisibility(View.INVISIBLE);
        }
    }

    public void realHideImageButton() {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            viewRight.setVisibility(View.GONE);
        }
    }

    public void showImageButton() {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else if (viewRight.getVisibility() != View.VISIBLE) {
            viewRight.setVisibility(View.VISIBLE);
        }
    }

    public void setRightEnabled(boolean enabled) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            viewRight.setEnabled(enabled);
            (viewRight.findViewById(R.id.right_btn)).setEnabled(enabled);
        }
    }


    public void setRightTwoImage(int resId) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            ((ImageButton) viewRight.findViewById(R.id.right_two)).setImageResource(resId);
        }
    }

    public void setRightTwoImage(Drawable drawable) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            ((ImageButton) viewRight.findViewById(R.id.right_two)).setImageDrawable(drawable);
        }
    }

    public void hideRightTwoButton() {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else if (viewRight.getVisibility() != View.INVISIBLE) {
            viewRight.setVisibility(View.VISIBLE);
            viewRight.findViewById(R.id.right_two).setVisibility(View.INVISIBLE);
        }
    }

    public void realHideRightTwoButton() {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            viewRight.setVisibility(View.VISIBLE);
            viewRight.findViewById(R.id.right_two).setVisibility(View.GONE);
        }
    }

    public void showRightTwoButton() {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else if ((viewRight.findViewById(R.id.right_two)).getVisibility() != View.VISIBLE) {
            viewRight.setVisibility(View.VISIBLE);
            (viewRight.findViewById(R.id.right_two)).setVisibility(View.VISIBLE);
        }
    }

    public void setRightTwoEnabled(boolean enabled) {
        if (viewRight == null) {
            throw new RuntimeException("Right Image Button haven't been infalte yet!");
        } else {
            viewRight.setEnabled(enabled);
            (viewRight.findViewById(R.id.right_two)).setEnabled(enabled);
        }
    }


    public void setOnBackClickListener(View.OnClickListener listener) {
        this.onBackClickListener = listener;
    }

    public void setOnImageClickListener(View.OnClickListener listener) {
        this.onImageClickListener = listener;
    }

    public void setOnRightTwoClickListener(View.OnClickListener listener) {
        this.onRightTwoClickListener = listener;
    }

    public void setOnTitleClickListener(View.OnClickListener listener) {
        this.onTitleClickListener = listener;
    }

    public View getViewBack() {
        if (viewBack == null) {
            return null;
        }
        if (viewBack.getVisibility() == View.VISIBLE) {
            return viewBack;
        }
        return null;
    }
}

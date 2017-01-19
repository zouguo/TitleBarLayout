package titleBar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.custom.titlebar.R;

import titleBar.utils.UiUtilC;


public class TitleBarLayout extends RelativeLayout {
    public static final int DEFAULT_TRANSPARENT_ALPHA = 255;
    private RelativeLayout mTitleLayout;
    private ImageView mLeftButton, mRightButton, mCenterImage;
    private TextView mCenterTitleTextView;

    private View.OnClickListener mOnBackClickListener;
    private View.OnClickListener mOnRightClickListener;

    public TitleBarLayout(Context context) {
        super(context);
        init(context, null);
    }

    public TitleBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View childView = layoutInflater.inflate(R.layout.titlebar_layout, null);
        mTitleLayout = (RelativeLayout) childView.findViewById(R.id.layout_title);
        mCenterTitleTextView = (TextView) childView.findViewById(R.id.titlebar_center);
        mLeftButton = (ImageView) childView.findViewById(R.id.titlebar_leftbutton);
        mRightButton = (ImageView) childView.findViewById(R.id.titlebar_rightbutton);
        mCenterImage = (ImageView) childView.findViewById(R.id.titlebar_center_image);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBackClickListener != null) {
                    mOnBackClickListener.onClick(v);
                }
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRightClickListener != null) {
                    mOnRightClickListener.onClick(v);
                }
            }
        });

        RelativeLayout.LayoutParams lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UiUtilC.dp2px(getContext(), 42));
        addView(childView, lps);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleBarLayout);

            int backgroundResId = a.getResourceId(R.styleable.TitleBarLayout_background, -1);
            if (backgroundResId != -1) {
                mTitleLayout.setBackgroundResource(backgroundResId);
            }

            int backgroundAlpha = a.getInteger(R.styleable.TitleBarLayout_alpha, DEFAULT_TRANSPARENT_ALPHA);
            mTitleLayout.getBackground().mutate().setAlpha(backgroundAlpha);

            Drawable leftButtonDrawable = a.getDrawable(R.styleable.TitleBarLayout_leftButton);
            if (leftButtonDrawable != null) {
                mLeftButton.setImageDrawable(leftButtonDrawable);
            }
            Drawable rightDrawable = a.getDrawable(R.styleable.TitleBarLayout_rightButton);
            if (rightDrawable != null) {
                mRightButton.setImageDrawable(rightDrawable);
            }
            String title = a.getResourceId(R.styleable.TitleBarLayout_centerTitle, -1) == -1 ? a.getString(R.styleable.TitleBarLayout_centerTitle) : getResources().getString(a.getResourceId(R.styleable.TitleBarLayout_centerTitle, -1));
            if (title != null) {
                mCenterTitleTextView.setText(title);
            }
            a.recycle();
        }

    }

    /**
     * 此alpha 设置是为了达到实现和QQ空间滑动标题栏背景透明度变化一样
     *
     * @param alpha
     */
    public void setBackgroundAlpha(int alpha) {
        if (alpha > 255) {
            mTitleLayout.getBackground().setAlpha(255);
            return;
        }

        if (alpha < 0) {
            mTitleLayout.getBackground().setAlpha(0);
            return;
        }

        mTitleLayout.getBackground().setAlpha(alpha);
    }

    public void setTitle(int resId) {
        mCenterTitleTextView.setText(getResources().getString(resId));
    }

    public void setTitleAlpha(float alpha) {
        mCenterTitleTextView.setAlpha(alpha);
    }

    public void setTitle(String title) {
        mCenterTitleTextView.setText(title);
    }

    public void hideBackButton() {
        mLeftButton.setVisibility(GONE);
    }

    public void showBackButton() {
        mLeftButton.setVisibility(VISIBLE);
    }

    public void setBackImage(int resId) {
        mLeftButton.setImageResource(resId);
    }

    public void setRightImage(int resId) {
        mRightButton.setImageResource(resId);
    }

    public void setRightImage(Drawable drawable) {
        mRightButton.setImageDrawable(drawable);
    }

    public void hideRightButton() {
        mRightButton.setVisibility(GONE);
    }

    public void showRightButton() {
        mRightButton.setVisibility(VISIBLE);
    }

    public void setCenterImage(int resId) {
        mCenterImage.setVisibility(VISIBLE);
        mCenterImage.setImageResource(resId);
    }

    public void setCenterImage(Drawable drawable) {
        mCenterImage.setVisibility(VISIBLE);
        mCenterImage.setImageDrawable(drawable);
    }

    public void setCenterImageAlpha(float alpha) {
        mCenterImage.setAlpha(alpha);
    }

    public void setOnBackClickListener(View.OnClickListener listener) {
        this.mOnBackClickListener = listener;
    }

    public void setOnRightClickListener(View.OnClickListener listener) {
        this.mOnRightClickListener = listener;
    }

}

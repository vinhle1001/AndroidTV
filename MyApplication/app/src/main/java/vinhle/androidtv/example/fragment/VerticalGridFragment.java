package vinhle.androidtv.example.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ObjectAdapter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.VerticalGridPresenter;

/**
 * Created by VinhLe on 12/23/17.
 */
public class VerticalGridFragment extends android.support.v17.leanback.app.VerticalGridFragment
        implements android.support.v17.leanback.app.BrowseFragment.MainFragmentRowsAdapterProvider,
        android.support.v17.leanback.app.BrowseFragment.MainFragmentAdapterProvider {

    private final static int COLUMNS = 5;
    private MainFragmentAdapter mMainFragmentAdapter;
    private MainFragmentRowsAdapter mMainFragmentRowsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VerticalGridPresenter presenter = new VerticalGridPresenter();
        presenter.setNumberOfColumns(COLUMNS);
        setGridPresenter(presenter);
    }

    @Override
    public MainFragmentAdapter getMainFragmentAdapter() {
        if (mMainFragmentAdapter == null) {
            mMainFragmentAdapter = new MainFragmentAdapter(this);
        }
        return mMainFragmentAdapter;
    }

    @Override
    public MainFragmentRowsAdapter getMainFragmentRowsAdapter() {
        if (mMainFragmentRowsAdapter == null) {
            mMainFragmentRowsAdapter = new MainFragmentRowsAdapter(this);
        }
        return mMainFragmentRowsAdapter;
    }


    private class MainFragmentAdapter extends BrowseFragment.MainFragmentAdapter<VerticalGridFragment> {

        public MainFragmentAdapter(VerticalGridFragment fragment) {
            super(fragment);
        }

        @Override
        public boolean isScalingEnabled() {
            return true;
        }
    }

    private class MainFragmentRowsAdapter extends BrowseFragment.MainFragmentRowsAdapter<VerticalGridFragment> {

        public MainFragmentRowsAdapter(VerticalGridFragment fragment) {
            super(fragment);
        }

        @Override
        public void setAdapter(ObjectAdapter adapter) {
//            super.setAdapter(adapter);
        }

        @Override
        public void setOnItemViewClickedListener(OnItemViewClickedListener listener) {
            getFragment().setOnItemViewClickedListener(listener);
        }

        @Override
        public void setOnItemViewSelectedListener(OnItemViewSelectedListener listener) {
            getFragment().setOnItemViewSelectedListener(listener);
        }
    }
}

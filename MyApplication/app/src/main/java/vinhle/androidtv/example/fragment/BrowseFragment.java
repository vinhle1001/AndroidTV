package vinhle.androidtv.example.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.support.v17.leanback.widget.VerticalGridPresenter;
import android.widget.Toast;

import vinhle.androidtv.example.data.PageRow;
import vinhle.androidtv.example.presenter.GridItemPresenter;

/**
 * Created by VinhLe on 12/23/17.
 */
public class BrowseFragment extends android.support.v17.leanback.app.BrowseFragment {

    static final String[] CHANELS = {"Warner TV", "AXN", "STARWORLD", "DISNEY", "HBO",
            "StarMovies", "Discovery Channel"};

    private ArrayObjectAdapter mAdapter = new ArrayObjectAdapter(new VerticalGridPresenter());

    private class VerticalGridFragmentFactory extends FragmentFactory<VerticalGridFragment> {
        @Override
        public VerticalGridFragment createFragment(Object row) {
            if (row instanceof PageRow) {
                VerticalGridFragment fragment = new VerticalGridFragment();
                fragment.setAdapter(((PageRow) row).getAdapter());
                return fragment;
            }
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VerticalGridFragmentFactory factory = new VerticalGridFragmentFactory();
        getMainFragmentRegistry().registerFragment(PageRow.class, factory);

        setOnItemViewSelectedListener(mItemViewSelectedListener);
        setOnItemViewClickedListener(mItemViewClickedListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData();
    }

    private void loadData() {
        mAdapter.clear();
        PageRow row = new PageRow(new HeaderItem("Chanel"), new ArrayObjectAdapter(new GridItemPresenter()));
        for (String chanel : CHANELS) {
            ((ArrayObjectAdapter) row.getAdapter()).add(chanel);
        }
        mAdapter.add(row);
        setAdapter(mAdapter);
    }

    private OnItemViewSelectedListener mItemViewSelectedListener = new OnItemViewSelectedListener() {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Toast.makeText(getContext(), "Selected item: " + row.toString(), Toast.LENGTH_LONG).show();
        }
    };

    private OnItemViewClickedListener mItemViewClickedListener = new OnItemViewClickedListener() {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Toast.makeText(getContext(), "Clicked item: " + row.toString(), Toast.LENGTH_LONG).show();
        }
    };
}

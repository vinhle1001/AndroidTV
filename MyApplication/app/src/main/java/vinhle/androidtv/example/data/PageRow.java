package vinhle.androidtv.example.data;

import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ObjectAdapter;

/**
 * Created by VinhLe on 12/23/17.
 */
public class PageRow extends android.support.v17.leanback.widget.PageRow {

    private ObjectAdapter mAdapter;

    public PageRow(HeaderItem headerItem, ObjectAdapter adapter) {
        super(headerItem);
        this.mAdapter = adapter;
    }

    public ObjectAdapter getAdapter() {
        return mAdapter;
    }
}

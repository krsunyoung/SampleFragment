package org.androidtown.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SampleListFragment extends ListFragment {

	private int index = 0;
	private OnListFragmentInteractionListener mListener;

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		index = position;
		mListener.onListFragmentInteraction(position);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter( ArrayAdapter.createFromResource(getActivity(), R.array.image_titles, android.R.layout.simple_list_item_1) );

		if (savedInstanceState != null) {
			index = savedInstanceState.getInt("index", 0);
			mListener.onListFragmentInteraction(index);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("index", index);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		if (context instanceof OnListFragmentInteractionListener) {
			mListener = (OnListFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	public interface OnListFragmentInteractionListener {
		void onListFragmentInteraction(int index);
	}
}

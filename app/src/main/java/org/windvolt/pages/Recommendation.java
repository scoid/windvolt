/*
    This file is part of windvolt.org.

    Copyright (c) 2020 Max Sumer

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.windvolt.pages;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import org.windvolt.R;

public class Recommendation extends Fragment {

    final int LOAD_NOT_AVAILABLE = -1;
    final int LOAD_NOT_RECOMMENDED = 0;
    final int LOAD_SMART_DEVICES = 1;
    final int LOAD_MORE_DEVICES = 10;
    final int LOAD_MANY_DEVICES = 11;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.recommendation, container, false);

        // TODO display recommendation state
        setRecommendation(view, LOAD_NOT_AVAILABLE);

        return view;
    }

    private void setRecommendation(View view, int state) {
        ImageView icon = view.findViewById(R.id.recommendation_image);

        TextView recommend = view.findViewById(R.id.recommendation_text);
        TextView location = view.findViewById(R.id.text_geolocation);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String loc = sharedPreferences.getString("input_location", "");

        if (loc.isEmpty()) { loc = "<settings.location>"; }
        location.setText(loc);

        switch (state) {
            case LOAD_NOT_RECOMMENDED:
                recommend.setText("laden nur falls nötig");
                break;

            case LOAD_SMART_DEVICES:
                recommend.setText("kleine Geräte laden");
                break;

            case LOAD_MORE_DEVICES:
                recommend.setText("große Geräte laden");
                break;

            case LOAD_MANY_DEVICES:
                recommend.setText("alle Geräte laden");
                break;

            default:
                recommend.setText("keine Empfehlung verfügbar");
        }
    }
}
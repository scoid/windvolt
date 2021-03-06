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
package org.windvolt.story;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.windvolt.R;

public class StoryPage extends Fragment {

    private static final String ARG_COUNT = "param1";
    private Integer counter;

    private int[] COLOR_MAP = {
            R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700, R.color.blue_100,
            R.color.blue_300, R.color.blue_500, R.color.blue_700, R.color.green_100, R.color.green_300,
            R.color.green_500, R.color.green_700
    };

    private String[] story = {
            "Den Wind zu nutzen lernten die Menschen schon früh.",
            "Es liegt nahe den Wind in Strom umzuwandeln.",
            "Leider ist der Wind sehr flackerig.",
            "Mit unseren Smartphones können wir den Windstrom speichern.",
            "Das Smartphone kann man immer laden. Es kann sich nicht überladen.",
            "Ein typisches Smartphone hat eine Leistung von 11 Wattstunden im Betrieb. Beim Laden sind es 3 Wattstunden.",
            "windvolt informiert Dich wenn sich das Laden lohnt."
    };

    public StoryPage() {
        // Required empty public constructor
    }

    public static StoryPage newInstance(Integer counter) {
        StoryPage fragment = new StoryPage();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.story_page, container, false);
        return view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.setBackgroundColor(ContextCompat.getColor(getContext(), COLOR_MAP[counter]));

        TextView textViewCounter = view.findViewById(R.id.tv_counter);
        textViewCounter.setText(story[counter]);

        int c = counter + 1;
        String wiper = Integer.toString(c) + "/" + Integer.toString(story.length);
        if (c == 1) {
            wiper = "    " + wiper + "    ►";
        } else if (c < story.length) {
            wiper = "◄    " + wiper + "    ►";
        } else {
            wiper = "◄    " + wiper + "    ";
        }

        TextView state = view.findViewById(R.id.tv_header);
        state.setText(wiper);
    }
}
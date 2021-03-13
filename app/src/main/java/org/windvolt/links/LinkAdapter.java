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
package org.windvolt.links;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.windvolt.R;

import java.util.ArrayList;
import java.util.List;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.LinkViewHolder> {

    private List<Link> links = new ArrayList();

    public LinkAdapter() {
        links.add(new Link("Livedaten der Netzagentur", "http://www.smard.de", R.drawable.logo_smard));
        links.add(new Link("Nachrichten und Daten", "http://www.windjournal.de", R.drawable.logo_windjournal));
        links.add(new Link("BMWE Energiewende", "http://www.erneuerbare-energien.de", R.drawable.logo_energiewende));
        links.add(new Link("Windkraft beim Umweltamt", "http://www.umweltbundesamt.de/themen/klima-energie/erneuerbare-energien/windenergie", R.drawable.logo_umweltamt));
        links.add(new Link("Verband Windenergie", "http://www.wind-energie.de", R.drawable.logo_windverband));
        links.add(new Link("Windbranche", "http://www.windbranche.de/wind/windstrom/windenergie-deutschland", R.drawable.logo_windbranche));
        links.add(new Link("ENTSO-E Transparenzplattform", "http://www.netztransparenz.de/Weitere-Veroeffentlichungen/Windenergie-Hochrechnung", R.drawable.logo_netztransparenz));
        links.add(new Link("Strombörse EEX Spotpreise", "http://bricklebrit.com/stromboerse_leipzig.html", R.drawable.logo_bricklebrit));


    }


    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.links_item, parent, false);

        LinkViewHolder viewHolder = new LinkViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, final int position) {
        holder.getSubject().setText("\n " + links.get(position).getSubject());
        holder.getImage().setImageResource(links.get(position).getImage());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = links.get(position).getAddress();
                v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        };

        holder.getImage().setOnClickListener(listener);
        holder.getSubject().setOnClickListener(listener);
    }

    @Override
    public int getItemCount() { return links.size(); }






    class LinkViewHolder extends RecyclerView.ViewHolder {

        private TextView subject;
        private ImageView image;

        public LinkViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.link_image);
            subject = itemView.findViewById(R.id.link_subject);
        }

        public TextView getSubject() { return subject; }
        public ImageView getImage() { return image; }

    }
}

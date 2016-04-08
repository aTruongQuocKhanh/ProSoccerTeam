package com.khanhtq.appcore.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.view.MultiDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 4/7/16.
 */
public class TeamRender extends DefaultClusterRenderer<Team> {
    private final Context mContext;
    private final IconGenerator mIconGenerator;
    private final IconGenerator mClusterIconGenerator;
    private final ImageView mImageView;
    private final ImageView mClusterImageView;
    private final int mDimension;

    public TeamRender(Context context, GoogleMap map, ClusterManager<Team> clusterManager) {
        super(context, map, clusterManager);
        mContext = context;
        mIconGenerator = new IconGenerator(mContext);
        mClusterIconGenerator = new IconGenerator(mContext);
        View multiProfile = ((Activity) mContext).getLayoutInflater().inflate(R.layout.multi_profile, null);
        mClusterIconGenerator.setContentView(multiProfile);
        mClusterIconGenerator.setBackground(mContext.getResources().getDrawable(R.drawable.marker_background));
        mClusterImageView = (ImageView) multiProfile.findViewById(R.id.image);

        View singleProfile = ((Activity) mContext).getLayoutInflater().inflate(R.layout.single_profile, null);
        mIconGenerator.setContentView(singleProfile);
        mIconGenerator.setBackground(mContext.getResources().getDrawable(R.drawable.marker_background));
        mImageView = (ImageView) singleProfile.findViewById(R.id.profile_image);
        mDimension = (int) mContext.getResources().getDimension(R.dimen.custom_profile_image);
    }

    @Override
    protected void onBeforeClusterItemRendered(Team team, MarkerOptions markerOptions) {
        // Draw a single person.
        // Set the info window to show their name.
        mImageView.setImageResource(team.getIconDrawable());
        Bitmap icon = mIconGenerator.makeIcon();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(team.getName());
    }

    @Override
    protected void onBeforeClusterRendered(Cluster<Team> cluster, MarkerOptions markerOptions) {
        // Draw multiple people.
        // Note: this method runs on the UI thread. Don't spend too much time in here (like in this example).
        List<Drawable> profilePhotos = new ArrayList<Drawable>(Math.min(5, cluster.getSize()));
        int width = mDimension;
        int height = mDimension;

        for (Team team : cluster.getItems()) {
            // Draw 4 at most.
            if (profilePhotos.size() == 4) break;
            Drawable drawable = mContext.getResources().getDrawable(team.getIconDrawable());
            drawable.setBounds(0, 0, width, height);
            profilePhotos.add(drawable);
        }
        MultiDrawable multiDrawable = new MultiDrawable(profilePhotos);
        multiDrawable.setBounds(0, 0, width, height);

        mClusterImageView.setImageDrawable(multiDrawable);
        Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster cluster) {
        // Always render clusters.
        return cluster.getSize() > 1;
    }
}

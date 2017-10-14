package com.example.singh.android_rxjava2.RxAndroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.singh.android_rxjava2.R;
import com.example.singh.android_rxjava2.RxAndroid.model.Repo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 10/12/17.
 */

public class RepoListAdapter  extends RecyclerView.Adapter<RepoListAdapter.ViewHolder>{

    private static final String TAG = "RepoListAdapter";
    List<Repo> repoList= new ArrayList<>();
    Context context;

    public RepoListAdapter(List<Repo> repoList) {
        this.repoList = repoList;
        Log.d(TAG, "RepoListAdapter: " + repoList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.repo_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Repo repo = repoList.get(position);

        holder.tvRepoName.setText(repo.getName());
        Glide.with(context)
                .load(repo.getOwner().getAvatarUrl())
                .into(holder.ivRepoAvatar);

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRepoName;
        private final ImageView ivRepoAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
            tvRepoName = itemView.findViewById(R.id.tvRepoName);
            ivRepoAvatar = itemView.findViewById(R.id.ivRepoAvatar);
        }
    }
}

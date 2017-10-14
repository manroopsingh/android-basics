package com.example.singh.android_rxjava2.RxAndroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.singh.android_rxjava2.R;
import com.example.singh.android_rxjava2.RxAndroid.data.remote.RemoteDataSource;
import com.example.singh.android_rxjava2.RxAndroid.model.Repo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RepoList extends AppCompatActivity {


    private static final String TAG = "RepoList";
    List<Repo> repoList = new ArrayList<>();
    private RecyclerView rvRepoList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private RepoListAdapter repoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRepoList = findViewById(R.id.rvRepoList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();



        RemoteDataSource.getRepos("manroopsingh")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<List<Repo>, Observable<Repo>>() {
                    @Override
                    public Observable<Repo> apply(@NonNull List<Repo> repos) throws Exception {

                        Observable<Repo> repoObservable = Observable.create(new ObservableOnSubscribe<Repo>() {
                            @Override
                            public void subscribe(@NonNull ObservableEmitter<Repo> e) throws Exception {

                            }
                        });
                        return repoObservable;
                    }
                })
                .map(new Function<Repo, Repo>() {
                    @Override
                    public Repo apply(@NonNull Repo repo) throws Exception {

                        String repoName = repo.getName();
                        repo.setName("My " + repoName);
                        return repo;
                    }
                })
                .subscribe(new Observer<Repo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull Repo repo) {

                        Log.d(TAG, "onNext: " + repo.getName());
                        repoList.add(repo);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {

                        Log.d(TAG, "onComplete: ");
                        repoListAdapter = new RepoListAdapter(repoList);
                        rvRepoList.setLayoutManager(layoutManager);
                        rvRepoList.setItemAnimator(itemAnimator);
                        rvRepoList.setAdapter(repoListAdapter);

                    }
                });
    }

}

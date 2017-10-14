package com.example.singh.android_rxjava2.RxAndroid;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

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
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //using custom toolbar
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        //setup recycler view
        rvRepoList = findViewById(R.id.rvRepoList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        repoListAdapter = new RepoListAdapter(repoList);
        rvRepoList.setLayoutManager(layoutManager);
        rvRepoList.setItemAnimator(itemAnimator);
        rvRepoList.setAdapter(repoListAdapter);

        user = "manroopsingh";
        getReposFromGithub(user);



        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =  findViewById(R.id.mySearchView);

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            getReposFromGithub(query);
        }

        //hide keyboard after search
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }

    private void getReposFromGithub(String user) {
        repoList.clear();
        //make network call using RxJava observable
        RemoteDataSource.getRepos(user)
                .subscribeOn(Schedulers.io()) //makes the call on the schedulers thread
                .observeOn(AndroidSchedulers.mainThread()) //get the result back in the main thread
                //flatmap operator is used to transform the items emitted by the observable into
                //observables and them flatten the emissions into a single observable
                //in this case repolist into repos
                .flatMap(new Function<List<Repo>, Observable<Repo>>() {
                    @Override
                    public Observable<Repo> apply(@NonNull final List<Repo> repos) throws Exception {

                        //new observable created
                        Observable<Repo> repoObservable = Observable.create(new ObservableOnSubscribe<Repo>() {
                            @Override
                            public void subscribe(@NonNull ObservableEmitter<Repo> e) throws Exception {

                                //emitter is emitting each repo at a time from the repolist
                                for (Repo repo : repos) {
                                    e.onNext(repo);
                                }
                                e.onComplete();

                            }
                        });
                        return repoObservable;
                    }
                })
                //map operator is used to transform each item emitted by the observable
                .map(new Function<Repo, Repo>() {
                    @Override
                    public Repo apply(@NonNull Repo repo) throws Exception {

                        String repoName = repo.getName();
                        repo.setName("My " + repoName);
                        return repo;
                    }
                })
                //finally subscribing the observable will start emitting the items to the observer
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

                        Log.d(TAG, "onError: " + e.toString());
                        showErrorDialog(getString(R.string.api_error_title),e.toString());
                    }

                    @Override
                    public void onComplete() {

                        if(repoList.isEmpty()){
                            showErrorDialog(getString(R.string.invalid_username_title),
                                    getString(R.string.no_repos_message));
                        }
                        repoListAdapter.notifyDataSetChanged();
                        Log.d(TAG, "onComplete: ");


                    }
                });
    }


    public void showErrorDialog(String title, String error){
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(error)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                }).create();

        alertDialog.show();




    }
}

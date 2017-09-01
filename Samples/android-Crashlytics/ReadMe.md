## Crashlytics (Fabric)

Simple project to use Crashlytics in your project.

1. Add your project to the Crashlytics console.
2. Add the following code to your project

build.gradle

    buildscript {
    repositories {
        maven { url 'https://maven.fabric.io/public' }
    }

    dependencies {
        classpath 'io.fabric.tools:gradle:1.+'
    }
    } 
    apply plugin: 'com.android.application'
    apply plugin: 'io.fabric'
    
    repositories {
        maven { url 'https://maven.fabric.io/public' }
    }
    
    
activity_main.xml

    <Button
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="Force Crash!"
        android:onClick="forceCrash"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true" />


MainActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize the crashlytics lib from fabric
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
    }


    //This button click is forcing the app to crash.
    //Check your email or crashlytics console for more details about the crash.
    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

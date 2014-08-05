# libgdx-maven-archetype

This is a Maven archetype for creating [libGDX] game projects.

## Installing

The archetype is not yet available via Maven Central, so you'll have to build and install it before
you can use it to generate skeleton projects. Do that like so:

```
% git clone git://github.com/libgdx/libgdx-maven-archetype.git
% cd libgdx-maven-archetype
% mvn install
```

Once it's installed, you can delete the `libgdx-maven-archetype` directory that you checked out.
You don't need it any more.

## Creating a skeleton project

Creating a project using the archetype is accomplished like so:

```
% mvn archetype:generate \
    -DarchetypeRepository=local \
    -DarchetypeRepository=$HOME/.m2/repository \
    -DarchetypeGroupId=com.badlogic.gdx \
    -DarchetypeArtifactId=gdx-archetype \
    -DarchetypeVersion=1.2.0
```

This will then ask you a few questions:

  * Define value for property 'groupId': : **com.mytest**
  * Define value for property 'artifactId': : **mygame**
  * Define value for property 'version':  1.2.0: : **<default>**
  * Define value for property 'package':  com.mytest: : **<default>**
  * Define value for property 'JavaGameClassName': : **MyGame**

The parts in bold above are the things we typed in. You can pick whatever you want for `groupId`
and `artifactId`, though it's customary for `groupId` to be a reverse domain name for a domain that
you own, and for `artifactId` to be a simple lowercase name that identifies your project. 

`version` defaults to `1.0-SNAPSHOT` but you can make it whatever you want. It's not used anywhere,
and you're not going to be _publishing_ your game via Maven, so it doesn't really matter.

`package` will be the main Java package for your game project, and `JavaGameClassName` will be the
name of the Java class that is the entry point to your game. If you use the values we show above,
your main class will be `com.mytest.core.MyGame`. The archetype puts your game code into a package
named `core` (on top of the package you specify) because of the way the HTML backend works. You can
change it later if you want, but you'll need to do some fiddling if you use the HTML backend.

Once you enter all that info, Maven will ask you to confirm your choices and then it generates your
new skeleton game in a directory named whatever you specified for `artifactId` (in our example
that's `mygame`).

## Running your skeleton project

We'll use the names we used in the above example here, so substitute in the names you actually
used.

### Build and run the Desktop backend

You can build and run your game using the Desktop backend like this:

```
% cd mygame
% mvn integration-test -Pdesktop
```

This is pretty simple. It builds the Java code, and then unpacks some native libraries into the
right place and then runs the code.

You can also build a single jar file version of your game that you can send to friends or do
whatever you like with:

```
% cd mygame
% mvn package -Pdesktop
% java -jar desktop/target/mygame-desktop-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Build and run the HTML backend

You can build and run your game using the HTML backend like this:

```
% cd mygame
% mvn integration-test -Phtml
```

This compiles the game using GWT and then runs a local web server that serves up the compiled game
on `http://localhost:8080`. Point a web browser at that URL to test your HTML compiled game.

You can also just build the HTML version of the game so that you can copy it to a website or
whatever. This is done like so:

```
% cd mygame
% mvn package -Phtml
```

This will generate your game in `html/target/webapp`. The important files and directories in that
directory are: `assets`, `index.html` and `mygame`. The other cruft (`META-INF` and `WEB-INF`) you
can ignore, unless you want to deploy your game as a webapp to somewhere like Google App Engine.

### Build and run the Android backend

You can build your game using the Android backend and install it to a device like this:

```
% cd mygame
% mvn install -Pandroid
```

You can also easily build a signed and zipaligned APK for your Android game when you are preparing
to upload it to Google Play. You need to edit your `android/pom.xml` and change:

```
    <sign.keystore>game.keystore</sign.keystore>
    <keystore.alias>game</keystore.alias>
```

to reflect path to your keystore file and the alias of the key you will use to sign your APK. Then
you can build a signed and zipaligned APK like so:

```
% cd mygame
% mvn package -Pandroid -Psign -Dkeystore.password=foo
```

The signed and aligned APK file will be in `android/target/mygame-android-aligned.apk`.

### Build and run the iOS backend

This assumes you have [Xamarin.iOS] installed, as that is currently required to build your game for
iOS.

Building the iOS backend is currently TBD. Check back later!

## Credits

Much of this archetype was adapted from [PlayN's archetype].

[libGDX]: http://libgdx.badlogicgames.com/
[Xamarin.iOS]: http://www.xamarin.com/
[PlayN's archetype]: https://github.com/threerings/playn/tree/master/archetype

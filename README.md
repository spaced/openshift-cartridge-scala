# OpenShift Cartridge to deploy Reactive Applications

With this cartridge you can easily deploy Scala, Spray, Play and Akka applications, or any SBT based applications, on the [Openshift PaaS](https://www.openshift.com/).
using sbt launcher
## Usage

Openshift environment:

```bash
rhc app create demoreactiveapp \
http://cartreflect-claytondev.rhcloud.com/reflect?github=spaced/openshift-cartridge-scala
```

That's all! Now all that is left is to wait for the deployment to complete ;)

## Note

Deployment can sometimes be a rather slow process. Be patient with it and check on the deployment process with following command:

```bash
 ssh id_to_replace@demoreactiveapp-$yournamespace.rhcloud.com "tail -f scala/logs/scala.log"
 ```

## Deployment process

After each `git push`, `start.sh` script will be automatically called at the root of your repo.

In the template project, run `start.sh` script:

```bash
sbt @application.properties
```
    
## Setup your app
Add dependency
```
"org.scala-sbt" % "launcher-interface" % "1.0.0" % "provided",
```
and implement a Runner extends xsbti.AppMain (see also http://www.scala-sbt.org/0.13/docs/Launcher-Getting-Started.html)
Example: https://github.com/wkorfhage/sbt-launch-deployment-example/blob/master/hello.project/src/main/scala/example/HelloRunner.scala
Customize your application.properties
If you use sbt as build tool, add following to your sbt build:
```
publishTo := Some(Resolver.file("file", new File("/path/to/your/openshift_git_repo/localrepo"))
publishMavenStyle := true
```
In your application listen on the environment variable `$OPENSHIFT_SCALA_IP:$OPENSHIFT_SCALA_PORT`
    interface = System.getenv("OPENSHIFT_SCALA_IP")
    port = System.getenv("OPENSHIFT_SCALA_PORT").toInt

## How deploy:
- publish your application to localrepo folder (sbt publish)
- git push


This cartridge will embed a quick start application based on Spray [Original Repo](https://github.com/spray/spray-template). Learn more at [spray.io](http://www.spray.io).

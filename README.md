# parser-cron
simple parser for cron string

0. Install java
1. Install sbt https://www.scala-sbt.org/download.html
2. run command  
sbt 'run "*/15 0 1,11 * 1-6 /usr/bin/find"'
 
 Output: 
 ```
 $ sbt 'run "*/12 0 1,11 * 1-6 /usr/bin/find"'
[info] welcome to sbt 1.4.3 (Oracle Corporation Java 1.8.0_221)
[info] loading project definition from C:\git\cparser\parsecron\project
[info] loading settings for project parsecron from build.sbt ...
[info] set current project to cron-parser (in build file:/C:/git/cparser/parsecron/)
[info] running Main "*/12 0 1,11 * 1-6 /usr/bin/find"
minute        0 12 24 36 48
hour          0
day of month  1 11
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5 6
command       /usr/bin/find
[success] Total time: 2 s, completed Nov 23, 2020 10:00:38 PM
```

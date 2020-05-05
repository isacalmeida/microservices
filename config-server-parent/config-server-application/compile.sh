#!/usr/bin/env bash

ARTIFACT=config-server
MAINCLASS=br.edu.unoesc.configserver.application.boot.ConfigServerApplication
VERSION=1.0.0
FEATURE=../../spring-graal-native-0.6.1.RELEASE.jar
GRAALVM_DIR=C:\\GraalVM\\graalvm-ce-java11-20.0.0\\bin\\

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

rm -rf target
mkdir -p target/native-image

echo "Packaging $ARTIFACT with Maven"
mvn -DskipTests package > target/native-image/output.txt

JAR="$ARTIFACT.jar"
rm -f $ARTIFACT
echo "Unpacking $JAR"
cd target/native-image
jar -xvf ../$JAR >/dev/null 2>&1
cp -R META-INF BOOT-INF/classes

LIBPATH=`find BOOT-INF/lib | tr '\n' ';'`
CP=BOOT-INF/classes;${LIBPATH}${FEATURE}

if [ ! -f "$FEATURE" ]; then
    printf "${RED}FAILURE${NC}: $FEATURE does not exist, please build the root project before building this sample.\n"
    exit 1
fi

#echo "Generating reflection files for $ARTIFACT"
#rm -rf graal/META-INF 2>/dev/null
#mkdir -p graal/META-INF/native-image
#java -agentlib:native-image-agent=config-output-dir=graal/META-INF/native-image -cp $CP $MAINCLASS >> output.txt 2>&1 &
#PID=$!
#sleep 3
#curl -m 1 http://localhost:8080 > /dev/null 2>&1
#sleep 1 && kill $PID || kill -9 $PID

GRAALVM_VERSION=`$GRAALVM_DIR\native-image.cmd --version`
echo "Compiling $ARTIFACT with $GRAALVM_VERSION"
{ time ${GRAALVM_DIR}native-image.cmd \
  --verbose \
  --no-server \
  --no-fallback \
  --allow-incomplete-classpath \
  -H:Name=$ARTIFACT \
  -H:+ReportExceptionStackTraces \
  -Dspring.graal.verbose=true \
  -Dspring.graal.remove-unused-autoconfig=true \
  -cp $CP $MAINCLASS >> output.txt ; } 2>> output.txt

if [[ -f $ARTIFACT ]]
then
  printf "${GREEN}SUCCESS${NC}\n"
  mv ./$ARTIFACT ..
  exit 0
else
  cat output.txt
  printf "${RED}FAILURE${NC}: an error occurred when compiling the native-image.\n"
  exit 1
fi

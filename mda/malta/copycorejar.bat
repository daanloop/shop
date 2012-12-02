copy .\web\target\malta-web-1.0\WEB-INF\lib\malta-core-1.0.jar ..\..\WEB-INF\lib
copy .\web\target\malta-web-1.0\WEB-INF\lib\malta-common-1.0.jar  ..\..\WEB-INF\lib
copy .\web\target\src\net\malta\model\crud\*.java ..\..\WEB-INF\src\net\malta\model\crud
java -cp "../../WEB-INF/lib/jp.storyteller.desktop.jar;../../WEB-INF/lib/commons-httpclient-3.0.1.jar;../../WEB-INF/lib/commons-logging.jar;../../WEB-INF/lib/commons-codec-1.3.jar"  net.storyteller.desktop.HttpClientFilePostOfAndromdaCoreJarAddingToJ2eeStory http://storytellermachine.net:8080/storyteller %ECLIPSE_WORKSPACE% malta
java -jar wget.jar http://storytellermachine.net:8080/storyteller/SystemCreatesNonnsAndAttrsFromCoreJarOfJ2eeStorys.do?j2eeStory=malta result
java -cp "jp.storyteller.desktop.jar;../../WEB-INF/lib/commons-httpclient-3.0.1.jar;../../WEB-INF/lib/commons-logging.jar;../../WEB-INF/lib/commons-codec-1.3.jar;../../WEB-INF/lib/dom4j-1.6.1.jar"  net.storyteller.desktop.StorytellerCodesDownload http://storytellermachine.net:8080/storyteller %ECLIPSE_WORKSPACE%/  malta

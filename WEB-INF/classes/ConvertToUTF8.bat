rename MessageResources_ja.properties MessageResources_ja.gxt
"%JAVA_HOME%/bin/native2ascii.exe"  -encoding UTF-8 MessageResources_ja.gxt MessageResources_ja.properties
del *.gxt
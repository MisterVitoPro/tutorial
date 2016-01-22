java -jar selenium-server-standalone-2.49.1.jar -role node -hub http://127.0.0.1:4444/grid/register ^
-browser "browserName=firefox,maxInstances=5,platform=WINDOWS" ^
-browser "browserName=internet_explorer,maxInstances=2,platform=WINDOWS" -Dwebdriver.ie.driver="C:\Users\MisterVitoPro\Desktop\drivers\IEDriverServer.exe" ^
-browser "browserName=chrome,maxInstances=3,platform=WINDOWS" -Dwebdriver.chrome.driver="C:\Users\MisterVitoPro\Desktop\drivers\chromedriver.exe"
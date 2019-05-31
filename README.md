# SMART ENGINES SERVICE


* 172.30.4.201 - ip виртуалки для теста
* ssh centos@172.30.4.201 - подключиться по ssh
* pscp -P 22 c:\p.jpg centos@172.30.4.201:coding
* pscp -P 10.jar c:\p.jpg centos@172.30.4.201:coding
* autossh -M 0 -L localhost:4000:172.30.4.201:4000 centos@172.30.4.201
* autossh -M 0 -L localhost:8087:172.30.4.201:8087 centos@172.30.4.201

## Дополнительно

* netstat -natp (показать кто на каком порту (слушает))
* ps -aux | grep 6520 (вытащить более детальную инфу по PID)
* kill -9 6520 (убить процесс по PID принудительно)



#!/bin/bash
report_path=/home/fpt/logs/
logs_path=/usr/local/nginx-1.5.1/logs/
goaccess_path=/usr/local/src/GoAccess/
mv ${logs_path}access.log ${logs_path}access_$(date -d "yesterday" +"%Y%m%d").log
kill -USR1 `cat /usr/local/nginx-1.5.1/logs/nginx.pid`
cd $goaccess_path
goaccess -d -f ${logs_path}access_$(date -d "yesterday" +"%Y%m%d").log -p ~/.goaccessrc -a >$(report_path)report_$(date -d "yesterday" +"%Y%m%d").html
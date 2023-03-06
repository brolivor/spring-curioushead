#!/bin/sh

# make sure that ngrok binary is located at this path on jenkins server: /opt/ngrok
/opt/ngrok/ngrok http 192.168.1.161:8080 --log=stdout > /opt/ngrok/ngrok.log &
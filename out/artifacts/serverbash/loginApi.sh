#!/bin/bash

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json" --header "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJocm80IiwiaXNzIjoiMTI3LjAuMC4xIiwiZXhwIjoxNDYyMTk2NjQ2LCJpYXQiOjE0NjE1OTE4NDZ9.qQleuze4MqKfuL-pPigXulSklac-1xHrBYPxsno94Gs" -d "{
  \"username\": \"hro4\",
  \"password\": \"MnoPo4s2\"
}" "http://backenddev.teqplay.nl/auth/login" > ../JSON/apiLogin.json

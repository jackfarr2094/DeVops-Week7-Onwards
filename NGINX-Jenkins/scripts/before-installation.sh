#!/bin/bash
echo "-----------------------------"
echo "Starting: Before Installation"
echo "-----------------------------"

DEBUG=true

debug() {
  if [[ "$DEBUG" == "true" ]]; then
    echo -e "PRE: [DEBUG] $*"
  fi
}

info() {
  echo -e "PRE: [INFO] $*"
}

warn() {
  echo -e "PRE: [WARN] $*"
}

fatal() {
  echo -e "PRE: [FATAL] $*"
}

info "Check if /data directory exist, if not, create the directory"
mkdir -p /data
if [[ -d "/data" ]]; then
  info "Successfully Created /data directory"
fi

info "Check if /data/www directory exist, if not, create the directory"
mkdir -p /data/www
if [[ -d "/data/www" ]]; then
  info "Successfully Created /data/www directory"
fi

info "Check if /data/www/exmaple.com directory exist, if not, create the directory"
mkdir -p /data/www/example.com
if [[ -d "/data/www/example.com" ]]; then
  info "Successfully Created /data/www /example.comdirectory"
fi


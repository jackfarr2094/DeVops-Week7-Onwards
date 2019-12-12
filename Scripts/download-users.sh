#!/bin/bash

sudo apt update
sudo apt install -y openjdk-8-jdk maven mysql-server

git clone https://github.com/christophperrins/users-dependencies.git
cd users-dependencies && mvn install
cd ..

git clone https://github.com/christophperrins/users-general.git
cd users-general && mvn install
cd ..

git clone https://github.com/christophperrins/users-parent.git
cd users-parent && mvn install
cd ..

git clone https://github.com/christophperrins/users-eureka-server.git
cd users-eureka-server && mvn install
cd ..

git clone https://github.com/christophperrins/users-account.git
cd users-account && mvn install
cd ..

git clone https://github.com/christophperrins/users-token.git
cd users-token && mvn install
cd ..

git clone https://github.com/christophperrins/users-account-token-aggregation.git
cd users-account-token-aggregation && mvn install
cd ..


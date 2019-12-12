#!/bin/bash

sed -i "s/$1//g" items
sed -i '/^$/d' items


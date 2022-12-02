#! /bin/bash

DAY=$(date | awk '{print $3}')
RESDIR="src/main/resource"
COOKIE="session=[SETCOOKIEHERE]"

mkdir -p $RESDIR/day$DAY
curl --cookie $COOKIE https://adventofcode.com/2022/day/"$DAY"/input > $RESDIR/day$DAY/day$DAY.txt
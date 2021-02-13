#!/bin/bash
for arg in "$@"; do
    if [ -f $arg ];then
        echo "$arg        regular file"
    elif [ -d $arg ];then
        echo "$arg        directory"
    elif [ -f $arg ];then
        echo "$arg        excuteable file"
    elif [ -h $arg ];then
        echo "$arg        symbolic"
    else
        echo "$arg        Does not exist"
    fi
done
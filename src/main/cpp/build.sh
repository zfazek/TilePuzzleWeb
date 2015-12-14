#!/bin/sh

g++ -std=c++11 \
    swap.cc \
    util.cc \
    -lcgicc \
    -o swap.cgi && \
    sudo cp swap.cgi /usr/lib/cgi-bin/

g++ -std=c++11 \
    shuffle.cc \
    util.cc  \
    -lcgicc \
    -o shuffle.cgi && \
    sudo cp shuffle.cgi /usr/lib/cgi-bin/

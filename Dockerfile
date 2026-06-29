FROM ubuntu:latest
LABEL authors="trisai"

ENTRYPOINT ["top", "-b"]
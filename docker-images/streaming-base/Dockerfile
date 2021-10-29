FROM openjdk:11

RUN apt update && \
    apt upgrade -y && \
    apt install -y python3-pip && \
    pip3 install jinja2

COPY configure.py .

CMD ["/bin/bash"]
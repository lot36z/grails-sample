FROM ubuntu:20.04
ENV GRAILS_VERSION=4.0.3
ENV TZ=Asia/Tokyo
RUN apt-get -qq update \
    && apt-get -y install curl zip unzip tzdata openjdk-11-jdk \
    && curl -OL "https://github.com/grails/grails-core/releases/download/v${GRAILS_VERSION}/grails-${GRAILS_VERSION}.zip"
RUN unzip "grails-${GRAILS_VERSION}.zip" \
    && echo "export PATH=${PATH}:/grails-${GRAILS_VERSION}/bin" >> ~/.bash_profile \
    && . ~/.bash_profile \
    && apt-get -y install git \
    && apt-get -y autoremove \
    && apt-get -y clean \
    && rm -rf /var/lib/apt/lists/*
WORKDIR /myapp
CMD bash -c 'while :; do sleep 10; done'
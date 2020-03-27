# SPECIFY BASE IMAGE
FROM openjdk:8

RUN mkdir /home/UIAutomation
#A Directory in the base image to copy our depedencies

# Copy the Entire Code base to docker container
COPY . /home/UIAutomation

# Set the Working Directory
WORKDIR /usr/bin
ENV GRADLE_VER=4.3
#download and unzip the file
#after extracting file contents create a symbolic link so that the lengthy folder
#name is reduced to a shorter folder called gradle5
#then remove the file from container

RUN wget https://services.gradle.org/distributions/gradle-$GRADLE_VER-all.zip && \
    unzip gradle-$GRADLE_VER-all.zip && \
    ln -s gradle-$GRADLE_VER gradle5 && \
    rm gradle-$GRADLE_VER-all.zip

# Set Appropriate Environmental Variables
ENV GRADLE_HOME /usr/bin/gradle5
ENV PATH $PATH:$GRADLE_HOME/bin

WORKDIR /home/UIAutomation

CMD gradle clean test -PsuiteFile=parallelcrossbrowser.xml
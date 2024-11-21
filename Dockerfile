FROM openjdk:24-jdk-bookworm

RUN apt-get update && apt-get install -y \
  pdftk-java \
  tofrodos \
  && apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY pdftotext.jar /app/pdftotext.jar
COPY pdftotext /app/pdftotext

ENTRYPOINT ["/app/pdftotext", "/app/input.pdf"]
